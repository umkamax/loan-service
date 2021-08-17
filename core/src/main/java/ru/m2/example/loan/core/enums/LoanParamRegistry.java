package ru.m2.example.loan.core.enums;

import static ru.m2.example.loan.core.enums.LoanParamType.*;

public enum LoanParamRegistry {
    AMOUNT("amount", RANGE),
    BORROWER_AGE("borrowerAge", RANGE),
    LOAN_PERIOD("loanPeriod", RANGE),
    CITIZENSHIP("citizenship", SIMPLE);

    private final String label;
    public String label() {
        return label;
    }

    private final LoanParamType type;
    public LoanParamType type() {
        return type;
    }

    LoanParamRegistry(String label, LoanParamType type) {
        this.label = label;
        this.type = type;
    }

}
