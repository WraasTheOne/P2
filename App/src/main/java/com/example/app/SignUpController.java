package com.example.app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;


public class SignUpController {


    @FXML
    private Button LoginButton;

    @FXML
    private TextField textField;

   @FXML
   private PasswordField pasField;


   @FXML
    protected void Loggin() throws IOException, SQLException {
       DBUtil.start();
       ViewSwitch.switchView(View.LoggedIn);

   }
}
