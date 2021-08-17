package ru.m2.example.loan.core.helper;

import org.springframework.stereotype.Component;
import ru.m2.example.loan.api.errors.Violation;
import ru.m2.example.loan.core.enums.LoanParamRegistry;
import ru.m2.example.loan.core.enums.LoanParamType;
import ru.m2.example.loan.core.exception.ValidationException;
import ru.m2.example.loan.core.model.LoanCondition;
import ru.m2.example.loan.core.model.LoanParam;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoanConditionHelper {
    private static final String FROM_SUFFIX = "From";
    private static final String TO_SUFFIX = "To";

    private final Map<String, LoanParam> params = new HashMap<>();

    public LoanCondition validateAndBuild(Map<String, String> rawData) {
        BigDecimal interestRate;
        if (!rawData.containsKey("interestRate")) {
            throw new ValidationException("Field {interestRate} must exist",
                    Violation.builder()
                            .fieldName("interestRate")
                            .message("must exist")
                            .build()
            );
        } else {
            try {
                interestRate = BigDecimal.valueOf(Double.parseDouble(rawData.get("interestRate")));
            } catch (NumberFormatException e) {
                throw new ValidationException("Field {interestRate}: " + e.getMessage(),
                        Violation.builder()
                                .fieldName("interestRate")
                                .message("invalid value: " + e.getMessage())
                                .build()
                );
            }
        }

        for (LoanParamRegistry value : LoanParamRegistry.values()) {
            String paramName = value.label();
            String paramNameFrom = paramName + FROM_SUFFIX;
            String paramNameTo = paramName + TO_SUFFIX;
            LoanParamType paramType = value.type();

            if (rawData.containsKey(paramName)) {
                switch (paramType) {
                    case RANGE:
                        addRangeParam(paramType, paramNameFrom, paramNameTo, String.valueOf(0L), rawData.get(paramName));
                        break;
                    case SIMPLE:
                        addSimpleParam(paramType, paramName, rawData.get(paramName));
                        break;
                    default:
                        break;
                }
            } else if(rawData.containsKey(paramNameFrom) && rawData.containsKey(paramNameTo)) {
                addRangeParam(paramType, paramNameFrom, paramNameTo, rawData.get(paramNameFrom), rawData.get(paramNameTo));
            }
        }


        return LoanCondition.builder()
                .params(params)
                .interestRate(interestRate)
                .build();
    }

    private void addRangeParam(LoanParamType type, String nameFrom, String nameTo, String valueFrom, String valueTo) {
        params.put(nameFrom, buildLoanParam(type, nameFrom, valueFrom));
        params.put(nameTo, buildLoanParam(type, nameTo, valueTo));
    }

    private void addSimpleParam(LoanParamType type, String name, String value) {

    }

    private LoanParam buildLoanParam(LoanParamType type, String name, String value) {
        return LoanParam.builder()
                .type(type)
                .name(name)
                .value(value)
                .build();

    }

}
