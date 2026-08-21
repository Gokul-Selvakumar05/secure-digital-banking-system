package com.gokul.secure_digital_banking_system.repository;

import com.gokul.secure_digital_banking_system.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepositry extends JpaRepository<Account,Long> {

    Optional<Account> findByAccountNumber(String accountNumber);

    List<Account> findByUserId(Long userId);
    List<Account> findByUserIdAndStatus(Long userId,String status);
    boolean exixtsByAccountNumber(String accountNumber);
}
