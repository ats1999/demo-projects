package com.todo.inmemory.configurations;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.todo.inmemory.exceptions.UnprocessableEntityHttpException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
        UnprocessableEntityHttpException.class
    })
    protected ResponseEntity < Object > handleException(Exception ex){
    		return new ResponseEntity<Object>(ex.getMessage(),HttpStatus.UNPROCESSABLE_ENTITY);
    }

}