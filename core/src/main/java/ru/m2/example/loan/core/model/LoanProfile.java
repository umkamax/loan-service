package ru.m2.example.loan.core.model;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class LoanProfile {
    private BigDecimal interestRate;
    private BigDecimal payment;
}
