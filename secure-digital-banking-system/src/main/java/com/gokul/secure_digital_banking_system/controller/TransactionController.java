package com.gokul.secure_digital_banking_system.controller;

import com.gokul.secure_digital_banking_system.dto.ApiResponse;
import com.gokul.secure_digital_banking_system.dto.TransferRequest;
import com.gokul.secure_digital_banking_system.entity.Transaction;
import com.gokul.secure_digital_banking_system.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/transfer")
    public ApiResponse<Transaction> transfer(@Valid @RequestBody TransferRequest request) {
        Transaction transaction = transactionService.transfer(request);
        return ApiResponse.success("Transfer successful", transaction);
    }

    @GetMapping("/account/{accountId}")
    public ApiResponse<List<Transaction>> getTransactions(@PathVariable Long accountId) {
        List<Transaction> transactions = transactionService.getAccountTransactions(accountId);
        return ApiResponse.success("Transactions fetched successfully", transactions);
    }
}
