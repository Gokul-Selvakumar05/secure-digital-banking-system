package com.gokul.secure_digital_banking_system.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
public class TransactionIdGenerator {
    private static long counter = 1000;

    public synchronized String generate() {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        return "TXN" + date + (++counter);
    }
}
