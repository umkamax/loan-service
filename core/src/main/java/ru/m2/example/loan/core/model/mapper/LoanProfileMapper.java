package ru.m2.example.loan.core.model.mapper;

import org.mapstruct.Mapper;
import ru.m2.example.loan.api.dto.LoanProfileDTO;
import ru.m2.example.loan.core.model.LoanProfile;

@Mapper(componentModel = "spring")
public interface LoanProfileMapper {
    LoanProfileDTO map(LoanProfile loanProfile);
}
