package com.woomzip.common.exception.clientnice;

import com.woomzip.common.exception.BaseErrorCode;
import com.woomzip.common.response.ApplicationResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum NiceErrorCode implements BaseErrorCode {

    // 인증 관련 오류
    CRYPTO_TOKEN_REQUEST_FAILED("NICE API 암호화 토큰 요청에 실패했습니다. 다시 시도해주세요.", 1001, HttpStatus.BAD_REQUEST),
    ;

    private final String message;
    private final int errorCode;
    private final HttpStatus httpStatus;

    @Override
    public ApplicationResponse<String> toResponseEntity() {
        return ApplicationResponse.server(message);
    }
}
