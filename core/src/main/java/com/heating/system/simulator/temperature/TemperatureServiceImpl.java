package com.heating.system.simulator.temperature;

import com.heating.system.infrastructure.model.Building;
import com.heating.system.infrastructure.model.Room;
import com.heating.system.infrastructure.model.room.temperature.model.RoomTemperatureInfo;
import com.heating.system.infrastructure.model.room.temperature.repository.RoomTemperatureInfoRepository;
import com.heating.system.simulator.simulation.Simulation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Service
public class TemperatureServiceImpl implements TemperatureService {

    private RoomTemperatureInfoRepository roomTemperatureInfoRepository;

    private Simulation simulation;

    @Value("${simulation.calculation.length.minutes:20}")
    private int simulationLengthInMinutes;

    public TemperatureServiceImpl(RoomTemperatureInfoRepository roomTemperatureInfoRepository, Simulation simulation
    ) {
        this.roomTemperatureInfoRepository = roomTemperatureInfoRepository;
        this.simulation = simulation;
    }

    public void updateTemperature(Building building) {
        changeTemperatureInBuilding(building, simulationLengthInMinutes);
        saveTemperatureInfo(building, LocalDateTime.now(), r -> roomTemperatureInfoRepository.save(r));
    }

    private void changeTemperatureInBuilding(Building building, int simulationLengthInMinutes) {
        Map<Room, Double> roomToTemperature = new HashMap<>();
        for (var room : building.getRooms()) {
            roomToTemperature.put(room, simulation.changeState(room, room.getNeighbourRooms(),
                    simulationLengthInMinutes));
        }
        roomToTemperature.forEach(Room::setTemperatureInCelsius);
    }

    private void saveTemperatureInfo(Building building, LocalDateTime time,
            Consumer<RoomTemperatureInfo> persistenceMethod) {
        saveTemperatureInfoUsing(building, time, persistenceMethod);
    }

    private void saveTemperatureInfoUsing(Building building, LocalDateTime time,
            Consumer<RoomTemperatureInfo> persistenceMethod) {
        for (var room : building.getRooms()) {
            RoomTemperatureInfo roomTemperatureInfo = RoomTemperatureInfo.builder()
                    .creationDate(time)
                    .temperatureInCelsius(room.getTemperatureInCelsius())
                    .isRadiatorOn(room.isRadiatorOn())
                    .roomId(room.getId())
                    .build();

            persistenceMethod.accept(roomTemperatureInfo);
        }
    }
}
