package com.conversordemonedas.modulos;

import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.conversordemonedas.estilos.EstilosAnsi.*;


public class GenerarHistorial {
    private final List<Registro> registros = new ArrayList<>();
    private static final String archivoJson = "Historial.json";

    public void agregarRegistro(String monedaInicial, float monto, String monedaFinal, float conversion) {
        Registro registro = new Registro(monedaInicial, monto, monedaFinal, conversion);
        registros.add(registro);
        guardarHistorial();
    }

    public void mostrarRegistro() {
        if (registros.isEmpty()) {
            System.out.println(VERDE + "\n\n\t\t═══════════════════════════");
            System.out.println(MAGENTA + "\t\t⚠️ Historial no previo" + RESET);
            System.out.println(VERDE + "\t\t═══════════════════════════\n\n\n\n");
        } else {
            System.out.println(MAGENTA + "\n♦♦♦♦♦♦♦♦♦♦♦  Historial de Conversiones  ♦♦♦♦♦♦♦♦♦♦♦" + RESET);
            for (Registro registro : registros) {
                System.out.println(registro);
            }
        }
    }

    private void guardarHistorial() {
        try (FileWriter writer = new FileWriter(archivoJson)) {
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .registerTypeAdapter(LocalDateTime.class, (JsonSerializer<LocalDateTime>) (src, typeOfSrc, context) -> new JsonPrimitive(src.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))))
                    .create();
            gson.toJson(registros, writer);
        } catch (IOException e) {
            System.out.println(ROJO + "❌ Error al guardar el archivo: " + e.getMessage() + RESET);
        }
    }
}

