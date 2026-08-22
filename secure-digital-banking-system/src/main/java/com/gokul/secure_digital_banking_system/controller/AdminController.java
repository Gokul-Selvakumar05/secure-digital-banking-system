package com.gokul.secure_digital_banking_system.controller;

import com.gokul.secure_digital_banking_system.dto.ApiResponse;
import com.gokul.secure_digital_banking_system.entity.Account;
import com.gokul.secure_digital_banking_system.entity.Transaction;
import com.gokul.secure_digital_banking_system.entity.User;
import com.gokul.secure_digital_banking_system.service.AccountService;
import com.gokul.secure_digital_banking_system.service.TransactionService;
import com.gokul.secure_digital_banking_system.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {
    private final UserService userService;
    private final AccountService accountService;
    private final TransactionService transactionService;

    // ============ USER MANAGEMENT ============

    @GetMapping("/users")
    public ApiResponse<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ApiResponse.success("Users fetched successfully", users);
    }

    @GetMapping("/users/{id}")
    public ApiResponse<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ApiResponse.success("User fetched successfully", user);
    }

    @PutMapping("/users/{id}")
    public ApiResponse<User> updateUser(@PathVariable Long id,
                                        @RequestBody AdminUserUpdateRequest request) {
        User user = userService.updateUser(id, request);
        return ApiResponse.success("User updated successfully", user);
    }

    @DeleteMapping("/users/{id}")
    public ApiResponse<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ApiResponse.success("User deleted successfully", null);
    }

    // ============ ACCOUNT MANAGEMENT ============

    @GetMapping("/accounts")
    public ApiResponse<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllActiveAccounts();
        return ApiResponse.success("Accounts fetched successfully", accounts);
    }

    @GetMapping("/accounts/user/{userId}")
    public ApiResponse<List<Account>> getUserAccounts(@PathVariable Long userId) {
        List<Account> accounts = accountService.getUserAccounts(userId);
        return ApiResponse.success("User accounts fetched successfully", accounts);
    }

    @GetMapping("/accounts/{accountNumber}")
    public ApiResponse<Account> getAccountByNumber(@PathVariable String accountNumber) {
        Account account = accountService.getAccountByNumber(accountNumber);
        return ApiResponse.success("Account fetched successfully", account);
    }

    // ============ TRANSACTION MANAGEMENT ============

    @GetMapping("/transactions")
    public ApiResponse<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ApiResponse.success("All transactions fetched successfully", transactions);
    }

    @GetMapping("/transactions/{transactionId}")
    public ApiResponse<Transaction> getTransactionById(@PathVariable String transactionId) {
        Transaction transaction = transactionService.getTransactionById(transactionId);
        return ApiResponse.success("Transaction fetched successfully", transaction);
    }

    @GetMapping("/transactions/account/{accountId}")
    public ApiResponse<List<Transaction>> getAccountTransactions(@PathVariable Long accountId) {
        List<Transaction> transactions = transactionService.getAccountTransactions(accountId);
        return ApiResponse.success("Account transactions fetched successfully", transactions);
    }

    @GetMapping("/stats/users")
    public ApiResponse<Long> getTotalUsers() {
        long count = userService.getAllUsers().size();
        return ApiResponse.success("Total users count", count);
    }

    @GetMapping("/stats/accounts")
    public ApiResponse<Long> getTotalAccounts() {
        long count = accountService.getAllActiveAccounts().size();
        return ApiResponse.success("Total accounts count", count);
    }
}
