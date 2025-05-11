package com.conversordemonedas.modulos;

import java.util.*;

public class Menu {
    private ArrayList<String> opciones = new ArrayList<>(Arrays.asList(
            "Dolar =>> Peso Argentino",
            "Peso Argentino =>> Dolar",
            "Dolar =>> Real Brasileño",
            "Real Brasileño =>> Dolar",
            "Dolar =>> Peso Colombiano",
            "Peso Colombiano =>> Dolar",
            "Salir"));
    private Scanner scan;

    public Menu() {
        this.scan = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("\t==========  MENÚ  ==========");
        for (int i = 0; i < opciones.size(); i++) {
            System.out.printf("\t%d. %s\n", i + 1, opciones.get(i));
        }
    }

    public int mostrarYSeleccionar() {

        mostrarMenu();

        int opcion;
        while (true) {

            System.out.print("\n\t-> ¿Cuál es la opción que desea hacer?: ");

            try {
                opcion = scan.nextInt();
                if (opcion < 1 || opcion > opciones.size()) {
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
