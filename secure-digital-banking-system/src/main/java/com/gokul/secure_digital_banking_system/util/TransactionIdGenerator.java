package com.gokul.secure_digital_banking_system.util;

import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Component
public class TransactionIdGenerator {

    public String generate() {
        String timeStamp=String.valueOf((Instant.now().toEpochMilli()));
        String randomPart= UUID.randomUUID().toString().substring(0,6).toUpperCase();

        return "TXN"+timeStamp+randomPart;
    }
}
