package com.example.fibonacci.exception;

import com.example.fibonacci.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionAdvice  {
    private Logger logger = LoggerFactory.getLogger(Controller.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException() {
        logger.warn("Incorrect user input");
        return new ResponseEntity<>("Incorrect param", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}