package com.jesusflsa.conversor.api;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    private static final HttpClient CLIENT = HttpClient.newHttpClient();
    private static final String API_KEY = "04906c3d9a1aebb566a4e8f4";
    private static final Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setPrettyPrinting().create();

    public static SupportedCodesExchange obtenerCodigoSoportados() {
        String json = obtenerJson("/codes");

        return gson.fromJson(json, SupportedCodesExchange.class);
    }

    public static PairConvertionExchange convertirUnaMoneda(String primeraMoneda, String segundaMoneda, double cantidad) {
        String json = obtenerJson("/pair/" + primeraMoneda + "/" + segundaMoneda + "/" + cantidad);

        return gson.fromJson(json, PairConvertionExchange.class);

    }

    public static StandarConvertionExchange convertirTodasLasMonedas(String primeraMoneda) {
        String json = obtenerJson("/latest/" + primeraMoneda);

        return gson.fromJson(json, StandarConvertionExchange.class);
    }

    private static String obtenerJson(String route) {
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://v6.exchangerate-api.com/v6/" + API_KEY + route)).build();
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocurrió un error al obtener los datos de " + route);
            throw new RuntimeException(e);
        }
    }

}