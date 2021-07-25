package com.eg.auctioneer.dto.out;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorResponse {
    public LocalDateTime dateTime;
    public String message;

    public ErrorResponse(String message) {
        this.message = message;
        this.dateTime = LocalDateTime.now();
    }
}
