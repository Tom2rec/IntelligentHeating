package com.heating.system.simulator;

import com.heating.system.infrastructure.model.Building;
import com.heating.system.simulator.common.CommonConsts;
import com.heating.system.simulator.utils.JSONReader;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
public class Simulation extends CommonConsts {

    private int gapBetweenCheckingTemperatureInMinutes;
    private Building building;

    public static Simulation createDefaultSimulation() {
        Building building = JSONReader.readBuilding(PATH + FILE_NAME);
        return new Simulation(5, building);
    }

    public void start() {
        showStartBanner();
        executeSimulation();
        showEndBanner();
    }

    private void executeSimulation() {
        //        int simulationCycles = simulationLengthInDays * 24 * 60 / gapBetweenCheckingTemperatureInMinutes;
        int simulationCycles = 4;
        LocalDateTime startTime = LocalDateTime.now();
        for (int i = 0; i < simulationCycles; i++) {
            building = TemperatureService.updateTemperature(building,
                    startTime.plus((long) i * gapBetweenCheckingTemperatureInMinutes, ChronoUnit.MINUTES),
                    gapBetweenCheckingTemperatureInMinutes);
        }
    }

    private static void showStartBanner() {
        System.out.println();
        System.out.println(
                "  _____ __             __  _                     _                 __      __  _           \n" +
                        "  / ___// /_____ ______/ /_(_)___  ____ _   _____(_)___ ___  __  __/ /___ _/ /_(_)___  ____ \n"
                        +
                        "  \\__ \\/ __/ __ `/ ___/ __/ / __ \\/ __ `/  / ___/ / __ `__ \\/ / / / / __ `/ __/ / __ \\/"
                        + " __ \\\n"
                        +
                        " ___/ / /_/ /_/ / /  / /_/ / / / / /_/ /  (__  ) / / / / / / /_/ / / /_/ / /_/ / /_/ / / / /\n"
                        +
                        "/____/\\__/\\__,_/_/   \\__/_/_/ /_/\\__, /  /____/_/_/ /_/ /_/\\__,_/_/\\__,"
                        + "_/\\__/_/\\____/_/ /_/ \n"
                        +
                        "                                /____/                                                      ");
        System.out.println();
    }

    private void showEndBanner() {
        System.out.println();
        System.out.println("   _____ _                 __      __  _                ______          __         __\n" +
                "  / ___/(_)___ ___  __  __/ /___ _/ /_(_)___  ____     / ____/___  ____/ /__  ____/ /\n" +
                "  \\__ \\/ / __ `__ \\/ / / / / __ `/ __/ / __ \\/ __ \\   / __/ / __ \\/ __  / _ \\/ __  / \n" +
                " ___/ / / / / / / / /_/ / / /_/ / /_/ / /_/ / / / /  / /___/ / / / /_/ /  __/ /_/ /  \n" +
                "/____/_/_/ /_/ /_/\\__,_/_/\\__,_/\\__/_/\\____/_/ /_/  /_____/_/ /_/\\__,_/\\___/\\__,_/   \n" +
                "                                                                                     ");
        System.out.println();
    }
}
