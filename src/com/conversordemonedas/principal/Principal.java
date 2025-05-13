package com.conversordemonedas.principal;

import com.conversordemonedas.modulos.LecturaArchivoConversion;
import com.conversordemonedas.modulos.Menu;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Menu menu = new Menu();
        LecturaArchivoConversion archivo=new LecturaArchivoConversion();

        System.out.println("***************************************************");
        System.out.println("\t* Bienvenid@ a la App de cambio de Divisa *\n");


        menu.mostrarYSeleccionar(archivo.leerArchivo());

        System.out.println("\t* Fin de la Ejecucion de la aplicacion *");
        System.out.println("***************************************************");

    }
}
