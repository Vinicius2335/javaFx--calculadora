package com.viniciusvieira.boracodar.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.ICSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class CriarArquivoOpenCsvService {

    static String dir = System.getProperty("user.dir");
    private static final File arquivo = new File(dir + "/calculos.csv");
    private static final Path arquivoPath = Paths.get(dir + "/calculos.csv");

    public void criarArquivo(String formula, double resultado) {
        System.out.println(arquivo.exists());
        if (!arquivo.exists()) {
            criarCabecalho();
        }

        List<String[]> linhasExistentes = linhasExistentes();
        adicionarResultado(linhasExistentes, formula, resultado);
    }

    private void criarCabecalho() {
        String[] cabecalho = {"formula", "resultado", "data"};

        try (
                FileWriter fw = new FileWriter(arquivo);
                BufferedWriter bw = new BufferedWriter(fw)
        ) {
            Writer writer = bw;
            CSVWriter csvWriter = new CSVWriter(writer);

            csvWriter.writeNext(cabecalho);
            csvWriter.flush();
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException("Erro ao tentar criar o cabeçalho do arquivo", e);
        }
    }

    private void adicionarResultado(List<String[]> linhasExistentes, String formula, double resultado) {
        try (
                FileWriter fw = new FileWriter(arquivo);
                BufferedWriter bw = new BufferedWriter(fw);
                CSVWriter csvWriter = new CSVWriter(bw, ';', ICSVWriter.NO_QUOTE_CHARACTER,
                        ICSVWriter.NO_ESCAPE_CHARACTER, ICSVWriter.DEFAULT_LINE_END)
        ) {
            OffsetDateTime data = OffsetDateTime.now();
            String[] novaLinha = {formula, String.valueOf(resultado), data.toString()};

            for (String[] linha : linhasExistentes) {
                csvWriter.writeNext(linha);
            }

            csvWriter.writeNext(novaLinha);
            csvWriter.flush();

        } catch (IOException e) {
            throw new RuntimeException("Erro ao tentar adicionar uma nova linha ao arquivo", e);
        }
    }

    private List<String[]> linhasExistentes() {
        List<String[]> linhas = new ArrayList<>();

        try (
                Reader reader = Files.newBufferedReader(arquivoPath);
                CSVReader csvReader = new CSVReader(reader);
        ) {
            String[] linha;

            while ((linha = csvReader.readNext()) != null) {
                linhas.add(linha);
            }

        } catch (IOException e) {
            throw new RuntimeException("Erro ao tentar ler o conteudo do arquivo", e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return linhas;
    }

}
