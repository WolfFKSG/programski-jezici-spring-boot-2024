package com.example.spring_dan1.error;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionModel handleDataIntegrityViolationException (DataIntegrityViolationException e, HttpServletRequest request) {
        ExceptionModel model = new ExceptionModel();
        model.setName(e.getClass().getSimpleName());
        model.setPath(request.getServletPath());
        model.setMessage("Data integrity was breached.");
        return model;
    }

    @ExceptionHandler(Exception.class)                                          //biramo koju klasu hocemo da uhvatimo( mozemo sve ovako)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)                           //doslo je do internal server errora
    public ExceptionModel handleException(Exception e, HttpServletRequest request) {    //ispisujemo sta je message
        ExceptionModel model = new ExceptionModel();
        model.setName(e.getClass().getSimpleName());
        model.setPath(request.getServletPath());
        model.setMessage(e.getMessage());
        return model;
        }
    }

