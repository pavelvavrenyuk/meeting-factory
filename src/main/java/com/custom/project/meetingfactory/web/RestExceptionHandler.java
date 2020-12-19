package com.custom.project.meetingfactory.web;

import com.custom.project.meetingfactory.exception.EntityNotFoundException;
import com.custom.project.meetingfactory.exception.WrongParameterValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EntityErrorResponse> entityNotFound(EntityNotFoundException exc){

        EntityErrorResponse errorResponse = new EntityErrorResponse(exc.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<EntityErrorResponse> entityNotFound(WrongParameterValueException exc){

        EntityErrorResponse errorResponse = new EntityErrorResponse(exc.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
