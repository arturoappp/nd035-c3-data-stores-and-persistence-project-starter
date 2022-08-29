package com.udacity.jdnd.course3.critter.pet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PetNoFoundException extends RuntimeException {
    public PetNoFoundException(String message) {
        super("Pet not found - " + message);
    }

    public PetNoFoundException() {
        super("Pet not found");
    }
}
