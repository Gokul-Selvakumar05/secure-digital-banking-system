package com.gokul.secure_digital_banking_system.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

        @NotBlank(message = "Username is required")
        @Size(min = 3, max = 50)
        private String username;

        @NotBlank(message = "Password is required")
        @Size(min = 6)
        private String password;

        @NotBlank(message = "Email is required")
        @Email
        private String email;

        @NotBlank(message = "Full name is required")
        private String fullName;

        @Pattern(regexp = "^[0-9]{10}$")
        private String phone;

}
