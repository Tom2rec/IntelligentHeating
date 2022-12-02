package com.heating.system.simulator.utils;

import com.heating.system.infrastructure.web.controller.room.temperature.dto.RoomTemperatureInfoDto;
import com.heating.system.simulator.common.CommonTemperatureInfoConsts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVHelper extends CommonTemperatureInfoConsts {

    public static void write(RoomTemperatureInfoDto roomTemperatureInfoDto) {
        File temperatureInfoFile = new File(PATH + FILE_NAME);
        boolean temperatureInfoFileNotExists = !temperatureInfoFile.exists();

        try (FileWriter fw = new FileWriter(PATH + FILE_NAME, true);
                BufferedWriter bw = new BufferedWriter(fw)) {

            if (temperatureInfoFileNotExists) {
                bw.write(getCsvHeader());
            }
            String roomTemperatureInfoDtoCsv = roomTemperatureInfoDtoToCsv(roomTemperatureInfoDto, ",");
            bw.write(roomTemperatureInfoDtoCsv);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static String getCsvHeader() {
        return "room_id,creation_date,is_radiator_on,temperature_in_celsius\n";
    }

    private static String roomTemperatureInfoDtoToCsv(RoomTemperatureInfoDto roomTemperatureInfoDto, String delimiter) {
        StringBuilder builder = new StringBuilder()
                .append(roomTemperatureInfoDto.getRoomId())
                .append(delimiter)
                .append(roomTemperatureInfoDto.getCreationDate())
                .append(delimiter)
                .append(roomTemperatureInfoDto.getIsRadiatorOn())
                .append(delimiter)
                .append(roomTemperatureInfoDto.getTemperatureInCelsius())
                .append("\n");
        return builder.toString();
    }
}
