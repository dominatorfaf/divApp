package com.example.lab8;

public class UnluckyException extends Exception {

    public UnluckyException(String message) {
        super(message);
    }

    public UnluckyException(String message, Throwable throwable) {
        super(message, throwable);
    }

}