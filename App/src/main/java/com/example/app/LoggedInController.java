package com.example.app;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class LoggedInController {
    @FXML
    private Button Button1;

    @FXML
    private Button Button2;

    @FXML
    private Label Label1;

    @FXML
    protected void buttonCliked() throws IOException {
        System.out.println("HEJ");
        Label1.setText("Welcome to JavaFX Application!");
        Button1.setText("hej");
        Button2.setText("ad");
        ViewSwitch.switchView(View.HELLO);
        
    }
}
