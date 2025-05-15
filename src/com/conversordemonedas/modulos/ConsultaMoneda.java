package com.conversordemonedas.modulos;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    public Moneda buscarDivisa(TipoDeConversion conversion) {
        String monedaInicial = conversion.monedaInicial();
        URI dirURL = URI.create("https://v6.exchangerate-api.com/v6/88666fd2c4743fadc8c2df86/latest/" + monedaInicial);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(dirURL)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa Moneda.");
        }
    }
}
