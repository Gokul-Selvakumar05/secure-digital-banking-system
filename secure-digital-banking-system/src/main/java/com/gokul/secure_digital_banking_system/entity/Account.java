package com.gokul.secure_digital_banking_system.entity;

import jakarta.persistence.*;
import org.springframework.web.service.annotation.GetExchange;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    @Column(nullable = false, length = 20)
    private String accountType;

    @Column(precision = 15, scale = 2, nullable = false)
    private BigDecimal balance=BigDecimal.ZERO;

    @Column(length = 3)
    private String currency = "INR";


    @Column(nullable = false, updatable = false)
    private LocalDateTime openedAt;

    @Column(length = 20)
    private String status = "ACTIVE";

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy="account", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Transaction> transactions;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public void deposit(BigDecimal amount)
    {
        if(amount.compareTo(BigDecimal.ZERO)<=0)
        {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        this.balance=this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount)
    {
        if(amount.compareTo(BigDecimal.ZERO)<=0)
        {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        if(this.balance.compareTo(amount)<0)
        {
            throw new IllegalArgumentException("Insufficent Balance");
        }
        this.balance=this.balance.subtract(amount);
    }

    public boolean isActive()
    {
        return "ACTIVE".equals(this.status);
    }

}
