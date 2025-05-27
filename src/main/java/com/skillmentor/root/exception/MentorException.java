package com.skillmentor.root.exception;

public class MentorException extends RuntimeException {
    public MentorException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public MentorException(String message) {
        super(message);
    }

    public MentorException() {
    }
}