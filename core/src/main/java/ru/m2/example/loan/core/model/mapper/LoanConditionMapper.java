package ru.m2.example.loan.core.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import ru.m2.example.loan.api.dto.LoanConditionDTO;
import ru.m2.example.loan.core.model.LoanCondition;
import ru.m2.example.loan.core.model.LoanParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface LoanConditionMapper {

    @Mapping(source = "params", target = "params", qualifiedByName = "loanParamToDTO")
    LoanConditionDTO map(LoanCondition loanCondition);

    @Named("loanParamToDTO")
    default Map<String, String> loanParamToDTO(Map<String, LoanParam> params) {
        return params.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getValue()));
    }

    List<LoanConditionDTO> map(List<LoanCondition> loanConditions);

}
