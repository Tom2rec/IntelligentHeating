package com.heating.system.simulator.physics;

import com.heating.system.infrastructure.model.Room;

import java.util.List;

/**
 * <a href="https://cdn.discordapp.com/attachments/827121426464636958/1044680866456141844/Note_22_Nov_2022.pdf">resources</a>
 */
public class ChangeStateFunction {

    /*
     * Solar radiation power in W/m^2
     */
    private static final double P_prom = 1367;

    /*
     * Outdoor temperature in Kelvin degrees
     */
    private static final double T_zew = toKelvin(8.0);

    public static double updateTemperature(Room room, List<Room> neighbours, int minutesFromLastChange) {
        double outdoorSurface = 0;

        if (room.getNeighbourRoomIds().size() == 1) {
            outdoorSurface += room.getConnectedWallWidthInMeters() * room.getHeightInMeters();
        }
        outdoorSurface += room.getNotConnectedWallLengthInMeters() * 2 * room.getHeightInMeters();

        double room_U = room.getThermalConductivity() / room.getWallThickness();
        double room_Volume = room.getHeightInMeters() * room.getNotConnectedWallLengthInMeters() * room.getConnectedWallWidthInMeters();

        double calculatedTemperature = (room.getRadiatorPowerInWattsPerSquareMeters() + P_prom * outdoorSurface * room_U +
                room_U * outdoorSurface * (toKelvin(T_zew) - toKelvin(room.getTemperatureInCelsius())) +
                calculateNeighbourImpact(room, neighbours)) * minutesFromLastChange * 60 /
                (2.5 * room.getRadiatorPowerInWattsPerSquareMeters() * room_Volume) + room.getTemperatureInCelsius();

        return toCelsius(calculatedTemperature);
    }

    private static double calculateNeighbourImpact(Room room, List<Room> neighbours) {
        double result = 0;

        for (var neighbour : neighbours) {
            result += room.getConnectedWallWidthInMeters() *
                    (toKelvin(neighbour.getTemperatureInCelsius()) - toKelvin(room.getTemperatureInCelsius())) *
                    room.getThermalConductivity() / (room.getWallThickness() + neighbour.getWallThickness());
        }

        return result;
    }

    private static double toKelvin(double temperatureInCelsius) {
        return temperatureInCelsius + 273.15;
    }

    private static double toCelsius(double temperatureInKalvin) {
        return temperatureInKalvin - 273.15;
    }
}
