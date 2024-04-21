package com.jesusflsa.conversor.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class ConsultaApi {

    // Documentación de la API de ExchangeRate: https://www.exchangerate-api.com/docs/overview

    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final String API_KEY = "04906c3d9a1aebb566a4e8f4";
    private static final Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setPrettyPrinting().create();
    private static final String URL = "https://v6.exchangerate-api.com/v6/";

    public static List<List<String>> obtenerCodigosSoportados() {
        String json = obtenerJson("/codes");
        SupportedCodesExchange resultado = gson.fromJson(json, SupportedCodesExchange.class);

        return resultado.getSupportedCodes();
    }

    public static String convertirUnaMoneda(String primeraMoneda, String segundaMoneda, double cantidad) {
        String json = obtenerJson("/pair/" + primeraMoneda + "/" + segundaMoneda + "/" + cantidad);
        PairConvertionExchange resultado = gson.fromJson(json, PairConvertionExchange.class);

        return resultado.getConversionResult();
    }

    public static Map<String, Double> convertirTodasLasMonedas(String primeraMoneda) {
        String json = obtenerJson("/latest/" + primeraMoneda);
        StandardConvertionExchange resultado = gson.fromJson(json, StandardConvertionExchange.class);

        return resultado.getConversionRates();
    }

    private static String obtenerJson(String route) {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URL + API_KEY + route)).build();
        HttpResponse<String> response = null;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        return response.body();
    }

}