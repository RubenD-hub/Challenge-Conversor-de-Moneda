package com.conversordemonedas.modulos;

import java.util.HashMap;
import java.util.Map;

public record Moneda(String result,
                     long time_last_update_unix,
                     String time_last_update_utc,
                     String base_code,
                     Map<String, Float> conversion_rates) {

    public Moneda(String result, long time_last_update_unix, String time_last_update_utc, String base_code) {
        this(result, time_last_update_unix, time_last_update_utc, base_code, new HashMap<>());
    }

    public float CalculoConversion(float monto, String monedaAConvertir) {
        return monto * conversion_rates.get(monedaAConvertir);
    }

    @Override
    public String toString() {
        return String.format("""
                            Datos de moneda:
                                Resultado del request: %s
                                Ultima actualización(UNIX): %d
                                Ultima actualización(UTC): %s
                                Código de Moneda: %s
                                Tasas de conversion: %s
                """, result(), time_last_update_unix(), time_last_update_utc(), base_code(), conversion_rates());
    }
}
