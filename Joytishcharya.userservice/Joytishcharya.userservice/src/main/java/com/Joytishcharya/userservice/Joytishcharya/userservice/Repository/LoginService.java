package com.Joytishcharya.userservice.Joytishcharya.userservice.Repository;



import com.Joytishcharya.userservice.Joytishcharya.userservice.Controller.JwtUtil;
import com.Joytishcharya.userservice.Joytishcharya.userservice.DTOs.LoginRequest;
import com.Joytishcharya.userservice.Joytishcharya.userservice.Entity.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginRepository loginRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;   // ✅ ADD THIS

    public String login(LoginRequest request) {

        Login user = loginRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid password");
        }

        user.setLastLogin(LocalDateTime.now());
        loginRepository.save(user);

        // ✅ JWT TOKEN GENERATE
        return jwtUtil.generateToken(
                user.getUsername()   // eg: USER / ADMIN
        );
    }
}

