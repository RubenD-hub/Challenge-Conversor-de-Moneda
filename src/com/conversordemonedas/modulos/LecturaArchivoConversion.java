package com.conversordemonedas.modulos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LecturaArchivoConversion {
    String rutaArchivo = "Tipo_De_Conversion.txt";


    public void mostrarLista(){

        for (TipoDeConversion conversion: leerArchivo()){
            System.out.println(conversion.conversion()+"\t"+conversion.monedaInicial()+"\t"+conversion.monedaFinal());
        }
    }

    public List<TipoDeConversion> leerArchivo() {
        List<TipoDeConversion> listaConversion = new ArrayList<>();
        try {
            BufferedReader lector = new BufferedReader(
                    new FileReader(rutaArchivo));
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] bloques = linea.split("\t");
                String conversion = bloques[0].trim();
                String monedaInicial = bloques[1].trim();
                String monedaFinal = bloques[2].trim();
                listaConversion.add(new TipoDeConversion(conversion, monedaInicial, monedaFinal));
            }
            lector.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo" + e.getMessage());
            return null;
        }
        return listaConversion;
    }
}
