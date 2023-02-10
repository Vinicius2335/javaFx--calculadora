package com.viniciusvieira.boracodar.model;

public class Soma extends Operador{
    public Soma() {
        setSimbolo('+');
    }

    @Override
    public double calcular(double valor1, double valor2) {
        return valor1 + valor2;
    }
}
