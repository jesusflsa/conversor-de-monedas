import com.jesusflsa.conversor.modelos.Currency;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Currency currency = new Currency();
        Scanner in = new Scanner(System.in);

        System.out.println("""
                ##### CONVERSOR DE MONEDAS #####
                """);

        while (true) {
            System.out.println("""
                    Escoja el tipo de conversión que quiera hacer:
                    1. Convertir a una sola moneda.
                    2. Convertir a todas las monedas.
                    9. Salir.
                    """);

            try {
                int codigo = in.nextInt();
                if (codigo != 1 && codigo != 2 && codigo != 9)
                    throw new InputMismatchException("Ingresa un código válido");
                if (codigo == 9) break;

                System.out.println("""
                        Escoge la moneda con la que deseas iniciar:
                        """);
                String codigoMoneda = currency.escogerCodigosSoportados(in, 1);
                currency.setPrimeraMoneda(codigoMoneda);

                if (codigo == 1) {
                    System.out.println("""
                            Escoge la moneda a la que deseas convertir:
                            """);
                    codigoMoneda = currency.escogerCodigosSoportados(in, 1);
                    currency.setSegundaMoneda(codigoMoneda);

                    System.out.println("Ingresa la cantidad que te gustaría convertir de " + currency.getPrimeraMoneda() + " a " + currency.getSegundaMoneda());
                    double cantidad = in.nextDouble();
                    currency.setCantidad(cantidad);

                    currency.mostrarComparacionDeDosMonedas();

                } else {
                    System.out.println("Ingresa la cantidad que te gustaría convertir.");
                    double cantidad = in.nextDouble();
                    currency.setCantidad(cantidad);

                    currency.mostrarComparacionTodasLasMonedas(in);
                }


            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }

        }
        System.out.println("Gracias por usar nuestro conversor de monedas.");

    }
}
