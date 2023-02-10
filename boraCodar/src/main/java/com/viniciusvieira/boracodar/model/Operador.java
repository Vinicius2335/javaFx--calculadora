package com.viniciusvieira.boracodar.model;

public abstract class Operador {

    private char simbolo;

    public abstract  double calcular(double valor1, double valor2);

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
}
