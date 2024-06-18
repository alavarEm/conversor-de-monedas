package com.ealavar.model;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {
    public double convertirMoneda(double cantidad, int opcion, String money) throws IOException, InterruptedException {
        String direccion = "https://v6.exchangerate-api.com/v6/1bc73600ef3a698f9e2651f7/latest/USD";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();//Esta variable almacena la peticion
        //System.out.println(json); Imprime todo lo que trae la peticion

        Gson gson = new Gson();

        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        // System.out.println(conversionRates.toString()); Imprime todo el contenido de conversion_rates

        double moneda = conversionRates.get(money).getAsDouble();
        double conversion = moneda * cantidad;
        return conversion;
    }

    public double convertirADolar(double cantidad, int opcion, String money) throws IOException, InterruptedException {
        String direccion = "https://v6.exchangerate-api.com/v6/1bc73600ef3a698f9e2651f7/latest/USD";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();//Esta variable almacena la peticion
        //System.out.println(json); Imprime todo lo que trae la peticion

        Gson gson = new Gson();

        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
        // System.out.println(conversionRates.toString()); Imprime todo el contenido de conversion_rates

        double moneda = conversionRates.get(money).getAsDouble();
        double conversion = cantidad / moneda;
        return conversion;
    }

    public String asignarMoneda(int moneda){
        String resultado=null;
        switch (moneda){
            case 1,2: resultado= "ARS";
                    break;
            case 3,4: resultado= "BRL";
                    break;
            case 5,6: resultado= "COP";
                    break;
        }
        return resultado;
    }

    public void menuConversor(){
        System.out.println("*****");
        System.out.println("Bienvenido al conversor de moneda");
        System.out.println("1- Dolar => peso argentino");
        System.out.println("2- Peso argentino => dolar");
        System.out.println("3- Dolar => real brasilenio");
        System.out.println("4- Real brasilenio => dolar");
        System.out.println("5- Dolar => peso colombiano");
        System.out.println("6- Peso colombiano => dolar");
        System.out.println("7- Salir");
        System.out.println("Elija una opcion valida:");
    }
}