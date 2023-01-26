package com.heating.system.simulator.temperature;

import com.heating.system.infrastructure.model.Building;

public interface TemperatureService {

    void updateTemperature(Building building);
}
