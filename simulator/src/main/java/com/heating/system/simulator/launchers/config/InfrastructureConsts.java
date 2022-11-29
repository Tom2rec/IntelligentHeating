package com.heating.system.simulator.launchers.config;

import com.heating.system.simulator.common.CommonConsts;

public abstract class InfrastructureConsts extends CommonConsts {
    protected static final int ROOM_NUMBER = 6;
    protected static final double CONNECTED_WALL_WIDTH_IN_METERS = 6;
    protected static final double INITIAL_TEMPERATURE_IN_CELSIUS = 16;
    protected static final double RADIATOR_POWER_IN_WATTS_PER_SQUARE_METERS = 300;
    protected static final double HEIGHT_IN_METERS = 2.5;
    protected static final double THERMAL_CONDUCTIVITY = 0.26;
    protected static final double NOT_CONNECTED_WALL_LENGTH_IN_METERS = 10;

}
