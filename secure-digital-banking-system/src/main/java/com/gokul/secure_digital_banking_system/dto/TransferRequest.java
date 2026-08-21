package com.gokul.secure_digital_banking_system.dto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class TransferRequest {
    @NotBlank(message = "From account is required")
    private String fromAccountNumber;

    @NotBlank(message = "To account is required")
    private String toAccountNumber;

    @NotNull(message = "Amount is required")
    @DecimalMin(value = "0.01")
    @DecimalMax(value = "1000000")
    private BigDecimal amount;

    private String description;

}
