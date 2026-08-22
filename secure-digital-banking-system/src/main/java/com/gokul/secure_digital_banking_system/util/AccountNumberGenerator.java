package com.gokul.secure_digital_banking_system.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Component
public class AccountNumberGenerator {
    private static long counter = 1000000;

    public synchronized String generate() {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        return "ACC" + date + (++counter);
    }
}
