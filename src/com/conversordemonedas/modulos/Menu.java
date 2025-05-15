package com.conversordemonedas.modulos;

import java.util.*;

public class Menu {
    private final Scanner scan;

    public Menu() {
        this.scan = new Scanner(System.in);
    }

    public void mostrarMenu(List<TipoDeConversion> lista) {
        System.out.println("\t==========  MENÚ  ==========");
        for (int i = 0; i < lista.size(); i++) {
            System.out.printf("\t%d. %s\n", i + 1, lista.get(i).conversion());
        }
        System.out.println("\t" + (lista.size() + 1) + ". Salir");
    }

    public int mostrarYSeleccionar(List<TipoDeConversion> lista) {
        mostrarMenu(lista);
        while (true) {
            System.out.print("\n\t-> ¿Cuál es la opción que desea hacer?: ");
            try {
                int opc = scan.nextInt();
                if (opc < 1 || opc > lista.size() + 1) {
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

    public String OtraConversion() {
        while (true) {
            System.out.print("\n\t-> ¿Desea hacer otra conversión?\n\t\t1) Sí\n\t\t2) No\n\t\t-> ");
            try {
                int opc = scan.nextInt();
                if (opc < 1 || opc > 2) {
                    System.out.println("\t¡¡Opción incorrecta!!\n\tVuelva a intentarlo.");
                    continue;
                }
                // Devuelve la respuesta correspondiente
                return opc == 1 ? "Si" : "No";
            } catch (InputMismatchException e) {
                System.out.println("\t¡¡Error: debe ingresar un número!!\n\tVuelva a intentarlo.");
                scan.nextLine(); // Limpiar el buffer
            }
        }
    }
}
