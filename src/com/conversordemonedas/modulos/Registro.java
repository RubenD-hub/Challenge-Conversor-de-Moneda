package com.conversordemonedas.modulos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.conversordemonedas.estilos.EstilosAnsi.*;

public record Registro(String monedaInicial,
                       float monto,
                       String monedaFinal,
                       float conversion,
                       LocalDateTime fechaConversion) {

    public Registro(String monedaInicial, float monto, String monedaFinal, float conversion) {
        this(monedaInicial, monto, monedaFinal, conversion, LocalDateTime.now());
    }

//  Metodo para obtener la fecha formateada
    public String fechaFormateada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return fechaConversion().format(formatter);
    }

    @Override
    public String toString() {
        return String.format("""
                        \t\t%s═══════════════════════════════════════════════════════
                        \t\t📝 Datos de Registro:
                        \t\t%s➡ Moneda base: %s%s
                        \t\t%s💰 Monto: %s%.2f
                        \t\t%s➡ Moneda final: %s%s
                        \t\t%s🔁 Conversión: %s%.2f
                        \t\t%s🕒 Fecha de solicitud: %s%s
                        \t\t%s═══════════════════════════════════════════════════════%s
                        """,
                VERDE,
                CYAN, AMARILLO, monedaInicial(),
                CYAN, AMARILLO, monto(),
                CYAN, AMARILLO, monedaFinal(),
                CYAN, AMARILLO, conversion(),
                CYAN, AMARILLO, fechaFormateada(),
                VERDE, RESET
        );
    }
}
