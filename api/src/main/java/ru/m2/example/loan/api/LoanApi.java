package ru.m2.example.loan.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.m2.example.loan.api.dto.LoanProfileDTO;
import ru.m2.example.loan.api.dto.LoanRequestDTO;

import javax.validation.Valid;

@RequestMapping("loans")
public interface LoanApi {

    @GetMapping(value = "/loan-profile", produces = "application/json")
    ResponseEntity<LoanProfileDTO> getLoanProfile(@Valid LoanRequestDTO loanRequestDTO);

}
