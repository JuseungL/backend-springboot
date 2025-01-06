package com.woomzip.common.exception;

import com.woomzip.common.exception.apivendor.VendorException;
import com.woomzip.common.response.ApplicationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ApplicationResponse<Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(ApplicationResponse.badRequest(null, e.getMessage()));
    }

    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<ApplicationResponse<Void>> handleNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity.status(404).body(ApplicationResponse.custom(null, 404, e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ApplicationResponse<Void>> handleGeneralException(Exception e) {
        return ResponseEntity.internalServerError().body(ApplicationResponse.server(null, e.getMessage()));
    }


    @ExceptionHandler(VendorException.class)
    protected ResponseEntity<ApplicationResponse<String>> handleVendorException(VendorException e) {
        // Return the custom response with the appropriate HTTP status code
        return new ResponseEntity<>(
                ApplicationResponse.custom(e.getMessage(), e.getErrorCode().getHttpStatus().value(), e.getErrorCode().getHttpStatus().getReasonPhrase()),
                e.getErrorCode().getHttpStatus()
        );
    }

    @ExceptionHandler(RuntimeException.class)
    protected ResponseEntity<ApplicationResponse<Void>> handleRuntimeException(RuntimeException e) {
        return ResponseEntity.status(500).body(ApplicationResponse.server(null, e.getMessage()));
    }
}
