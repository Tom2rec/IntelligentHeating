package com.heating.system.infrastructure.web.service.contract;

import com.heating.system.infrastructure.model.dto.FacultyDto;

import java.util.List;

public interface FacultyService {
    List<FacultyDto> getAllFaculties();
}
