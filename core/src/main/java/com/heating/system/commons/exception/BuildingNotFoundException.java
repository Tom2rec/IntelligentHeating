package com.heating.system.commons.exception;

import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@ToString
public class BuildingNotFoundException extends RuntimeException {

    public BuildingNotFoundException(String message) {
        super(message);
    }
}
