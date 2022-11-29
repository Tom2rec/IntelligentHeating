package com.heating.system.simulator.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heating.system.infrastructure.model.Building;

import java.nio.file.Paths;

public class JSONReader {
    public static Building readBuilding(String path) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            Building building = mapper.readValue(Paths.get(path).toFile(), Building.class);

            System.out.println("Building read successfully");

            return building;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
