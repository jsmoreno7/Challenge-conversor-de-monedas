
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrincipalConversorDeMoneda {
    public static void main(String[] args) {

        ObtenerMonedaApi obtenerValor = new ObtenerMonedaApi();
        var opcion = 0;
        Scanner lectura = new Scanner(System.in);
        System.out.println("*****************************************");
        System.out.println("Sea bienvenido/a al conversor de Moneda ");

        String menu = """
            
                    1 - "Dólar =>> Peso Argentino"
                    2 - "Peso Argentino =>> Dólar"
                    3 - "Dólar =>> Real brasileño"
                    4 - "Real brasileño =>> Dólar"
                    5 - "Dólar =>> Peso Colombiano"
                    6 - "Peso Colombiano =>> Dólar"
                    7 - "Salir"
                    """;


        while(opcion != 7){
            System.out.println(menu);
            System.out.println("*****************************************");

            System.out.println("Elija una opción válida");
            opcion = lectura.nextInt();
            Map<Integer, String> menuHashMap = new HashMap<>();
                    menuHashMap.put(1, "USD");
                    menuHashMap.put(2, "ARS");
                    menuHashMap.put(3, "USD");
                    menuHashMap.put(4, "BRL");
                    menuHashMap.put(5, "USD");
                    menuHashMap.put(6, "COP");

                    String claveM = menuHashMap.get(opcion);
                    //Sout para ver si se llama correctamente al valor del Hashmap.
                    //System.out.println(claveM);
                    DatosConversionMoneda moneda = obtenerValor.ConversorMoneda(claveM);

            switch (opcion){
                case 1:
                    System.out.println("Elijió Conversión de Dólar a Peso argentino... \n" +
                            "Ingrese el valor a convertir: ");
                    double cantidadDolarAars = lectura.nextDouble();
                    var pesosArsApi = moneda.conversion_rates().get("ARS");
                    double cantidadPesosA = (double) pesosArsApi;
                    cantidadDolarAars = cantidadDolarAars * cantidadPesosA;
                    System.out.println("El valor de Dólar a Peso argentino corresponde al valor final de "+ cantidadDolarAars);
                    break;
                case 2:
                    System.out.println("Elijió Conversión de Peso argentino a Dólar... \n " + "Ingrese el valor a convertir:");
                    double cantidadPesoAdolar = lectura.nextDouble();
                    var dolarApi1 = moneda.conversion_rates().get("USD");
                    double cantidadDolar1 = (double) dolarApi1;
                    cantidadPesoAdolar = cantidadPesoAdolar * cantidadDolar1;
                    System.out.println("El valor de Peso argentino a Dólar corresponde al valor final de "+ cantidadPesoAdolar);
                    break;
                case 3:
                    System.out.println("Elijió Conversión de Dólar a Real brasileño... \n" +
                            "Ingrese el valor a convertir:");
                    double cantidadDolarAbrl = lectura.nextDouble();
                    var realBrlApi = moneda.conversion_rates().get("BRL");
                    double cantidadRealB = (double) realBrlApi;
                    cantidadDolarAbrl = cantidadDolarAbrl * cantidadRealB;
                    System.out.println("El valor de Dólar a Real brasileño corresponde al valor final de "+ cantidadDolarAbrl);
                    break;
                case 4:
                    System.out.println("Elijió Conversión de Real brasileño a Dólar... \n" +
                            "Ingrese el valor a convertir:");
                    double cantidadBrlAdolar = lectura.nextDouble();
                    var dolarApi2  = moneda.conversion_rates().get("USD");
                    double cantidadDolar2 = (double) dolarApi2;
                    cantidadBrlAdolar = cantidadBrlAdolar * cantidadDolar2;
                    System.out.println("El valor de Real brasileño a Dólar corresponde al valor final de "+ cantidadBrlAdolar);
                    break;
                case 5:
                    System.out.println("Elijió Conversión de Dólar a Peso colombiano... \n" +
                            "Ingrese el valor a convertir:");
                    double cantidadDolarAcop = lectura.nextDouble();
                    var pesoCopApi = moneda.conversion_rates().get("COP");
                    double cantidadPesosC = (double) pesoCopApi;
                    cantidadDolarAcop = cantidadDolarAcop * cantidadPesosC;
                    System.out.println("El valor de Dólar a Peso colombiano corresponde al valor final de "+ cantidadDolarAcop);
                    break;
                case 6:
                    System.out.println("Elijió Conversión de Peso colombiano a Dólar... \n" +
                            "Ingrese el valor a convertir:");
                    double cantidadCopAdolar = lectura.nextDouble();
                    var dolarApi3  = moneda.conversion_rates().get("USD");
                    double cantidadDolar3 = (double) dolarApi3;
                    cantidadCopAdolar = cantidadCopAdolar * cantidadDolar3;
                    System.out.println("El valor de Peso colombiano a Dólar corresponde al valor final de "+ cantidadCopAdolar);
                    break;
                case 7:
                    System.out.println("Usted elijió la opción Salir");
                    System.out.println("*****************************************");
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida...");
                    System.out.println("*****************************************");
                   System.out.println("Elija una opción válida");
            }


            //Generar archivo Json
            GeneradorDeArchivo generador = new GeneradorDeArchivo();
            try {
                generador.guardarJson(moneda);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
