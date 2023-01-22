package com.heating.system.commons.exception;

import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@ToString
public class InvalidDatesException extends RuntimeException {

    public InvalidDatesException(String message) {
        super(message);
    }
}
