package com.example.app.controllers;

import com.example.app.TableStructure.*;
import com.example.app.View.View;
import com.example.app.View.ViewSwitch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginPageController {
    @FXML
    public PasswordField pasField;
    @FXML
    private ChoiceBox<String> CompanyTypeChoice;
    @FXML
    private String[] tables = {"kooperation", "centercoop", "admin"};
    @FXML
    public TextField textField;


    @FXML
    public void initialize()
    {
        CompanyTypeChoice.getItems().addAll(tables);
    }

    @FXML
    public void logIn() throws IOException, SQLException {
        HashTable.makeHashTables();
        if (!textField.getText().equals("") && !pasField.getText().equals("")) {
            System.out.println(textField.getText() + " " + CompanyTypeChoice.getValue() + " " + pasField.getText());

            Boolean infoStatus = DBUtil.findUser(textField.getText(), pasField.getText(), CompanyTypeChoice.getValue());
            if (!infoStatus) {
                System.out.println("not correct");
            } else {
                ViewSwitch.switchView(View.LoggedIn);
                System.out.println(User.getName());
            }
        }else{
            System.out.println("du har ikke indtastet noget");
        }


    }
}
