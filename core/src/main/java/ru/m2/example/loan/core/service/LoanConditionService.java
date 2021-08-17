package ru.m2.example.loan.core.service;

import ru.m2.example.loan.core.model.LoanCondition;

import java.util.List;
import java.util.Optional;

public interface LoanConditionService {

    List<LoanCondition> getLoanConditions();

    Optional<LoanCondition> findLoanCondition();

    LoanCondition createLoanCondition(LoanCondition loanCondition);

}
