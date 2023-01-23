package com.heating.system.iotdevice.mapper;

import com.heating.system.iotdevice.model.IoTUser;
import com.heating.system.iotdevice.model.dto.IoTUserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface IoTUserMapper {

    @Mapping(target = "fullName", source = "user", qualifiedByName = "toFullName")
    IoTUserDto mapToDto(IoTUser user);

    @Named("toFullName")
    default String toFullName(IoTUser user) {
        return String.join(" ", user.getFirstName(), user.getLastName());
    }
}
