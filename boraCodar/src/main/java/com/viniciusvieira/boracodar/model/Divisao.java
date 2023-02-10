package com.viniciusvieira.boracodar.model;

public class Divisao extends Operador{
    public Divisao() {
        setSimbolo('/');
    }

    @Override
    public double calcular(double valor1, double valor2) {
        return valor1 / valor2;
    }
}
