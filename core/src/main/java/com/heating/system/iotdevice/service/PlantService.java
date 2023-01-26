package com.heating.system.iotdevice.service;

import com.heating.system.commons.exception.PlantNotFoundException;
import com.heating.system.commons.exception.UserNotFoundException;
import com.heating.system.iotdevice.mapper.PlantMapper;
import com.heating.system.iotdevice.model.Plant;
import com.heating.system.iotdevice.model.dto.PlantDto;
import com.heating.system.iotdevice.model.request.AddNewPlantRequest;
import com.heating.system.iotdevice.model.request.UpdatePlantRequest;
import com.heating.system.iotdevice.repository.IoTUserRepository;
import com.heating.system.iotdevice.repository.PlantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlantService {

    private final PlantRepository plantRepository;
    private final PlantMapper plantMapper;
    private final IoTUserRepository ioTUserRepository;

    public List<PlantDto> getAllIoTUserPlants(UUID id) {
        return plantRepository.getPlantsByUser_Id(id).stream()
                .map(plantMapper::mapPlantToDto)
                .toList();
    }

    public PlantDto addNewPlant(UUID id, AddNewPlantRequest request) {
        var user = ioTUserRepository.getUserById(id)
                .orElseThrow(() -> new UserNotFoundException("IoT user not found!"));

        Plant plant;
        var plantOpt = plantRepository.getPlantBySensorName(request.getSensorName());
        if(plantOpt.isPresent()) {
            plant = plantOpt.get();
            plant.setUser(user);
        } else {
            plant = new Plant();
            plant.setLocation(request.getLocation());
            plant.setFamiliarName(request.getFamiliarName());
            plant.setSensorName(request.getSensorName());
            plant.setMinTemperature(request.getMinTemperature());
            plant.setMaxTemperature(request.getMaxTemperature());
            plant.setMinHumidity(request.getMinHumidity());
            plant.setMaxHumidity(request.getMaxHumidity());
            plant.setUser(user);

            var pushIntervalInMinutes = request.getPushIntervalInMinutes();
            plant.setPushIntervalInMinutes(pushIntervalInMinutes != null ? pushIntervalInMinutes : 5);
        }
        var createdPlant = plantRepository.saveAndFlush(plant);

        return plantMapper.mapPlantToDto(createdPlant);
    }

    public void deletePlant(UUID userId, Long plantId) {
        ioTUserRepository.getUserById(userId)
                .orElseThrow(() -> new UserNotFoundException("IoT user not found!"));
        var plant = plantRepository.getPlantById(plantId)
                .orElseThrow(() -> new PlantNotFoundException("Plant not found!"));
        plantRepository.delete(plant);
    }

    public PlantDto updatePlant(UUID userId, Long plantId, UpdatePlantRequest request) {
        var plant = plantRepository.getPlantByIdAndUser_Id(plantId, userId)
                .orElseThrow(() -> new PlantNotFoundException("Plant not found!"));

        if(request.getLocation() != null) {
            plant.setLocation(request.getLocation());
        }
        if(request.getFamiliarName() != null) {
            plant.setFamiliarName(request.getFamiliarName());
        }
        if(request.getSensorName() != null) {
            plant.setSensorName(request.getSensorName());
        }
        if(request.getMinTemperature() != null) {
            plant.setMinTemperature(request.getMinTemperature());
        }
        if(request.getMaxTemperature() != null) {
            plant.setMaxTemperature(request.getMaxTemperature());
        }
        if(request.getMinHumidity() != null) {
            plant.setMinHumidity(request.getMinHumidity());
        }
        if(request.getMaxHumidity() != null) {
            plant.setMaxHumidity(request.getMaxHumidity());
        }
        if(request.getPushIntervalInMinutes() != null) {
            plant.setPushIntervalInMinutes(request.getPushIntervalInMinutes());
        }

        plantRepository.save(plant);
        return plantMapper.mapPlantToDto(plant);
    }
}
