package com.gokul.secure_digital_banking_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String transactionId;

    @Column(nullable = false, length = 20)
    private String transactionType;

    @Column(nullable = false)
    private BigDecimal transactionAmount;

    @Column
    private LocalDateTime transactoinDate;

    @Column(length = 255)
    private String transactionDescription;

    @Column(nullable = false, length = 20)
    private String transactionStatus= "PENDING";

    @Column(name = "balance_after")
    private BigDecimal balanceAfter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id",nullable = false)
    private Account account;


    @PrePersist
    protected void onCreate() {
        transactoinDate = LocalDateTime.now();
    }

    public static final String TYPE_DEPOSIT = "DEPOSIT";
    public static final String TYPE_WITHDRAWAL = "WITHDRAWAL";
    public static final String TYPE_TRANSFER = "TRANSFER";
    public static final String TYPE_TRANSFER_RECEIVE = "TRANSFER_RECEIVE";

    public static final String STATUS_PENDING = "PENDING";
    public static final String STATUS_COMPLETED = "COMPLETED";
    public static final String STATUS_FAILED = "FAILED";
    public static final String STATUS_CANCELLED = "CANCELLED";


}
