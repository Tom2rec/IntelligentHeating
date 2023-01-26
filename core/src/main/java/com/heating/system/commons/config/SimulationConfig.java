package com.heating.system.commons.config;

import com.heating.system.simulator.logic.Logic;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class SimulationConfig {

    private final Logic logic;

    @Scheduled(cron = "${simulation.cron}")
    public void startSimulation() {
        logic.startSimulation();
    }
}
