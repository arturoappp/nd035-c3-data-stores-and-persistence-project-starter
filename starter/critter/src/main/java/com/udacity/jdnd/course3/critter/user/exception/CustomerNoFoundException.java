package com.udacity.jdnd.course3.critter.user.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNoFoundException extends RuntimeException {
    public CustomerNoFoundException(String message) {
        super("Customer/Owner not found - "+message);
    }

    public CustomerNoFoundException() {
        super("Customer/Owner not found");
    }
}
