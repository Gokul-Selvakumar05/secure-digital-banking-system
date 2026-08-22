package com.gokul.secure_digital_banking_system.controller;

import com.gokul.secure_digital_banking_system.dto.ApiResponse;
import com.gokul.secure_digital_banking_system.dto.DepositRequest;
import com.gokul.secure_digital_banking_system.entity.Account;
import com.gokul.secure_digital_banking_system.entity.User;
import com.gokul.secure_digital_banking_system.service.AccountService;
import com.gokul.secure_digital_banking_system.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final UserService userService;

    @PostMapping("/create")
    public ApiResponse<Account> createAccount(@RequestParam(required = false) String accountType) {
        User currentUser = userService.getCurrentUser();
        Account account = accountService.createAccount(currentUser, accountType);
        return ApiResponse.created("Account created successfully", account);
    }

    @PostMapping("/deposit")
    public ApiResponse<Account> deposit(@Valid @RequestBody DepositRequest request) {
        Account account = accountService.deposit(request);
        return ApiResponse.success("Deposit successful", account);
    }

    @PostMapping("/withdraw")
    public ApiResponse<Account> withdraw(@RequestParam String accountNumber,
                                         @RequestParam BigDecimal amount,
                                         @RequestParam(required = false) String description) {
        Account account = accountService.withdraw(accountNumber, amount, description);
        return ApiResponse.success("Withdrawal successful", account);
    }

    @GetMapping("/my-accounts")
    public ApiResponse<List<Account>> getMyAccounts() {
        User currentUser = userService.getCurrentUser();
        List<Account> accounts = accountService.getUserAccounts(currentUser.getId());
        return ApiResponse.success("Accounts fetched successfully", accounts);
    }


}
