package com.myprojects.financecontrol.controllers.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.myprojects.financecontrol.DTO.CustomError;
import com.myprojects.financecontrol.services.excepetions.DatabaseException;
import com.myprojects.financecontrol.services.excepetions.ForbiddenExcepetion;
import com.myprojects.financecontrol.services.excepetions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ForbiddenExcepetion.class)
    public ResponseEntity<CustomError> resourceNotFound (ForbiddenExcepetion e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.FORBIDDEN; 
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomError> database (DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST; 
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    } 

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound (ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND; 
        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
