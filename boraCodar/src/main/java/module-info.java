module com.viniciusvieira.boracodar {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.opencsv;


    exports com.viniciusvieira.boracodar.view;
    opens com.viniciusvieira.boracodar.view to javafx.fxml;
    exports com.viniciusvieira.boracodar.controller;
    opens com.viniciusvieira.boracodar.controller to javafx.fxml;
}