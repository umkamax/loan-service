package ru.m2.example.loan.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public class LoanConditionDTO {
    private final Map<String, String> params;
    private final BigDecimal interestRate;

}
