package ru.m2.example.loan.api.errors;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Violation {
    private final String fieldName;
    private final String message;
}
