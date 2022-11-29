package com.heating.system.simulator.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.heating.system.infrastructure.model.Building;

import java.io.File;
import java.io.IOException;

public class JSONWriter {
    public static void write(Building building, String path) {
        try {
            File infrastructureFile = new File(path);
            infrastructureFile.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(infrastructureFile, building);
            System.out.println("Infrastructure saved successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
