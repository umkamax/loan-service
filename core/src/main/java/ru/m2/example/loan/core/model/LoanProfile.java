package ru.m2.example.loan.core.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class LoanProfile {
    private final BigDecimal interestRate;
    private final BigDecimal payment;
}
