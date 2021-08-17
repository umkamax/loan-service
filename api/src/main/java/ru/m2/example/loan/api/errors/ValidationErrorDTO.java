package ru.m2.example.loan.api.errors;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationErrorDTO {

    private final List<Violation> violations = new ArrayList<>();

}
