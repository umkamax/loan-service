package ru.m2.example.loan.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("loan")
public interface LoanApi {

    @GetMapping
    ResponseEntity<String> getLoanProfile();

}
