package com.viniciusvieira.boracodar.model;

public class Subtracao extends  Operador{
    public Subtracao() {
        setSimbolo('-');
    }

    @Override
    public double calcular(double valor1, double valor2) {
        return valor1 - valor2;
    }
}
