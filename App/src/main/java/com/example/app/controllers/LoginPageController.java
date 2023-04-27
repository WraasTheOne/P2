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
        CompanyTypeChoice.getSelectionModel().select(0);
    }

    @FXML
    public void logIn() throws IOException {
        HashTable.makeHashTables();
        if (!textField.getText().equals("") && !pasField.getText().equals("") && CompanyTypeChoice.getValue() != null) {

            Boolean infoStatus = DBUtil.findUser(textField.getText(), pasField.getText(), CompanyTypeChoice.getValue());
            if (!infoStatus) {
                System.out.println("not correct");
            } else {

                switch(CompanyTypeChoice.getValue())
                {
                    case "kooperation":
                        ViewSwitch.switchView(View.LoggedIn);
                        break;

                    case "centercoop":
                        ViewSwitch.switchView(View.LoggedInCenterCoop);
                        break;

                    case "admin":
                        ViewSwitch.switchView(View.LoggedInAdmin);
                        break;
                }

                System.out.println(User.getName());
            }
        }else{
            System.out.println("du har ikke indtastet noget");
        }

    }

}
