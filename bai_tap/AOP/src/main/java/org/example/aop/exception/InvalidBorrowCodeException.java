package org.example.aop.exception;

public class InvalidBorrowCodeException extends RuntimeException {
    public InvalidBorrowCodeException(String message) {
        super(message);
    }
}
