package com.viniciusvieira.boracodar.model;

public class Multiplicacao extends Operador{
    public Multiplicacao() {
        setSimbolo('*');
    }

    @Override
    public double calcular(double valor1, double valor2) {
        return valor1 * valor2;
    }
}
