package ru.m2.example.loan.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.m2.example.loan.api.errors.ValidationErrorDTO;
import ru.m2.example.loan.api.errors.Violation;

@ControllerAdvice
public class ErrorHandlingControllerAdvice {

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ValidationErrorDTO handleBindException(BindException e) {
        ValidationErrorDTO error = new ValidationErrorDTO();

        for (FieldError fieldError : e.getFieldErrors()) {
            error.getViolations().add(
                    Violation.builder()
                            .fieldName(fieldError.getField())
                            .message(fieldError.getDefaultMessage())
                            .build()
            );
        }

        return error;
    }

    @ExceptionHandler(NotFoundException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<Object> handleConditionNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Object());
    }

    @ExceptionHandler(ValidationException.class)
    ResponseEntity<ValidationErrorDTO> handleValidationException(ValidationException e) {
        ValidationErrorDTO error = new ValidationErrorDTO();

        error.getViolations().add(e.getViolation());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    ResponseEntity<ValidationErrorDTO> handleNumberFormatException(NumberFormatException e) {
        ValidationErrorDTO error = new ValidationErrorDTO();

//        error.getViolations().add(e);

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);

    }
}
