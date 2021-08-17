package ru.m2.example.loan.core.model;

import lombok.Builder;
import lombok.Getter;
import ru.m2.example.loan.core.enums.LoanParamType;

@Builder
@Getter
public class LoanParam {
    private final LoanParamType type;
    private final String name;
    private final String value;
}
