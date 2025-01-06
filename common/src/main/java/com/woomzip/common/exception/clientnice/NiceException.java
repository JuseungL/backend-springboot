package com.woomzip.common.exception.clientnice;

import com.woomzip.common.exception.BaseErrorCode;
import com.woomzip.common.exception.CustomException;

public class NiceException extends CustomException {
    public NiceException(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
