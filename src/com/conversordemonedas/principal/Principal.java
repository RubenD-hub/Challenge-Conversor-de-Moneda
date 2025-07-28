package com.conversordemonedas.principal;

import static com.conversordemonedas.estilos.EstilosAnsi.*;

import com.conversordemonedas.modulos.*;

import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

//      Intancias a clases
        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();
        LecturaArchivoConversion archivo = new LecturaArchivoConversion();
        ConsultaMoneda conversionAPI = new ConsultaMoneda();
        GenerarHistorial historial = new GenerarHistorial();

        System.out.println(VERDE + "╔═════════════════════════════════════════════════════════╗");
        System.out.println("║   🌐 Bienvenido/a a la App de cambio de Divisa 💲➡️💵   ║");
        System.out.println("╚═════════════════════════════════════════════════════════╝" + RESET);

//      Lectura de archivo y despliegue del menu
        List<TipoDeConversion> listaConversion = archivo.leerArchivo();

//      Bucle principal
        while (true) {
            int opc = menu.menuPrincipal();
            switch (opc) {
                case 1:
                    ConvertirMoneda(listaConversion, menu, conversionAPI,historial, scan);
                    break;
                case 2:
                    HistorialConversiones(historial);
                    break;
            }

//          Rompe el bucle por seleccionar la opción salir
            if (opc == 3) {
                break;
            }
        }
        System.out.println(ROJO + "\n\t* Fin de la Ejecución de la aplicación *");
        System.out.println("***************************************************" + RESET);
    }

    public static void ConvertirMoneda(List<TipoDeConversion> listaConversion, Menu menu, ConsultaMoneda conversionAPI, GenerarHistorial historial, Scanner scan) {
        while (true) {
            int opc = menu.mostrarYSeleccionar(listaConversion);
//      Rompe el bucle por seleccionar la opción regresar
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
            System.out.printf(RESET + "\t\t  El valor de " + VERDE + "%.5f [%s]" + RESET + " corresponde al valor final de: "
                            + VERDE + "%.5f [%s]\n" + RESET,
                    monto,
                    monedaAConvertir.monedaInicial(),
                    montoFinal,
                    monedaAConvertir.monedaFinal());
            historial.agregarRegistro(monedaAConvertir.monedaInicial(),monto,monedaAConvertir.monedaFinal(),montoFinal);
//          Pregunta si se desea hacer otra conversion
            if (menu.OtraConversion() == 2) {
                break;
            }
        }
    }

    public static void HistorialConversiones(GenerarHistorial historial) {
        historial.mostrarRegistro();
    }
}
