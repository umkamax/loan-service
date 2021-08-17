package ru.m2.example.loan.core.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.m2.example.loan.api.LoanApi;
import ru.m2.example.loan.api.dto.LoanProfileDTO;
import ru.m2.example.loan.api.dto.LoanRequestDTO;
import ru.m2.example.loan.core.model.mapper.LoanProfileMapper;
import ru.m2.example.loan.core.service.LoanProfileService;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class LoanRestController implements LoanApi {

    private final LoanProfileService loanProfileService;
    private final LoanProfileMapper mapper;

    @Override
    public ResponseEntity<LoanProfileDTO> getLoanProfile(@Valid LoanRequestDTO loanRequestDTO) {
        LoanProfileDTO result = mapper.map(
                loanProfileService.calculateLoanProfile(loanRequestDTO.getAmount(), loanRequestDTO.getLoanPeriod())
        );
        return ResponseEntity.ok(result);
    }
}
