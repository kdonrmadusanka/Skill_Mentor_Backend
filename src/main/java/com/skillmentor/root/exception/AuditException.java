package com.skillmentor.root.exception;

public class AuditException extends Exception{
    public AuditException(String message, Throwable throwable){
        super(message, throwable);
    }
}
