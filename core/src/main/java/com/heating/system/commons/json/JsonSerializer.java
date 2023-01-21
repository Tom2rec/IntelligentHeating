package com.heating.system.commons.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonSerializer {

    private final static String BASE_PATH = "core/src/main/resources/json/%s";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .findAndRegisterModules();
    public static String readJsonFromFile(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(String.format(BASE_PATH, fileName))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<List<List<Float>>> deserializeBuildingWalls(String json) {
        BuildingWalls buildingWalls;
        try {
            buildingWalls = OBJECT_MAPPER.readValue(json, BuildingWalls.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return buildingWalls.walls;
    }

    public static List<List<Float>> deserializeRoomWalls(String json) {
        RoomWalls roomWalls;
        try {
            roomWalls = OBJECT_MAPPER.readValue(json, RoomWalls.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return roomWalls.walls;
    }

    private static class BuildingWalls {
        public List<List<List<Float>>> walls;
    }

    private static class RoomWalls {
        public List<List<Float>> walls;
    }
}
