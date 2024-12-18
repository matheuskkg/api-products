package com.api.handlers;

import com.api.dtos.response.ErrorResponse;
import com.api.exceptions.UniqueConstraintViolation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(UniqueConstraintViolation.class)
    public ResponseEntity handleUniqueConstraintViolation(UniqueConstraintViolation e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(e.getOrigin() + " uniqueness violation.", e.getMessage()));
    }

}
