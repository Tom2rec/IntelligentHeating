package com.heating.system.infrastructure.mapper;

import com.heating.system.infrastructure.model.Faculty;
import com.heating.system.infrastructure.model.dto.FacultyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FacultyMapper {
    @Mapping(target = "facultyId", source = "id")
    FacultyDto mapFacultyToDto(Faculty faculty);
}
