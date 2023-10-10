package com.assignment.daofab.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Thanh Le
 * @since 2023-10-07
 */

@ControllerAdvice
public class CommonExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FetchingParentTransactionException.class)
    public ResponseEntity<String> handleExceptionParentFetching(FetchingParentTransactionException exc) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exc.getMessage());
    }

    @ExceptionHandler(FetchingChildTransactionException.class)
    public ResponseEntity<String> handleExceptionChildFetching(FetchingChildTransactionException exc) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exc.getMessage());
    }

    @ExceptionHandler(IncorrectParentIdException.class)
    public ResponseEntity<String> handleIncorrectParentIdException(IncorrectParentIdException exc) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
    }
}