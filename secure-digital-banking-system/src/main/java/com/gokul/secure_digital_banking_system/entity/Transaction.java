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

    @Column(name="transaction_Id",unique = true, nullable = false)
    private String transactionId;

    @Column(nullable = false, length = 20)
    private String type;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(name="transaction_date")
    private LocalDateTime transactoinDate;

    @Column(length = 255)
    private String transactionDescription;

    @Column(nullable = false, length = 20)
    private String transactionStatus= "COMPLETED";

    @Column(name = "balance_after")
    private BigDecimal balanceAfter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id",nullable = false)
    private Account account;


    @PrePersist
    protected void onCreate() {
        if(transactoinDate==null) {
            transactoinDate = LocalDateTime.now();
        }
        if(transactionStatus==null)
        {
            transactionStatus="PENDING";
        }
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
