package com.boa.conlog.common.exception;

import com.boa.conlog.ott.exception.OttNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String MethodArgumentNotValidException() {
        return "content/error/methodArgumentNotValid";
    }

    @ExceptionHandler(OttNotFoundException.class)
    public String ottNotFoundException(OttNotFoundException exception, Model model){

        model.addAttribute("exception", exception);

        return "ott/error/notFound";
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public String noResourceFoundException(NoResourceFoundException exception, Model model){
        model.addAttribute("exception", exception);

        return "ott/error/notFound";
    }

    @ExceptionHandler(Exception.class)
    public String Exception() {
        return "content/error/default";
    }
}
