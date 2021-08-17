package ru.m2.example.loan.core.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.m2.example.loan.core.exception.NotFoundException;
import ru.m2.example.loan.core.model.LoanCondition;
import ru.m2.example.loan.core.model.LoanProfile;
import ru.m2.example.loan.core.service.LoanConditionService;
import ru.m2.example.loan.core.service.LoanProfileService;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class LoanProfileServiceImpl implements LoanProfileService {

    private final LoanConditionService loanConditionService;

    @Override
    public LoanProfile calculateLoanProfile(BigDecimal loanAmount, Integer loanPeriod) {
        LoanCondition condition = loanConditionService.findLoanCondition()
                .orElseThrow(() -> new NotFoundException("!!!"));

        BigDecimal interestRate = condition.getInterestRate();
        BigDecimal payment = calculate(loanAmount, interestRate, loanPeriod);

        return LoanProfile.builder()
                .payment(payment)
                .interestRate(condition.getInterestRate())
                .build();
    }

    //TODO incapsulate to CalculatorImpl may be???
    private BigDecimal calculate(BigDecimal loanAmount, BigDecimal interestRate, Integer loanPeriod) {
        MathContext mc = new MathContext(2, RoundingMode.HALF_UP);
        BigDecimal interestRatePerMonth = interestRate.divide(BigDecimal.valueOf(12), mc);
        BigDecimal powerPart = interestRatePerMonth.add(BigDecimal.ONE).pow(loanPeriod);
        BigDecimal fractionPart = interestRatePerMonth.divide(powerPart.subtract(BigDecimal.ONE), mc);
        BigDecimal bracesPart = interestRatePerMonth.add(fractionPart);
        BigDecimal total = loanAmount.multiply(bracesPart);

        return total.setScale(2, RoundingMode.HALF_UP);
    }
}
