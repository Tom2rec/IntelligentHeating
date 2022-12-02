package com.heating.system.simulator;

import com.heating.system.infrastructure.model.Building;
import com.heating.system.infrastructure.model.Room;
import com.heating.system.infrastructure.model.room.temperature.model.RoomTemperatureInfo;
import com.heating.system.infrastructure.model.room.temperature.repository.RoomTemperatureInfoRepository;
import com.heating.system.infrastructure.web.controller.room.temperature.dto.RoomTemperatureInfoMapper;
import com.heating.system.simulator.physics.ChangeStateFunction;
import com.heating.system.simulator.utils.BuildingCloneHelper;
import com.heating.system.simulator.utils.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Consumer;

@Service
public class TemperatureService {

    private static RoomTemperatureInfoRepository roomTemperatureInfoRepository;

    @Autowired
    public TemperatureService(RoomTemperatureInfoRepository roomTemperatureInfoRepository) {
        TemperatureService.roomTemperatureInfoRepository = roomTemperatureInfoRepository;
    }

    public static Building updateTemperature(Building building, LocalDateTime time, int minutesFromLastChange) {
        Building updatedBuilding = changeTemperatureInBuilding(building, minutesFromLastChange);
        saveTemperatureInfo(updatedBuilding, time, r -> roomTemperatureInfoRepository.save(r));
        saveTemperatureInfo(updatedBuilding, time, r -> CSVHelper.write(RoomTemperatureInfoMapper.INSTANCE.toDto(r)));
        return updatedBuilding;
    }

    private static Building changeTemperatureInBuilding(Building building, int minutesFromLastChange) {
        Building buildingCopy = BuildingCloneHelper.clone(building);
        for (var room : buildingCopy.getRooms()) {
            List<Room> neighbours = buildingCopy.getRooms()
                    .stream()
                    .filter(r -> room.getNeighbourRoomIds().contains(r.getId()))
                    .toList();
            room.setTemperatureInCelsius(
                    ChangeStateFunction.updateTemperature(room, neighbours, minutesFromLastChange));
        }
        return buildingCopy;
    }

    private static void saveTemperatureInfo(Building building, LocalDateTime time,
            Consumer<RoomTemperatureInfo> persistenceMethod) {
        saveTemperatureInfoUsing(building, time, persistenceMethod);
    }

    private static void saveTemperatureInfoUsing(Building building, LocalDateTime time,
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
