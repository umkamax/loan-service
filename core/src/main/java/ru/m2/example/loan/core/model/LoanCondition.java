package ru.m2.example.loan.core.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Builder
@Getter
public class LoanCondition {
    private final Map<String, LoanParam> params;
    private final BigDecimal interestRate;
}
