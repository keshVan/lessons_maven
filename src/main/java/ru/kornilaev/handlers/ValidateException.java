package ru.kornilaev.handlers;

public class ValidateException extends RuntimeException {
    public ValidateException(String value) {
        super(value);
    }
}
