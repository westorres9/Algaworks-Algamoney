package com.algaworks.algamoney.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.algaworks.algamoney.services.exceptions.DatabaseException;
import com.algaworks.algamoney.services.exceptions.ResourceNotFoundException;
import com.algaworks.algamoney.services.exceptions.ValidationException;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    public static class Error {

        private String developerMessage;
        private String userMessage;

        public Error(String userMessage, String developerMessage) {
            this.userMessage = userMessage;
            this.developerMessage = developerMessage;
        }

        public String getDeveloperMessage() {
            return developerMessage;
        }

        public String getUserMessage() {
            return userMessage;
        }

        public void setDeveloperMessage(String developerMessage) {
            this.developerMessage = developerMessage;
        }

        public void setUserMessage(String userMessage) {
            this.userMessage = userMessage;
        }
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Database exception");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Resource not found");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
    
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ValidationError> validation(ValidationException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError err = new ValidationError();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setError("Validation Exception");
        err.setMessage(e.getMessage());
        err.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}