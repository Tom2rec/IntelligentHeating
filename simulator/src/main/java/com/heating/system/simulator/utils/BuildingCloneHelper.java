package com.heating.system.simulator.utils;

import com.heating.system.infrastructure.model.Building;
import org.apache.commons.lang3.SerializationUtils;

public class BuildingCloneHelper {

    public static Building clone(Building building) {
        Building clonedBuilding = SerializationUtils.clone(building);

        for (var room : clonedBuilding.getRooms()) {
            room.setId(building.getRooms().stream().filter(r -> r.getDescription().equals(room.getDescription()))
                    .findFirst().get().getId());
        }

        return clonedBuilding;
    }
}
