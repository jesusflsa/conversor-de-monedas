package com.jesusflsa.conversor.utils;

import java.util.List;
import java.util.Scanner;

public class Impresiones {
    public static void imprimirConPaginas(Scanner scanner, int page, List<List<String>> lista) {
        int cantidad = 10;
        int cantidadMaximaDePaginas = lista.size() / cantidad;
        int primerIndex = (page - 1) * cantidad;
        int segundoIndex = page * cantidad;

        List<List<String>> listaPorImprimir = lista.subList(primerIndex, segundoIndex);

//      Lista de códigos soportados limitados por la variable cantidad.
        for (List<String> valores : listaPorImprimir) {
            String key = valores.get(0);
            String value = valores.get(1);

            System.out.println("[ " + key + " ] - " + value);
        }

//      Indicador de la página en la que el usuario se encuentra.
        System.out.println();
        System.out.println("Página " + page + " de " + cantidadMaximaDePaginas);
        System.out.println();

        if (page != 1) System.out.println("1. Retroceder página.");
        if (page != cantidadMaximaDePaginas) System.out.println("2. Siguiente página.");
        System.out.println("0. Salir.");

        while (true) {
            System.out.println();
            System.out.println("Indique su número de acción:");

            int opcion = 0;

            try {
                opcion = scanner.nextInt();
                if (opcion != 1 && opcion != 2 && opcion != 0) throw new RuntimeException();

            } catch (RuntimeException e) {
                System.out.println("Opción inválida.");
            }

//          El usuario marca la opción 0.
            if (opcion == 0) {
                System.out.println("Has salido del listado de códigos soportados.");
                return;
            };

//          El usuario marca la opción 1 y no se encuentra en la primera página.
            if (opcion == 1 && page != 1) {
                System.out.println("Has avanzado a la siguiente página.");
                System.out.println();
                imprimirConPaginas(scanner, page - 1, lista);
                return;
            }

//          El usuario marca la opción 2 y no se encuentra en la última página.
            if (opcion == 2 && page != cantidadMaximaDePaginas) {
                System.out.println("Has regresado a la página anterior.");
                System.out.println();
                imprimirConPaginas(scanner, page + 1, lista);
                return;
            };
        }
    }
}
