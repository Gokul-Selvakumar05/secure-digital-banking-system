package com.gokul.secure_digital_banking_system.service;

import com.gokul.secure_digital_banking_system.dto.DepositRequest;
import com.gokul.secure_digital_banking_system.entity.Account;
import com.gokul.secure_digital_banking_system.entity.User;
import com.gokul.secure_digital_banking_system.exception.ResourceNotFoundException;
import com.gokul.secure_digital_banking_system.repository.AccountRepository;
import com.gokul.secure_digital_banking_system.util.AccountNumberGenerator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountNumberGenerator accountNumberGenerator;
    private final TransactionService transactionService;

    @Transactional
    public Account createAccount(User user, String accountType) {
        Account account = new Account();
        account.setAccountNumber(accountNumberGenerator.generate());
        account.setAccountType(accountType != null ? accountType : "SAVINGS");
        account.setUser(user);
        account.setBalance(BigDecimal.ZERO);
        return accountRepository.save(account);
    }

    @Transactional
    public Account deposit(DepositRequest request) {
        Account account = getAccountByNumber(request.getAccountNumber());
        account.deposit(request.getAmount());
        Account saved = accountRepository.save(account);

        transactionService.createTransaction(saved, "DEPOSIT", request.getAmount(),
                request.getDescription() != null ? request.getDescription() : "Deposit", saved.getBalance());

        return saved;
    }

    @Transactional
    public Account withdraw(String accountNumber, BigDecimal amount, String description) {
        Account account = getAccountByNumber(accountNumber);
        account.withdraw(amount);
        Account saved = accountRepository.save(account);

        transactionService.createTransaction(saved, "WITHDRAWAL", amount,
                description != null ? description : "Withdrawal", saved.getBalance());

        return saved;
    }

    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found: " + accountNumber));
    }

    public List<Account> getUserAccounts(Long userId) {
        return accountRepository.findAccountsByUserId(userId);
    }

    public List<Account> getUserActiveAccounts(Long userId) {
        return accountRepository.findActiveAccountsByUserId(userId);
    }
}
