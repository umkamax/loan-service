package ru.m2.example.loan.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.m2.example.loan.api.dto.LoanConditionDTO;

import java.util.List;

@RequestMapping("loanconditions")
public interface LoanConditionApi {

    @GetMapping(produces = "application/json")
    ResponseEntity<List<LoanConditionDTO>> getLoanConditions();

    @PostMapping(produces = "application/json")
    ResponseEntity<LoanConditionDTO> createLoanCondition(HttpEntity<String> httpEntity);

}
