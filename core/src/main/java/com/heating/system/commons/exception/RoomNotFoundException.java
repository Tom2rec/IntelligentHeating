package com.heating.system.commons.exception;

import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@ToString
public class RoomNotFoundException extends RuntimeException {


    public RoomNotFoundException(String message) {
        super(message);
    }
}
