package com.gokul.secure_digital_banking_system.controller;

import com.gokul.secure_digital_banking_system.dto.ApiResponse;
import com.gokul.secure_digital_banking_system.dto.LoginRequest;
import com.gokul.secure_digital_banking_system.dto.RegisterRequest;
import com.gokul.secure_digital_banking_system.entity.User;
import com.gokul.secure_digital_banking_system.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ApiResponse<User> register(@RequestBody RegisterRequest request) {
        User user = authService.register(request);
        return ApiResponse.success("Registration successful", user);
    }

    @PostMapping("/login")
    public ApiResponse<Object> login(@RequestBody LoginRequest request) {
        Object response = authService.login(request);
        return ApiResponse.success("Login successful", response);
}
