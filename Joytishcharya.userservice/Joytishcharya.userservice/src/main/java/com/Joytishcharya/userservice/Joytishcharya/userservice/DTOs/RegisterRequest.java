package com.Joytishcharya.userservice.Joytishcharya.userservice.DTOs;

import lombok.Data;

@Data
public class RegisterRequest {

    private String username;
    private String email;
    private String password;


    // getters & setters
}
