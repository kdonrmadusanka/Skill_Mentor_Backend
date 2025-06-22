package com.skillmentor.root.exception;

public class AdminException extends RuntimeException {
    public AdminException(String message, Throwable throwable) {
      super(message, throwable);
    }

  public AdminException(String message) {
    super(message);
  }

  public AdminException() {
  }

}
