package com.conversordemonedas.principal;

import javax.sound.midi.Soundbank;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\n***************************************************");
        System.out.println("\t* Bienvenid@ a la App de cambio de Divisa *\n");

        while (true) {
            System.out.println("\t\t1) Dolar =>> Peso Argentino");
            System.out.println("\t\t2) Peso Argentino =>> Dolar");
            System.out.println("\t\t3) Dolar =>> Real Brasileño");
            System.out.println("\t\t4) Real Brasileño =>> Dolar");
            System.out.println("\t\t5) Dolar =>> Peso Colombiano");
            System.out.println("\t\t6) Peso Colombiano =>> Dolar");
            System.out.println("\t\t7) Salir");

            int opcion;
            while (true) {
                try {
                    System.out.print("\n\t\t-> ¿Cual es la opcion que desea hacer?: ");
                    opcion = scan.nextInt();
                    if (opcion < 1 || opcion > 7) {
                        throw new IllegalArgumentException("\t\t¡¡Opcion incoreecta!!\n\t\tVuelva a intentarlo");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("\t\t¡¡Error debe ingresar un numero!!\n\t\tVuelva a intentarlo");
                    scan.nextLine();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }


        }
    }
}
