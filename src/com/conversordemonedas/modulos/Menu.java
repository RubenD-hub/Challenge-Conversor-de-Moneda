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

        int opcion;
        while (true) {

            System.out.print("\n\t-> ¿Cuál es la opción que desea hacer?: ");

            try {
                opcion = scan.nextInt();
                if (opcion < 1 || opcion > lista.size() + 1) {
                    System.out.println("\t¡¡Opción incorrecta!!\n\tVuelva a intentarlo.");
                    continue;
                }
                return opcion; // Opción válida
            } catch (InputMismatchException e) {
                System.out.println("\t¡¡Error: debe ingresar un número!!\n\tVuelva a intentarlo.");
                scan.nextLine(); // Limpiar el buffer
            }
        }
    }
}
