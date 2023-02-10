package com.viniciusvieira.boracodar.service;

import java.io.*;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class CriarArquivoCsvService {
    static String dir = System.getProperty("user.dir");
    private static final File arquivo = new File(dir + "/calculos.csv");

    public CriarArquivoCsvService() {
        // constructor
    }

    public void criarArquivo(String formula, double resultado) {
        if (!arquivo.exists()) {
            criarCabecalho();
        }

        List<String> linhasExistentes = lerArquivo();
        adicionarResultado(linhasExistentes, formula, resultado);
    }

    private void criarCabecalho() {
        try (
                FileWriter fw = new FileWriter(arquivo, true);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            bw.write("Calculo;Resultado;Data;");
            bw.newLine();
            bw.flush();

        } catch (IOException e) {
            throw new RuntimeException("Erro ao tentar acessar o arquivo " + arquivo.getName(), e);
        }
    }

    private void adicionarResultado(List<String> linhasExistentes, String formula, double resultado) {
        try (
                FileWriter fw = new FileWriter(arquivo);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            OffsetDateTime data = OffsetDateTime.now();
            String novoResultado = formula + ";" + resultado + ";" + data + ";";

            linhasExistentes.add(novoResultado);

            StringBuilder unicaLinha = new StringBuilder();
            for(String linha : linhasExistentes){
                unicaLinha.append(linha).append("\n");
            }

            bw.write(unicaLinha.toString());
            bw.flush();

        } catch (IOException e) {
            throw new RuntimeException("Erro ao tentar adicionar um nuvo resultado ao arquivo " + arquivo.getName(), e);
        }
    }

    private List<String> lerArquivo() {
        try (
                FileReader fr = new FileReader(arquivo);
                BufferedReader br = new BufferedReader(fr)
        ) {
            String linha = "";
            List<String> linhas = new ArrayList<>();
            while ( (linha = br.readLine()) != null){
                linhas.add(linha);
            }
            return linhas;
        } catch (IOException e) {
            throw new RuntimeException("Erro ao tentar ler o arquivo " + arquivo.getName(), e);
        }
    }
}
