package com.conversordemonedas.principal;

import com.conversordemonedas.modulos.Menu;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();

        System.out.println("***************************************************");
        System.out.println("\t* Bienvenid@ a la App de cambio de Divisa *\n");

        menu.mostrarYSeleccionar();

        System.out.println("\t* Fin de la Ejecucion de la aplicacion *");
        System.out.println("***************************************************");

    }
}
