package com.woomzip.common.exception.apiproduct;

import com.woomzip.common.exception.BaseErrorCode;
import com.woomzip.common.response.ApplicationResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ProductErrorCode implements BaseErrorCode {
    PRODUCT_NOT_FOUND("제품을 찾을 수 없습니다.", 2003, HttpStatus.NOT_FOUND),
    ;

    private final String message;
    private final int errorCode;
    private final HttpStatus httpStatus;

    @Override
    public ApplicationResponse<String> toResponseEntity() {
        return ApplicationResponse.server(message);
    }
}
