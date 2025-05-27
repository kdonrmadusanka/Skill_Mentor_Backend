package com.skillmentor.root.exception;

public class StudentException extends RuntimeException {
    public StudentException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public StudentException(String message) {
        super(message);
    }

    public StudentException() {
    }
}
