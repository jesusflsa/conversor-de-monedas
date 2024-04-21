package com.jesusflsa.conversor.api;

import com.jesusflsa.conversor.exceptions.ErrorApiException;

public class ApiResponseExchange {
    private String result;
    private String errorType;

    public ApiResponseExchange(String result, String errorType) {
        this.result = result;
        this.errorType = errorType;

        if (result.equals("error")) throw new ErrorApiException(this.errorType);
    }

    public String getResult() {
        return result;
    }

    public String getErrorType() {
        return errorType;
    }
}