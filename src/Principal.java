import com.jesusflsa.conversor.exceptions.ErrorApiException;
import com.jesusflsa.conversor.exceptions.TypeProgramException;
import com.jesusflsa.conversor.modelos.Currency;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Currency currency = new Currency();
        Scanner in = new Scanner(System.in);


        while (true) {
            System.out.println("""
                    ********************
                    CONVERSOR DE MONEDAS
                    ********************
                    """);

            System.out.println("""
                     Escoja una de las opciones disponibles:
                                        \s
                     1. Convertir a una sola moneda.
                     2. Convertir a todas las monedas.
                     3. Lista de monedas soportadas.
                     \s
                     0. Salir.
                                        \s
                     Escoja opción escribiendo el número:
                    \s""");

            try {
                String input = in.next();
                int codigo = Integer.parseInt(input);
                if (codigo != 1 && codigo != 2 && codigo != 3 && codigo != 0)
                    throw new InputMismatchException("Ingresa un código válido");

                if (codigo == 0) {
                    System.out.println("Gracias por usar nuestro conversor de monedas.");
                    break;
                } else if (codigo == 3) {
                    System.out.println("Lista de códigos soportados:");
                    currency.mostrarCodigosSoportados(in, 1);
                } else {
                    System.out.println("Indica el código de la moneda con la que deseas iniciar:");
                    String codigoMoneda = in.next();
                    codigoMoneda = codigoMoneda.toUpperCase();

                    if (codigoMoneda.length() != 3 || !currency.verificarCodigo(codigoMoneda)) {
                        throw new TypeProgramException("Código inválido.");
                    }

                    System.out.println("Has seleccionado " + codigoMoneda + " como tu primera moneda.");
                    currency.setPrimeraMoneda(codigoMoneda);
                    System.out.println();

                    if (codigo == 1) {
                        System.out.println("Ahora indica el código de la moneda a la que quieres convertir:");
                        codigoMoneda = in.next();
                        codigoMoneda = codigoMoneda.toUpperCase();

                        if (codigoMoneda.length() != 3 || !currency.verificarCodigo(codigoMoneda)) {
                            throw new TypeProgramException("Código inválido.");
                        }

                        System.out.println("Has seleccionado " + codigoMoneda + " como tu segunda moneda.");
                        currency.setSegundaMoneda(codigoMoneda);
                        System.out.println();

                        System.out.println("Ingresa la cantidad que te gustaría convertir de " + currency.getPrimeraMoneda() + " a " + currency.getSegundaMoneda());
                        double cantidad = in.nextDouble();
                        currency.setCantidad(cantidad);
                        currency.mostrarComparacionDeDosMonedas();
                        System.out.println();
                    }

                    if (codigo == 2) {
                        System.out.println("Ingresa la cantidad que te gustaría convertir.");
                        double cantidad = in.nextDouble();
                        currency.setCantidad(cantidad);
                        System.out.println();
                        currency.mostrarComparacionTodasLasMonedas(in, 1);
                    }

                    System.out.println("¿Te gustaría realizar una nueva operación?");
                    System.out.println("1. Si.");
                    System.out.println("2. No");
                    System.out.println();
                    codigo = in.nextInt();
                    if (codigo != 1 && codigo != 2) {
                        throw new InputMismatchException("Ingresa un código válido");
                    }

                    if (codigo == 2) {
                        System.out.println("Gracias por usar nuestro conversor de monedas.");
                        break;
                    }
                }


            } catch (InputMismatchException | TypeProgramException | ErrorApiException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }

        }

    }
}
