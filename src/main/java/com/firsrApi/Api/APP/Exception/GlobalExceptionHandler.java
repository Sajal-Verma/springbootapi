package com.firsrApi.Api.APP.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

//@ControllerAdvice
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class , UserNotFoundException.class})
    public ResponseEntity<Map<String,Object>> handleIllegalArgumentException(IllegalArgumentException exception){
        Map<String ,Object> errorResponse = new HashMap<>();
        errorResponse.put("timestemp" , LocalDate.now());
        errorResponse.put("status" , HttpStatus.BAD_REQUEST.value());
        errorResponse.put("message" , exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
