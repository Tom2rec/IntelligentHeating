package com.heating.system.simulator.simulation;

import com.heating.system.infrastructure.model.Room;

import java.util.List;

public interface Simulation {

    double changeState(Room room, List<Room> neighbours, int simulationLengthInMinutes);
}
