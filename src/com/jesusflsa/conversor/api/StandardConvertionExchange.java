package com.jesusflsa.conversor.api;

import java.util.Map;

public class StandardConvertionExchange extends ApiResponseExchange {
    Map<String, Double> conversionRates;

    public StandardConvertionExchange(String result, String errorType, Map<String, Double> conversionRates) {
        super(result, errorType);
        this.conversionRates = conversionRates;
    }

    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }
}
