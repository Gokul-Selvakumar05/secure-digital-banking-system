package com.gokul.secure_digital_banking_system.repository;

import com.gokul.secure_digital_banking_system.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    Optional<Transaction> findByTransactionId(String transactionId);
    List<Transaction> findBySourceAccountIdOrderByTimestampDesc(Long accountId);
    List<Transaction> findByTargetAccountIdOrderByTimestampDesc(Long accountId);
}
