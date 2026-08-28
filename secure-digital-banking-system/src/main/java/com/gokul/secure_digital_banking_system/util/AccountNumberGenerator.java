package com.gokul.secure_digital_banking_system.util;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class AccountNumberGenerator {

    private static final String prefix="GSB";
    private final SecureRandom random=new SecureRandom();

    public String generate()
    {
        StringBuilder digits=new StringBuilder();
        for (int i=0;i<10;i++)
        {
            digits.append(random.nextInt(10));
        }
        return prefix + digits;
    }
}
