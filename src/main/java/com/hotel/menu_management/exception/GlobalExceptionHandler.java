package com.hotel.menu_management.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleException(ResourceNotFoundException ex) {
        return ex.getMessage();
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidationException(MethodArgumentNotValidException ex) {

        return ex.getBindingResult()
                 .getFieldError()
                 .getDefaultMessage();
    }

}
