package ru.m2.example.loan.core.exception;

import ru.m2.example.loan.api.errors.Violation;

public class ValidationException extends RuntimeException {
    private Violation violation;

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Violation violation) {
        super(message);
        this.violation = violation;
    }

    public Violation getViolation() {
        return violation;
    }

}
