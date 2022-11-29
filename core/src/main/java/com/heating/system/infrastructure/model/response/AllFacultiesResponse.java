package com.heating.system.infrastructure.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class AllFacultiesResponse {
    private UUID facultyId;
    private String name;
}
