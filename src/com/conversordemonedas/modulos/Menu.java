package com.conversordemonedas.modulos;

import java.util.*;

import static com.conversordemonedas.estilos.EstilosAnsi.*;

public class Menu {
    private final Scanner scan;

    private final String[] menu_principal = {
            "Convertir moneda",
            "Historial de conversiones",
            "Salir"};

    public Menu() {
        this.scan = new Scanner(System.in);
    }

    public int menuPrincipal() {
        System.out.println(MAGENTA + "♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦  MENÚ  ♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦♦");
        for (int i = 0; i < menu_principal.length; i++) {
            if (i != menu_principal.length - 1) {
                System.out.printf(CYAN + "\t%d. %s\n", i + 1, menu_principal[i]);
            } else {
                System.out.printf(ROJO + "\t%d. %s\n" + RESET, i + 1, menu_principal[i]);
            }
        }

        String msg = AMARILLO + "\n\t-> ¿Cuál es la opción que desea hacer?: ";
        return OpcionAValidar(msg, menu_principal.length, 0);
    }

    public void mostrarMenu(List<TipoDeConversion> lista) {
        System.out.println(MAGENTA + "♦♦♦♦♦♦♦♦♦♦♦  Convertir Moneda  ♦♦♦♦♦♦♦♦♦♦♦");
        for (int i = 0; i < lista.size(); i++) {
            System.out.printf(CYAN + "\t%d. %s\n", i + 1, lista.get(i).conversion());
        }
        System.out.println(ROJO + "\t" + (lista.size() + 1) + ". Regresar" + RESET);
    }

    public int mostrarYSeleccionar(List<TipoDeConversion> lista) {
        mostrarMenu(lista);
        String msg = AMARILLO + "\n\t-> ¿Cuál es la opción que desea hacer?: ";
        return OpcionAValidar(msg, lista.size(), 1);
    }

    public int OtraConversion() {
        String msg = AMARILLO + "\n\t-> ¿Desea hacer otra conversión?\n\t\t1) Sí\n\t\t2) No\n\t\t-> ";
        return OpcionAValidar(msg, 2, 0);
    }

    private int OpcionAValidar(String msg, int numOpciones, int offset) {
        while (true) {
            System.out.print(msg);
            try {
                int opc = scan.nextInt();
                if (opc < 1 || opc > numOpciones + offset) {
                    System.out.println("\t¡¡Opción incorrecta!!\n\tVuelva a intentarlo.");
                    continue;
                }
                // Devuelve la respuesta correspondiente
                return opc;
            } catch (InputMismatchException e) {
                System.out.println("\t¡¡Error: debe ingresar un número!!\n\tVuelva a intentarlo.");
                scan.nextLine(); // Limpiar el buffer
            }
        }
    }
}
