package ru.m2.example.loan.core.service.impl;

import org.springframework.stereotype.Service;
import ru.m2.example.loan.core.model.LoanCondition;
import ru.m2.example.loan.core.model.LoanParam;
import ru.m2.example.loan.core.service.LoanConditionService;

import java.math.BigDecimal;
import java.util.*;

import static ru.m2.example.loan.core.enums.LoanParamRegistry.AMOUNT;
import static ru.m2.example.loan.core.enums.LoanParamRegistry.LOAN_PERIOD;
import static ru.m2.example.loan.core.enums.LoanParamType.RANGE;

@Service
public class LoanConditionServiceImpl implements LoanConditionService {

    private List<LoanCondition> conditions = new ArrayList<>();

    {
        conditions.add(findLoanCondition().get());
    }

    @Override
    public List<LoanCondition> getLoanConditions() {
        return conditions;
    }

    @Override
    public Optional<LoanCondition> findLoanCondition() {
        HashMap<String, LoanParam> params = new HashMap<>();
        params.put(AMOUNT.label() + "From",
                LoanParam.builder()
                        .type(RANGE)
                        .name(AMOUNT.name() + "From")
                        .value(BigDecimal.valueOf(10L).toString())
                        .build()
        );
        params.put(AMOUNT.label() + "To",
                LoanParam.builder()
                        .type(RANGE)
                        .name(AMOUNT.name() + "To")
                        .value(BigDecimal.valueOf(100L).toString())
                        .build()
        );
        params.put(LOAN_PERIOD.label(),
                LoanParam.builder()
                        .type(RANGE)
                        .name(LOAN_PERIOD.label())
                        .value(BigDecimal.valueOf(120L).toString())
                        .build()
        );

        return Optional.of(
                LoanCondition.builder()
                        .params(params)
                        .interestRate(BigDecimal.TEN)
                        .build()
        );
    }

    @Override
    public LoanCondition createLoanCondition(LoanCondition loanCondition) {
        return loanCondition;
    }
}
