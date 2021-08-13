package ru.m2.example.loan.core.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.m2.example.loan.api.LoanApi;

@RestController
public class LoanRestController implements LoanApi {

    @Override
    public ResponseEntity<String> getLoanProfile() {
        return ResponseEntity.ok("OK");
    }
}
