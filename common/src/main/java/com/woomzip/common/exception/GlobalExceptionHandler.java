package com.woomzip.common.exception;

import com.woomzip.common.exception.apiproduct.ProductException;
import com.woomzip.common.exception.apivendor.VendorException;
import com.woomzip.common.response.ApplicationResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(VendorException.class) // VendorException
    protected ApplicationResponse<String> handleVendorException(VendorException e) {
        return ApplicationResponse.custom(
                        e.getMessage(), // Payload
                        e.getErrorCode().getHttpStatus().value(), // Code
                        e.getErrorCode().getHttpStatus().getReasonPhrase() // Message
                );
    }

    @ExceptionHandler(ProductException.class) // VendorException
    protected ApplicationResponse<String> handleVendorException(ProductException e) {
        return ApplicationResponse.custom(
                e.getMessage(), // Payload
                e.getErrorCode().getHttpStatus().value(), // Code
                e.getErrorCode().getHttpStatus().getReasonPhrase() // Message
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) // @Valid 검증 실패 처리
    public ApplicationResponse<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder errorMessage = new StringBuilder();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMessage.append(fieldError.getField())
                    .append(": ")
                    .append(fieldError.getDefaultMessage())
                    .append(" & ");
        }

        return ApplicationResponse.badRequest(errorMessage.delete(errorMessage.length()-3, errorMessage.length()).toString());
    }

    @ExceptionHandler(RuntimeException.class) // 캐치하지 못한 예외
    protected ResponseEntity<ApplicationResponse<Void>> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.status(500).body(ApplicationResponse.server(null, e.getMessage()));
    }
}
