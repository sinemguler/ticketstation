package com.ticketstation.exception;

public class TicketLimitException extends RuntimeException{
    public TicketLimitException(String message) {
        super(message);
    }
}
