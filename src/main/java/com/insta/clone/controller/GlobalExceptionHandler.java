package com.insta.clone.controller;

import com.insta.clone.dto.ProblemDTO;
import com.insta.clone.exception.NotFoundException;
import com.insta.clone.exception.RequestExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ProblemDTO> handleNotFoundException(NotFoundException ex) {
        ProblemDTO problem = new ProblemDTO(HttpStatus.NOT_FOUND.value(), ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(problem);
    }

    @ExceptionHandler(RequestExistException.class)
    public ResponseEntity<ProblemDTO> handleRequestExistException(RequestExistException ex) {
        ProblemDTO problem = new ProblemDTO(HttpStatus.CONFLICT.value(), ex.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(problem);
    }
}
