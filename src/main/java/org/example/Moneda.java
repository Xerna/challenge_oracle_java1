package org.example;

public class Moneda {
    private double valor;
    private double valorDolar = 1;
    public Moneda(Currency currency){
        this.valor = currency.conversion_rate();
    }

    public double getValor() {
        return valor;
    }
    public double convertirADolares(double cantidad){
        return cantidad * this.valor;
    }
}
