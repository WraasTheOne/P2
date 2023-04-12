package com.example.app.controllers;

import com.example.app.TableStructure.DBUtil;
import com.example.app.TableStructure.Kooperation;
import com.example.app.View.View;
import com.example.app.View.ViewSwitch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginPageController {

    @FXML
    private ChoiceBox<String> userTypeDecideBox;
    @FXML
    private String[] tables = {"kooperation", "centercoop", "admin"};
    @FXML
    public TextField usernameField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public Button logInButton;
    @FXML
    public Label statusText;

    @FXML
    public void initialize(URL arg0, ResourceBundle arg1)
    {
        userTypeDecideBox.getItems().addAll(tables);
    }

    @FXML
    public void logIn() throws SQLException
    {
        DBUtil.getConnection();

        ResultSet userFound = DBUtil.findUsername(usernameField.getText(), userTypeDecideBox.getValue());

        userFound.next();

        System.out.println(userFound.getString("Name"));
        System.out.println(userFound.getString("password"));

        if(userFound.getString("Name").equals(usernameField.getText()) &&
                userFound.getString("password").equals(passwordField.getText()))
        {
            ViewSwitch.switchView(View.LOGIN);
            DBUtil.getConnection().close();
        }
        else
        {
            statusText.setTextFill(Color.RED);
            statusText.setText("Incorrect username or password");
        }

    }

}
