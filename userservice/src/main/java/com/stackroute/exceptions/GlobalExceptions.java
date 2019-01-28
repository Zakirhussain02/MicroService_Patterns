package com.stackroute.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptions {

        @ExceptionHandler(UserNotFoundException.class)
        public ResponseEntity handleMuzixNotFoundException(final UserNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

        //Exception handler to handle Muzix already exists exceptions
        @ExceptionHandler(UserAlreadyExistsException.class)
        public ResponseEntity handleMuzixAlreadyExistsException(final UserAlreadyExistsException e){
            return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
    }


