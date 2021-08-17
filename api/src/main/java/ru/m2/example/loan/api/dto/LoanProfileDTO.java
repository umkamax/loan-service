package ru.m2.example.loan.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Setter
@Getter
public class LoanProfileDTO {
    private final BigDecimal interestRate;
    private final BigDecimal payment;
}
