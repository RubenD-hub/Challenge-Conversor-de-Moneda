package com.conversordemonedas.principal;

import com.conversordemonedas.modulos.*;

import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

//      Instancias a clases
        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();
        LecturaArchivoConversion archivo = new LecturaArchivoConversion();
        ConsultaMoneda conversionAPI = new ConsultaMoneda();

        System.out.println("***************************************************");
        System.out.println("\t* Bienvenido/a a la App de cambio de Divisa *\n");

//      Lectura de archivo y despliegue del menu
        List<TipoDeConversion> listaConversion = archivo.leerArchivo();

//      Bucle principal
        while (true) {
            int opc = menu.mostrarYSeleccionar(listaConversion);
//          Rompe el bucle por seleccionar la opción salir
            if (opc == listaConversion.size() + 1) {
                break;
            }

//          Obtiene la conversion seleccionada y hace la consulta a la API
            TipoDeConversion monedaAConvertir = listaConversion.get(opc - 1);
            Moneda moneda = conversionAPI.buscarDivisa(monedaAConvertir);

//          Pide el monto y hace la conversion
            System.out.print("\t\t -> Ingresa el valor que deseas convertir: ");
            float monto = scan.nextFloat();
            float montoFinal = moneda.CalculoConversion(monto, monedaAConvertir.monedaFinal());
            System.out.printf("\t\t  El valor de %.5f [%s] corresponde al valor final de: %.5f [%s]\n",
                    monto,
                    monedaAConvertir.monedaInicial(),
                    montoFinal,
                    monedaAConvertir.monedaFinal());

//          Pregunta si se desea hacer otra conversion
            scan.nextLine();
            if (menu.OtraConversion().equals("No")) {
                break;
            }
        }

        System.out.println("\n\t* Fin de la Ejecución de la aplicación *");
        System.out.println("***************************************************");

    }
}
