package com.jesusflsa.conversor.modelos;

import com.jesusflsa.conversor.api.ConsultaApi;
import com.jesusflsa.conversor.utils.DataConverter;
import com.jesusflsa.conversor.utils.Impresiones;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Currency {

    private String primeraMoneda;
    private String segundaMoneda;
    private static final Set<String> supportedCurrencies = ConsultaApi.convertirTodasLasMonedas("USD").keySet();

    private double cantidad;

    public void mostrarComparacionDeDosMonedas() {
        String resultado = ConsultaApi.convertirUnaMoneda(primeraMoneda, segundaMoneda, cantidad);
        System.out.println(primeraMoneda + " " + cantidad + " son: " + segundaMoneda + " " + resultado);
    }

    public void mostrarCodigosSoportados(Scanner scanner, int page) {
        List<List<String>> supportedCodes = ConsultaApi.obtenerCodigosSoportados();
        Impresiones.imprimirConPaginas(scanner, page, supportedCodes);

    }

    public void mostrarComparacionTodasLasMonedas(Scanner scanner, int page) {
        Map<String, Double> mapaDeConversiones = ConsultaApi.convertirTodasLasMonedas(primeraMoneda);
        mapaDeConversiones.remove(primeraMoneda);

        List<List<String>> listaDeConversiones = DataConverter.mapaDeConversionesALista(mapaDeConversiones, cantidad);
        Impresiones.imprimirConPaginas(scanner, page, listaDeConversiones);
    }

    public boolean verificarCodigo(String codigoMoneda) {
        return supportedCurrencies.contains(codigoMoneda);
    }

//  Getters and Setters
    public String getSegundaMoneda() {
        return segundaMoneda;
    }

    public void setSegundaMoneda(String segundaMoneda) {
        this.segundaMoneda = segundaMoneda;
    }

    public String getPrimeraMoneda() {
        return primeraMoneda;
    }

    public void setPrimeraMoneda(String primeraMoneda) {
        this.primeraMoneda = primeraMoneda;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

}
