package com.udacity.jdnd.course3.critter.user.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNoFoundException extends RuntimeException {
    public EmployeeNoFoundException() {
        super("Employee not found!");
    }
}
