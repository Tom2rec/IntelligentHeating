package com.heating.system.infrastructure.web.controller.room.temperature.service;

import com.heating.system.infrastructure.model.room.temperature.model.RoomTemperatureInfo;
import com.heating.system.infrastructure.model.room.temperature.repository.RoomTemperatureInfoRepository;
import com.heating.system.infrastructure.web.controller.room.temperature.dto.RoomTemperatureInfoDto;
import com.heating.system.infrastructure.web.controller.room.temperature.dto.RoomTemperatureInfoMapper;
import com.heating.system.infrastructure.web.controller.room.temperature.response.RoomAllTemperatureInfo;
import com.heating.system.infrastructure.web.controller.room.temperature.service.contract.RoomTemperatureInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RoomTemperatureInfoServiceImpl implements RoomTemperatureInfoService {

    private final RoomTemperatureInfoRepository roomTemperatureInfoRepository;

    @Override public ResponseEntity<RoomAllTemperatureInfo> getRoomTemperatureInfoForPeriod(UUID id, LocalDateTime from,
            LocalDateTime to) {
        List<RoomTemperatureInfo> roomAllTemperatureInfo =
                roomTemperatureInfoRepository.findByRoomIdAndCreationDateBetween(id, from, to);

        List<RoomTemperatureInfoDto> roomTemperatureInfoDtos = roomAllTemperatureInfo.stream().map(
                RoomTemperatureInfoMapper.INSTANCE::toDto).toList();
        return ResponseEntity.ok(new RoomAllTemperatureInfo(roomTemperatureInfoDtos));
    }
}
