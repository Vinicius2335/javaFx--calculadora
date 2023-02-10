package com.viniciusvieira.boracodar.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class CalculadoraApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculadoraApplication.class.getResource("/fxml/calculadora-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 356, 566);

        InputStream iconPath = CalculadoraApplication.class.getResourceAsStream("/img/icon.jpg");
        stage.setTitle("Calculadora");
        stage.getIcons().add(new Image(iconPath));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}