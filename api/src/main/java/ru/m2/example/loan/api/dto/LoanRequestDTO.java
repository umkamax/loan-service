package ru.m2.example.loan.api.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public class LoanRequestDTO {
    @NotNull
    private final BigDecimal amount;
    @NotNull
    private final Integer borrowerAge;
    @NotNull
    private final Integer loanPeriod;

}
