package com.boa.conlog.content.model.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String MethodArgumentNotValidException() {
        return "content/error/methodArgumentNotValid";
    }

    @ExceptionHandler(Exception.class)
    public String Exception() {
        return "content/error/default";
    }
}
