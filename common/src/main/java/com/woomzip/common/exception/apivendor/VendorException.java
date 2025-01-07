package com.woomzip.common.exception.apivendor;

import com.woomzip.common.exception.BaseErrorCode;
import com.woomzip.common.exception.CustomException;

public class VendorException extends CustomException {
    public VendorException(BaseErrorCode bseErrorCode) {super(bseErrorCode);}
}