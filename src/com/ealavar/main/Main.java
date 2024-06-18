package com.ealavar.main;

import com.ealavar.model.Moneda;
import com.ealavar.model.MonedaOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        System.out.println("*****");
        System.out.println("Bienvenido al conversor de moneda");
        System.out.println("1- Dolar => peso argentino");
        System.out.println("2- Peso argentino => dolar");
        System.out.println("3- Salir");
        System.out.println("Elija una opcion valida:");
        var moneda= lectura.nextInt(); //Es una variable que va a almacenar la opcion que elija el usuario
        var cantidad= lectura.nextDouble(); //Es una variable que va a almacenar la cantidad a convertir

        String direccion= "https://v6.exchangerate-api.com/v6/1bc73600ef3a698f9e2651f7/latest/USD";
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
        System.out.println(conversionRates.toString());

        double euro= conversionRates.get("EUR").getAsDouble();
        double conversion= euro*cantidad;
        System.out.println("Tasa de conversion de dolar a euro: "+conversion);



    }
}
