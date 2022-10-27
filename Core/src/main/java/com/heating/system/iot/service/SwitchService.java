package com.heating.system.iot.service;

import com.heating.system.iot.model.Status;

import java.util.UUID;

public interface SwitchService {

    Status switchON(UUID iotId);

    Status switchOFF(UUID iotId);
}
