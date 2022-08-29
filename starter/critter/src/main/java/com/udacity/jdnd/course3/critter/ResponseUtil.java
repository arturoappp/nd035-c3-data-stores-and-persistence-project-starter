package com.udacity.jdnd.course3.critter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseUtil {

    public static <T> ResponseEntity<T> okOrNotFound(T result) {
        if (result == null) {
            return new ResponseEntity<T>(result, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<T>(result, HttpStatus.OK);
    }

    public static <T> ResponseEntity<List<T>> okOrNotFound(List<T> result) {
        if (result == null || result.isEmpty()) {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
