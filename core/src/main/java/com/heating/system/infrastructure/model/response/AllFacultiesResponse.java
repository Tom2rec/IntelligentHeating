package com.heating.system.infrastructure.model.response;

import com.heating.system.infrastructure.model.dto.FacultyDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AllFacultiesResponse {
    private List<FacultyDto> faculties;
}
