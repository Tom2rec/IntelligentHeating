package com.heating.system.iotdevice.controller;

import com.heating.system.iotdevice.model.request.AddNewPlantRequest;
import com.heating.system.iotdevice.model.request.CreateIoTUserRequest;
import com.heating.system.iotdevice.model.request.IoTLoginRequest;
import com.heating.system.iotdevice.model.response.AddNewPlantResponse;
import com.heating.system.iotdevice.model.response.AllIoTUserPlantsResponse;
import com.heating.system.iotdevice.model.response.IoTUserInfoResponse;
import com.heating.system.iotdevice.service.IoTService;
import com.heating.system.iotdevice.service.PlantService;
import com.heating.system.user.model.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("iot")
@RequiredArgsConstructor
public class IoTController {

    private final IoTService ioTService;
    private final PlantService plantService;

    @PostMapping("/register")
    ResponseEntity<Void> registerSingleUser(@RequestBody CreateIoTUserRequest userCreateRequest) {
        ioTService.registerSingleUser(userCreateRequest);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    ResponseEntity<LoginResponse> login(@RequestBody IoTLoginRequest loginRequest) {
        return ResponseEntity.ok(ioTService.login(loginRequest));
    }

    @GetMapping("/user/{userId}")
    ResponseEntity<IoTUserInfoResponse> getUserInfo(@PathVariable("userId") UUID id) {
        return ResponseEntity.ok(ioTService.getUserInfo(id));
    }

    @GetMapping("/user/{userId}/plants")
    ResponseEntity<AllIoTUserPlantsResponse> getAllIoTUserPlants(@PathVariable("userId") UUID id) {
        return ResponseEntity.ok(new AllIoTUserPlantsResponse(plantService.getAllIoTUserPlants(id)));
    }

    @PostMapping(value = "/user/{userId}/plant")
    ResponseEntity<AddNewPlantResponse> addNewPlant(@PathVariable("userId") UUID id,
                                                    @RequestBody AddNewPlantRequest request) {
        return ResponseEntity.ok(new AddNewPlantResponse(plantService.addNewPlant(id, request)));
    }
}
