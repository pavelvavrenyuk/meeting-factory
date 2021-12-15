package com.learning.meetingfactory.web;

import com.learning.meetingfactory.exception.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String VALIDATION_ERROR = "Validation error";

    @ExceptionHandler
    public ResponseEntity<EntityErrorResponse> entityNotFound(EntityNotFoundException exc){

        EntityErrorResponse errorResponse = new EntityErrorResponse(exc.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<EntityErrorResponse> handleConstraintViolation(ConstraintViolationException ex) {
        log.debug("{} was thrown", ex.getClass(), ex);

        List<String> messages = ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());

        return new ResponseEntity<>(
                new EntityErrorResponse(VALIDATION_ERROR + ": " + messages),
                HttpStatus.BAD_REQUEST
        );
    }


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        log.debug("{} was thrown", ex.getClass(), ex);

        //Get all fields errors
        List<String> errors = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        String errorsStr = String.join("; ", errors);
        return new ResponseEntity<>(new EntityErrorResponse(errorsStr), HttpStatus.BAD_REQUEST);
    }

}
