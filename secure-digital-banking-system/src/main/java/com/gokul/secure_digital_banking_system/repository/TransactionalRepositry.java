package com.gokul.secure_digital_banking_system.repository;

import com.gokul.secure_digital_banking_system.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionalRepositry extends JpaRepository<Transaction,Long> {

    List<Transaction> findByAccountIdOrderByDateDesc(Long accountId);

    Optional<Transaction> findByTransactionId(String transactionId);

    List<Transaction> findByAccountIdAndType(Long accountId, String transactionType);

}
