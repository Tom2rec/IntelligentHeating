package com.heating.system.commons.exception;

import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@ToString
public class BuildingNotFoundException extends RuntimeException {

    private final String message;

    public BuildingNotFoundException(String message) {
        this.message = message;
    }
}
