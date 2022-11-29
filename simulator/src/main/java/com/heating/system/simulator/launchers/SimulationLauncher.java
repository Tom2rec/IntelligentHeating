package com.heating.system.simulator.launchers;

import com.heating.system.App;
import com.heating.system.simulator.Simulation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimulationLauncher {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        Simulation simulation = Simulation.createDefaultSimulation();
        simulation.start();
    }
}
