package ru.m2.example.loan.core.service;

import ru.m2.example.loan.core.model.LoanProfile;

import java.math.BigDecimal;

public interface LoanProfileService {

    LoanProfile calculateLoanProfile(BigDecimal loanAmount, Integer loanPeriod);

}
