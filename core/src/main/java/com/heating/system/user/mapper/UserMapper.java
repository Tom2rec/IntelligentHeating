package com.heating.system.user.mapper;

import com.heating.system.user.model.User;
import com.heating.system.user.model.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "fullName", source = "user", qualifiedByName = "toFullName")
    UserDto mapToDto(User user);

    @Named("toFullName")
    default String toFullName(User user) {
        return String.join(" ", user.getFirstName(), user.getLastName());
    }
}
