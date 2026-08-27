package com.gokul.secure_digital_banking_system.exception;

public class AccountNotActiveException extends  RuntimeException{

    public AccountNotActiveException(String message) {
        super(message);
    }
}
