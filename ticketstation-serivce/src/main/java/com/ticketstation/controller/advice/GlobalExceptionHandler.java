package com.ticketstation.controller.advice;

import com.ticketstation.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handle(UserNotFoundException exception){
        return ResponseEntity.ok(new ExceptionResponse(exception.getMessage(), HttpStatus.BAD_REQUEST)); //mesaj olarak exception içindeki mesaj verilir 400 kodu--global

    }

    @ExceptionHandler(AdminException.class)
    public ResponseEntity<ExceptionResponse> handle(AdminException adminException){
        return ResponseEntity.ok(new ExceptionResponse(adminException.getMessage(), HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(TicketLimitException.class)
    public ResponseEntity<ExceptionResponse> handle(TicketLimitException ticketLimitException){
        return ResponseEntity.ok(new ExceptionResponse(ticketLimitException.getMessage(), HttpStatus.BAD_REQUEST));
    }

    @ExceptionHandler(TransportException.class)
    public ResponseEntity<ExceptionResponse> handle(TransportException transportException){
        return ResponseEntity.ok(new ExceptionResponse(transportException.getMessage(), HttpStatus.BAD_REQUEST));
    }

}
