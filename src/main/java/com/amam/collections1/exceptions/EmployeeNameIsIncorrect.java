package com.amam.collections1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeNameIsIncorrect extends RuntimeException {
    public EmployeeNameIsIncorrect(String message) {
        super(message);
    }
}
