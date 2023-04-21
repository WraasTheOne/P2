package com.example.app.controllers;

import com.example.app.TableStructure.DBUtil;

import com.example.app.View.View;
import com.example.app.View.ViewSwitch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import javax.swing.text.TableView;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.example.app.TableStructure.DBUtil;

public class UserManagementController implements Initializable
{
    @FXML
    TableView userTable;
    @FXML
    Button createUser;
    @FXML
    Button removeUser;
    @FXML
    TextField newField1;
    @FXML
    TextField newField2; //Will be used for creating a new password and removing a user. :)
    @FXML
    Label insertionStatus = null;
    @FXML
    private ChoiceBox<String> CompanyTypeChoice;
    @FXML
    private String[] tables = {"kooperation", "centercoop", "admin"};
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        CompanyTypeChoice.getItems().addAll(tables);
    }
    @FXML
    public void showAddUser()
    {
        createUser.setVisible(true);
        removeUser.setVisible(false);
        newField1.setVisible(true);
        newField2.setVisible(true);
        CompanyTypeChoice.setVisible(true);
        newField2.setPromptText("New password");
    }
    @FXML
    public void addUser()
    {
        if(newField1.getText().equals("") || newField2.getText().equals(""))
        {
            insertionStatus.setText("Please fill all the fields");
        }
        else
        {
            String insertionResult = DBUtil.insertUser(newField1.getText(), newField2.getText(), CompanyTypeChoice.getValue());
            insertionStatus.setText(insertionResult);
        }

    }
    @FXML
    public void showRemoveUser()
    {
        createUser.setVisible(false);
        removeUser.setVisible(true);
        newField1.setVisible(false);
        newField2.setVisible(true);
        CompanyTypeChoice.setVisible(true);
        newField2.setPromptText("Remove user");
    }
    @FXML
    public void removeUser()
    {
        if(newField2.getText().equals(""))
        {
            insertionStatus.setText("Please fill the field");
        }
        else
        {
            String insertionResult = DBUtil.removeUser(newField2.getText(), CompanyTypeChoice.getValue());
            insertionStatus.setText(insertionResult);
        }
    }
    @FXML
    public void returnToMainMenu()
    {
        ViewSwitch.switchView(View.LoggedInAdmin);
    }

}
