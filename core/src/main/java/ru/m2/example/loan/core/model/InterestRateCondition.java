package ru.m2.example.loan.core.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.HashMap;

@Getter
public class InterestRateCondition {
    private HashMap<String, LoanParam> conditions;
    private BigDecimal interestRate;
}
