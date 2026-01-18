package com.Joytishcharya.userservice.Joytishcharya.userservice.Repository;


import com.Joytishcharya.userservice.Joytishcharya.userservice.DTOs.RegisterRequest;
import com.Joytishcharya.userservice.Joytishcharya.userservice.DTOs.RegisterResponse;
import com.Joytishcharya.userservice.Joytishcharya.userservice.Entity.Login;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final LoginRepository loginRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public RegisterResponse register(RegisterRequest request) {

        if (loginRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        if (loginRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Login user = new Login();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));

        Login savedUser = loginRepository.save(user);

        return new RegisterResponse("User registered successfully", savedUser.getId());
    }
}
