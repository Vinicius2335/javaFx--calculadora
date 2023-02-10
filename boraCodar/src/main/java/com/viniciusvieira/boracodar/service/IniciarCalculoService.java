package com.viniciusvieira.boracodar.service;

import com.viniciusvieira.boracodar.exception.UnsupportedCharacterException;
import com.viniciusvieira.boracodar.model.Operador;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class IniciarCalculoService {

    public double iniciarCalculo(List<Operador> operadoresSuportados, String formula) {
        formula = formula.trim();
        List<Double> numeros = new ArrayList<>();
        List<Character> operadores = new ArrayList<>();
        String numeroAsString = "";

        // separanando os numeros dos operadores da formula
        for (int i = 0; i < formula.length(); i++) {
            String valorAsString = String.valueOf(formula.charAt(i));
            char valorAsChar = formula.charAt(i);

            if (isNumero(valorAsString)) {
                numeroAsString = numeroAsString.concat(valorAsString);
            } else if (isOperador(valorAsChar, operadoresSuportados)) {
                numeros.add(Double.parseDouble(numeroAsString));
                operadores.add(valorAsChar);
                numeroAsString = "";
            }

            if (i + 1 == formula.length()) {
                numeros.add(Double.parseDouble(numeroAsString));
            }
        }

        // gerando o resultado das operaçoes
        return realizarOperacoes(numeros, operadores, operadoresSuportados);
    }

    // verificando se o valor é um numero
    private boolean isNumero(String valor) {
        try {
            Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // verificando se o valor é um operador
    private boolean isOperador(char valor, List<Operador> operadoresSuportados) {
        for (Operador op : operadoresSuportados) {
            if (valor == op.getSimbolo()) {
                return true;
            }
        }

        // se o valor não foi um numero e nao é um operador, lança um dialog
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Opa!");
        alert.setHeaderText(null);
        alert.setContentText("O caractere '" + valor + "' não é suportado.");
        alert.showAndWait();
        throw new UnsupportedCharacterException("O caractere '" + valor + "' não é suportado.");
    }

    private Double realizarOperacoes(List<Double> numeros, List<Character> operadores,
                                     List<Operador> operadoresSuportados) {
        double resultado = 0;

        for (int i = 0; i < numeros.size(); i++) {

            if (i == 0) {
                resultado = numeros.get(i);
            } else {
                for (Operador op : operadoresSuportados) {
                    if (operadores.get(i - 1) == op.getSimbolo()) {
                        resultado = op.calcular(resultado, numeros.get(i));
                        break;
                    }
                }
            }
        }

        return resultado;
    }
}
