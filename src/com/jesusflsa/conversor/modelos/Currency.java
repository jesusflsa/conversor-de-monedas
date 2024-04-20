package com.jesusflsa.conversor.modelos;

import com.jesusflsa.conversor.api.ConsultaApi;
import com.jesusflsa.conversor.api.PairConvertionExchange;

import java.util.*;

public class Currency {


    private String primeraMoneda;
    private String segundaMoneda;

    private double cantidad;

    public void mostrarComparacionDeDosMonedas() {
        PairConvertionExchange resultado = ConsultaApi.convertirUnaMoneda(primeraMoneda, segundaMoneda, cantidad);
        if (resultado.result().equals("error")) {
            System.out.println("Hubo un error al realizar la conversión");
            throw new RuntimeException(resultado.errorType());
        }

        System.out.println(primeraMoneda + " " + cantidad + " son: " + segundaMoneda + " " + resultado.conversionResult());
    }

    public String escogerCodigosSoportados(Scanner scanner, int page) {
        List<List<String>> supportedList = ConsultaApi.obtenerCodigoSoportados().supportedCodes();
        int cantidad = 10;
        int cantidadMaximaDePaginas = supportedList.size() / cantidad;
        int primerIndex = (page - 1) * cantidad;
        int segundoIndex = page * cantidad;
        List<List<String>> listaPorImprimir = supportedList.subList(primerIndex, segundoIndex);

        System.out.println("Página " + page + " de " + cantidadMaximaDePaginas);
        for (int i = 0; i < listaPorImprimir.size(); i++) {
            List<String> supportedCurrency = listaPorImprimir.get(i);
            String code = supportedCurrency.get(0);
            String name = supportedCurrency.get(1);

            System.out.println(i + 1 + ". [ " + code + " ] - " + name);
        }
        System.out.println("\n");
        if (page != 1) System.out.println(cantidad + 1 + ". Página anterior.");
        if (page != cantidadMaximaDePaginas) System.out.println(cantidad + 2 + ". Siguiente página.");
        System.out.println("\n");
        System.out.println("Escoja una opción");

        int opcion = scanner.nextInt();



        if (opcion >= 1 && opcion <= cantidad + 2) {

            if (opcion == cantidad + 1 && page != 1) return escogerCodigosSoportados(scanner, page - 1);
            if (opcion == cantidad + 2 && page != cantidadMaximaDePaginas)
                return escogerCodigosSoportados(scanner, page + 1);

            return supportedList.get(primerIndex - 1 + opcion).get(0);
        }

        throw new InputMismatchException();
    }

    public void mostrarComparacionTodasLasMonedas(Scanner scanner) {
        mostrarComparacionTodasLasMonedas(scanner, 1);
    }

    public void mostrarComparacionTodasLasMonedas(Scanner scanner, int page) {

        Map<String, Double> listaConvertida = ConsultaApi.convertirTodasLasMonedas(primeraMoneda).conversionRates();
        listaConvertida.remove(primeraMoneda);

        List<String> keys = new ArrayList<>(listaConvertida.keySet());
        List<Double> values = new ArrayList<>(listaConvertida.values());

        int cantidad = 10;
        int cantidadMaximaDePaginas = keys.size() / cantidad;
        int primerIndex = (page - 1) * cantidad;
        int segundoIndex = page * cantidad;

        List<String> keysPorImprimir = keys.subList(primerIndex, segundoIndex);
        List<Double> valuesPorImprimir = values.subList(primerIndex, segundoIndex);

        System.out.println("Página " + page + " de " + cantidadMaximaDePaginas);

        for (int i = 0; i < keysPorImprimir.size(); i++) {

            String code = keysPorImprimir.get(i);
            double amount = valuesPorImprimir.get(i);

            System.out.println("[" + code + "] - " + amount);
        }
        System.out.println("\n");
        if (page != 1) System.out.println(cantidad + 1 + ". Página anterior.");
        if (page != cantidadMaximaDePaginas) System.out.println(cantidad + 2 + ". Siguiente página.");
        System.out.println("0. Salir");
        System.out.println("\n");
        System.out.println("Escoja una opción");

        int opcion = scanner.nextInt();

        if (opcion == 0) return;

        if (opcion >= cantidad + 1 && opcion <= cantidad + 2) {

            if (opcion == cantidad + 1 && page != 1) mostrarComparacionTodasLasMonedas(scanner, page - 1);
            if (opcion == cantidad + 2 && page != cantidadMaximaDePaginas)
                mostrarComparacionTodasLasMonedas(scanner, page + 1);
            return;
        }

        throw new InputMismatchException();
    }
//    Getters and Setters

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
