package ru.m2.example.loan.core.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.m2.example.loan.api.LoanConditionApi;
import ru.m2.example.loan.api.dto.LoanConditionDTO;
import ru.m2.example.loan.core.helper.LoanConditionHelper;
import ru.m2.example.loan.core.model.LoanCondition;
import ru.m2.example.loan.core.model.mapper.LoanConditionMapper;
import ru.m2.example.loan.core.service.LoanConditionService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class LoanConditionRestController implements LoanConditionApi {

    private final LoanConditionService loanConditionService;
    private final LoanConditionMapper mapper;
    private final ObjectMapper objectMapper;
    private final LoanConditionHelper helper;

    @Override
    public ResponseEntity<List<LoanConditionDTO>> getLoanConditions() {
        return ResponseEntity.ok(mapper.map(loanConditionService.getLoanConditions()));
    }

    @Override
    public ResponseEntity<LoanConditionDTO> createLoanCondition(HttpEntity<String> httpEntity) {
        Map<String, String> rawData = parseInputData(httpEntity.getBody());
        LoanCondition loanCondition = loanConditionService.createLoanCondition(helper.validateAndBuild(rawData));
        return ResponseEntity.ok(mapper.map(loanCondition));
    }

    private Map<String, String> parseInputData(String inputData) {
        Map<String, String> map = null;
        TypeReference<HashMap<String, String>> typeReference = new TypeReference<HashMap<String, String>>() {};
        try {
            map = objectMapper.readValue(inputData, typeReference);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return map;
    }

}
