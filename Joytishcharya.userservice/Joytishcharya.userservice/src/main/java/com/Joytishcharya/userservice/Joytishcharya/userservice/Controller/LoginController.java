package com.Joytishcharya.userservice.Joytishcharya.userservice.Controller;


import com.Joytishcharya.userservice.Joytishcharya.userservice.DTOs.LoginRequest;
import com.Joytishcharya.userservice.Joytishcharya.userservice.DTOs.LoginResponse;
import com.Joytishcharya.userservice.Joytishcharya.userservice.DTOs.RegisterRequest;
import com.Joytishcharya.userservice.Joytishcharya.userservice.DTOs.RegisterResponse;
import com.Joytishcharya.userservice.Joytishcharya.userservice.Repository.AuthService;
import com.Joytishcharya.userservice.Joytishcharya.userservice.Repository.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        String result = loginService.login(request);
        return new LoginResponse(result);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authService.register(request));
    }
}