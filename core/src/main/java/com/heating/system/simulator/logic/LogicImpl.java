package com.heating.system.simulator.logic;

import com.heating.system.infrastructure.model.Building;
import com.heating.system.infrastructure.model.Room;
import com.heating.system.infrastructure.repository.BuildingRepository;
import com.heating.system.simulator.temperature.TemperatureService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@RequiredArgsConstructor
@Component
@Slf4j
public class LogicImpl implements Logic {

    private final TemperatureService temperatureService;
    private final BuildingRepository buildingRepository;
    @Value("${simulation.logic.min.temperature.during.classes:20}")
    private double minTemperatureDuringClasses;
    @Value("${simulation.logic.min.temperature.if.unused:15}")
    private double minTemperatureIfUnused;
    @Value("${simulation.logic.min.minutes.before.classes.to.start.heating:15}")
    private int minMinutesBeforeClassesToStartHeating;
    @Value("${simulation.logic.run.every.minutes:5}")
    private int runEveryMinutes;

    public void startSimulation() {
        log.info("Simulation started");
        executeSimulation();
        log.info("Simulation ended successfully");
    }

    private void executeSimulation() {
        buildingRepository.findAll().forEach(building -> {
                    temperatureService.updateTemperature(building);
                    regulateRadiators(building);
                }
        );
    }

    private void regulateRadiators(Building building) {
        for (var room : building.getRooms()) {
            room.setRadiatorOn(isTooLowTemperatureForReservation(room)
                    || room.getTemperatureInCelsius() < minTemperatureIfUnused);
        }
        buildingRepository.save(building);
    }

    private boolean isTooLowTemperatureForReservation(Room room) {
        var tooLowTemperature = room.getTemperatureInCelsius() < minTemperatureDuringClasses;
        var nowPlusRequiredTime =
                ZonedDateTime.now().plus(runEveryMinutes + minMinutesBeforeClassesToStartHeating, ChronoUnit.MINUTES);
        return room.getReservations().stream()
                .anyMatch(r -> tooLowTemperature && (r.getDateTo().isBefore(ZonedDateTime.now()) ||
                        r.getDateFrom().isBefore(nowPlusRequiredTime)));
    }
}

