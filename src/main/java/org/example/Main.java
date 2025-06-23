package org.example;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String API_KEY = "7a473f7606d02623a2631bff";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int currencyOption = 0;
        double cantidad;
        Gson gson = new Gson();
        do{
            System.out.println("┌─────────────────────────────────┐");
            System.out.println("│         CONVERSOS A DOLARES     │");
            System.out.println("├─────────────────────────────────┤");
            System.out.println("│ 1. Pesos Mexicanos (MXN)        │");
            System.out.println("│ 2. Euros (EUR)                  │");
            System.out.println("│ 3. Pesos Argentinos (ARS)       │");
            System.out.println("│ 4. Yenes Japoneses (JPY)        │");
            System.out.println("│ 5. Yuan Chino (CNY)             │");
            System.out.println("│ 0. Salir                        │");
            System.out.println("└─────────────────────────────────┘");
            System.out.print("Seleccione una opción (1-5): ");
            currencyOption = sc.nextInt();
            System.out.print("Ingrese la cantidad de dinero a convertir");
            cantidad = sc.nextDouble();
            String currency = "";
            switch (currencyOption){
                case 1:currency = "MXN";break;
                case 2:currency = "EUR";break;
                case 3:currency = "ARS";break;
                case 4:currency = "JPY";break;
                case 5:currency = "CNY";break;
                default:System.out.println("Ingrese una opcion valida");break;
            }
            System.out.println("currency = " + currency);
            String direction = BASE_URL+API_KEY+"/pair/USD/"+currency;
            
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direction)).build();
            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                Currency currency1 = gson.fromJson(response.body(), Currency.class);
                Moneda moneda = new Moneda(currency1);
                double resultado = moneda.convertirADolares(cantidad);
                System.out.println("$"+resultado+" dolares");
            }catch (Exception e){
                System.out.println("Ocurrio un error " +     e.getMessage());
            }
        }while (currencyOption != 0);








    }
}