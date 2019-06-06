package com.stackroute.controller;

import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class TrackExceptionController {

    @ExceptionHandler(TrackAlreadyExistsException.class)
    public final ResponseEntity<Object> exeption(TrackAlreadyExistsException e){
        return new ResponseEntity<>("Track already exists",HttpStatus.ALREADY_REPORTED);
        }

    @ExceptionHandler(TrackNotFoundException.class)
    public final ResponseEntity<Object> exception(TrackNotFoundException e){
      return new ResponseEntity<>("Track does not exist",HttpStatus.NOT_FOUND);
    }

}
