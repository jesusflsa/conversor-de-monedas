package com.jesusflsa.conversor.api;

import java.util.List;

public class SupportedCodesExchange extends ApiResponseExchange {
    private List<List<String>> supportedCodes;

    public SupportedCodesExchange(String result, String errorType, List<List<String>> supportedCodes) {
        super(result, errorType);
        this.supportedCodes = supportedCodes;
    }

    public List<List<String>> getSupportedCodes() {
        return supportedCodes;
    }
}
