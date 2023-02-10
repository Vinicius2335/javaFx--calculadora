package com.viniciusvieira.boracodar.controller;

import com.viniciusvieira.boracodar.model.*;
import com.viniciusvieira.boracodar.service.CriarArquivoCsvService;
import com.viniciusvieira.boracodar.service.CriarArquivoOpenCsvService;
import com.viniciusvieira.boracodar.service.IniciarCalculoService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraController {
    @FXML
    public Button btnSubtraction;

    @FXML
    public Button btnResult;
    @FXML
    public Button btnExit;
    @FXML
    public Button btnDivision;
    @FXML
    public Button btnMultiplication;
    @FXML
    private Label lblCalculo;

    @FXML
    private Label lblResultado;

    private final List<Operador> operadoresSuportados = new ArrayList<>(List.of(
            new Soma(),
            new Subtracao(),
            new Multiplicacao(),
            new Divisao()
    ));

    @FXML
    void onClick1() {
        lblCalculo.setText(lblCalculo.getText() + "1");
    }

    @FXML
    void onClick2() {
        lblCalculo.setText(lblCalculo.getText() + "2");
    }

    @FXML
    void onClick3() {
        lblCalculo.setText(lblCalculo.getText() + "3");
    }

    @FXML
    void onClick4() {
        lblCalculo.setText(lblCalculo.getText() + "4");
    }

    @FXML
    void onClick5() {
        lblCalculo.setText(lblCalculo.getText() + "5");
    }

    @FXML
    void onClick6() {
        lblCalculo.setText(lblCalculo.getText() + "6");
    }

    @FXML
    void onClick7() {
        lblCalculo.setText(lblCalculo.getText() + "7");
    }

    @FXML
    void onClick8() {
        lblCalculo.setText(lblCalculo.getText() + "8");
    }

    @FXML
    void onClick9() {
        lblCalculo.setText(lblCalculo.getText() + "9");
    }

    @FXML
    void onClick0() {
        lblCalculo.setText(lblCalculo.getText() + "0");
    }

    @FXML
    void onClickSum() {
        lblCalculo.setText(lblCalculo.getText() + "+");
    }

    @FXML
    void onClickCE() {
        lblCalculo.setText("");
        lblResultado.setText("0");
    }

    @FXML
    void onClickClear() {
        lblCalculo.setText("");
    }

    public void onClickedSubtraction() {
        lblCalculo.setText(lblCalculo.getText() + "-");
    }

    public void onClickedResult() {
        IniciarCalculoService iniciarCalculoService = new IniciarCalculoService();
        String formula = lblCalculo.getText();
        double resultado = iniciarCalculoService.iniciarCalculo(operadoresSuportados, formula);
        lblResultado.setText(String.valueOf(resultado));

        CriarArquivoCsvService service = new CriarArquivoCsvService();
        //CriarArquivoOpenCsvService service = new CriarArquivoOpenCsvService();
        service.criarArquivo(formula, resultado);
    }

    public void onClickedExit() {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    public void onClickedDivision() {
        lblCalculo.setText(lblCalculo.getText() + "/");
    }

    public void onClickedMultiplication() {
        lblCalculo.setText(lblCalculo.getText() + "*");
    }
}