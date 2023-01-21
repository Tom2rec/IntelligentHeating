package com.heating.system.user.exception;

import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@ToString
public class LogInException extends RuntimeException {

    private final String message;

    public LogInException(String message) {
        this.message = message;
    }
}
