package com.Joytishcharya.userservice.Joytishcharya.userservice.DTOs;

import lombok.Data;

@Data
public class RegisterResponse {

    private String message;
    private Long userId;

    public RegisterResponse(String message, Long userId) {
        this.message = message;
        this.userId = userId;
    }

    // getters
}