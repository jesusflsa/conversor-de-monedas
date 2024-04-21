package com.jesusflsa.conversor.api;

public class PairConvertionExchange extends ApiResponseExchange {
    private String conversionResult;
    private String baseCode;
    private String targetCode;

    public PairConvertionExchange(String result, String errorType) {
        super(result, errorType);
    }

    public String getConversionResult() {
        return conversionResult;
    }

    public String getBaseCode() {
        return baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }
}
