package com.heating.system.simulator.simulation;

import com.heating.system.infrastructure.model.Room;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HeatingSimulation implements Simulation {

    /*
     * Atmospheric Pressure
     */
    @Value("${simulation.atmospheric.pressure:98000}")
    private double P_atm;

    /*
     * Outdoor temperature in Kelvin degrees
     */
    @Value("${simulation.outside.temperature:15}")
    private double T_zew;

    public double changeState(Room room, List<Room> neighbours, int simulationLengthInMinutes) {
        double outdoorSurface = 0;
        if (room.getNeighbourRooms().size() < 3) {
            outdoorSurface += room.getConnectedWallWidthInMeters() * room.getHeightInMeters();
        }
        outdoorSurface += room.getNotConnectedWallLengthInMeters() * 2 * room.getHeightInMeters();

        double room_U = room.getThermalConductivity() / room.getWallThickness();
        double room_Volume = room.getHeightInMeters() * room.getNotConnectedWallLengthInMeters()
                * room.getConnectedWallWidthInMeters();
        double insideStaffFactor = 0.4;
        double conditionalRadiatorPower = room.isRadiatorOn() ? room.getRadiatorPowerInWattsPerSquareMeters() : 0;

        double calculatedTemperature = (
                ((conditionalRadiatorPower +
                        room_U * outdoorSurface * (toKelvin(T_zew) - toKelvin(room.getTemperatureInCelsius())) +
                        calculateNeighbourImpact(room, neighbours)) * simulationLengthInMinutes * 60) /
                        (2.5 * P_atm * room_Volume) * insideStaffFactor) + toKelvin(room.getTemperatureInCelsius());

        return toCelsius(calculatedTemperature);
    }

    private double calculateNeighbourImpact(Room room, List<Room> neighbours) {
        double result = 0;

        for (var neighbour : neighbours) {
            if (neighbour.getFloor().getFloorNumber().equals(room.getFloor().getFloorNumber())) {
                result += room.getConnectedWallWidthInMeters() * room.getHeightInMeters() *
                        (toKelvin(neighbour.getTemperatureInCelsius()) - toKelvin(room.getTemperatureInCelsius())) *
                        (room.getThermalConductivity() / (room.getWallThickness() + neighbour.getWallThickness()));
            } else if (neighbour.getFloor().getFloorNumber().equals(room.getFloor().getFloorNumber() - 1)
                    || neighbour.getFloor().getFloorNumber().equals(room.getFloor().getFloorNumber() + 1)) {
                result += room.getConnectedWallWidthInMeters() * room.getNotConnectedWallLengthInMeters() *
                        (toKelvin(neighbour.getTemperatureInCelsius()) - toKelvin(room.getTemperatureInCelsius())) *
                        (room.getThermalConductivity() / (room.getWallThickness() + neighbour.getWallThickness()));
            }
        }

        return result;
    }

    private double toKelvin(double temperatureInCelsius) {
        return temperatureInCelsius + 273.15;
    }

    private double toCelsius(double temperatureInKalvin) {
        return temperatureInKalvin - 273.15;
    }
}
