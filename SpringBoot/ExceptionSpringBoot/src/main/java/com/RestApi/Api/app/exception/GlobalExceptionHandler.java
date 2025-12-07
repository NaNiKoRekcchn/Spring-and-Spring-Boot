package com.RestApi.Api.app.exception;

import com.RestApi.Api.app.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    //    EXCEPTION HANDLING METHOD
    @ExceptionHandler({
            IllegalArgumentException.class,
            NullPointerException.class
    }) // ye wali exception jaha jaha aaye gi , spring boot ye nihe wale method ko trigger kar de ga.
    public ResponseEntity<Map<String, Object>> handleIllegalArgumentException(
            Exception exception
    ){
        logger.error("Error when Finding User...",exception);
        Map<String , Object> exceptionResponse = new HashMap<>();
        exceptionResponse.put("timeStamp : ", LocalDateTime.now());
        exceptionResponse.put("Status : ", HttpStatus.BAD_REQUEST.value());
        exceptionResponse.put("error : ","Bad request");
        exceptionResponse.put("Message : ",exception.getMessage());

        return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<Map<String,Object>> handleHttpMethodNotFound(Exception e){
        Map<String,Object> response = new HashMap<>();
        response.put("timeStamp",LocalDateTime.now());
        response.put("status",HttpStatus.METHOD_NOT_ALLOWED.value());
        response.put("error","Invalid Method");
        response.put("message",e.getMessage());

        return  new ResponseEntity<>(response,HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleUserNotFoundException(Exception e){
        Map<String,Object> response = new HashMap<>();
        response.put("timeStamp",LocalDateTime.now());
        response.put("status",HttpStatus.NOT_FOUND.value());
        response.put("error","User Not Found");
        response.put("message",e.getMessage());

        return  new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
