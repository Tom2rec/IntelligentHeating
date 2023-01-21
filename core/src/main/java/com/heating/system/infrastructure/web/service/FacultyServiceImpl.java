package com.heating.system.infrastructure.web.service;

import com.heating.system.infrastructure.mapper.FacultyMapper;
import com.heating.system.infrastructure.model.dto.FacultyDto;
import com.heating.system.infrastructure.repository.FacultyRepository;
import com.heating.system.infrastructure.web.service.contract.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;
    private final FacultyMapper facultyMapper;

    @Override
    public List<FacultyDto> getAllFaculties() {
        return facultyRepository.findAll().stream()
                .map(facultyMapper::mapFacultyToDto)
                .toList();
    }
}
