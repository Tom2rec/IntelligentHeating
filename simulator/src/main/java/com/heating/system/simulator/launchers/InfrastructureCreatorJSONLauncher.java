package com.heating.system.simulator.launchers;

import com.heating.system.infrastructure.model.Building;
import com.heating.system.infrastructure.model.Faculty;
import com.heating.system.infrastructure.model.Room;
import com.heating.system.simulator.launchers.config.InfrastructureConsts;
import com.heating.system.simulator.utils.JSONWriter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InfrastructureCreatorJSONLauncher extends InfrastructureConsts {

    public static void main(String[] args) {
        Building building = createDefaultBuilding();
        JSONWriter.write(building, PATH + FILE_NAME);
    }

    private static Building createDefaultBuilding() {
        return Building.builder()
                .id(UUID.randomUUID())
                .faculty(
                        Faculty.builder().id(UUID.randomUUID()).name("EAIiIB").build()
                )
                .description("C2")
                .rooms(createRooms())
                .build();
    }

    private static List<Room> createRooms() {
        List<Room> rooms = new ArrayList<>(ROOM_NUMBER);

        for (int i = 1; i <= ROOM_NUMBER; i++) {
            Room room = Room.builder()
                    .id(UUID.randomUUID())
                    .description("C2:10" + i)
                    .neighbourRoomIds(new ArrayList<>())
                    .connectedWallWidthInMeters(CONNECTED_WALL_WIDTH_IN_METERS)
                    .creationDate(LocalDateTime.now())
                    .temperatureInCelsius(INITIAL_TEMPERATURE_IN_CELSIUS)
                    .isRadiatorOn(true)
                    .radiatorPowerInWattsPerSquareMeters(RADIATOR_POWER_IN_WATTS_PER_SQUARE_METERS)
                    .wallThickness(0.2)
                    .heightInMeters(HEIGHT_IN_METERS)
                    .thermalConductivity(THERMAL_CONDUCTIVITY)
                    .notConnectedWallLengthInMeters(NOT_CONNECTED_WALL_LENGTH_IN_METERS)
                    .build();

            if (i > 1) {
                room.getNeighbourRoomIds().add(rooms.get(i - 2).getId());
                rooms.get(i - 2).getNeighbourRoomIds().add(room.getId());
            }
            rooms.add(room);
        }

        return rooms;
    }
}
