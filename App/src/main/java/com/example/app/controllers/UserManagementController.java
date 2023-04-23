package com.example.app.controllers;

import com.example.app.TableStructure.*;

import com.example.app.View.View;
import com.example.app.View.ViewSwitch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import com.example.app.TableStructure.DBUtil;

public class UserManagementController implements Initializable
{
    @FXML
    TableView<TableData> userTable;
    @FXML
    TableColumn kidColumn;
    @FXML
    TableColumn usernameColumn;
    @FXML
    TableColumn passwordColumn;
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
    Label currentTableView = null;
    @FXML
    private ChoiceBox<String> CompanyTypeChoice;
    @FXML
    private ChoiceBox<String> CompanyTableChoice;
    private String[] tables = {"kooperation", "centercoop", "admin"};

    private ObservableList<TableData> dataForTable;
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        CompanyTypeChoice.getItems().addAll(tables);
        CompanyTableChoice.getItems().addAll(tables);

        try
        {
            kidColumn.setCellValueFactory(new PropertyValueFactory<TableData, Integer>("id"));
            usernameColumn.setCellValueFactory(new PropertyValueFactory<TableData, String>("name"));
            passwordColumn.setCellValueFactory(new PropertyValueFactory<TableData, String>("password"));

            userTable.setItems(getDataForTable("kooperation"));
            currentTableView.setText("Table: kooperation");
        }
        catch (SQLException e)
        {
            System.out.println(e);
            currentTableView.setText("Table: Something went wrong");
        }
    }
    @FXML
    private void chooseTableView()
    {
        try
        {
            userTable.setItems(getDataForTable(CompanyTableChoice.getValue()));
            currentTableView.setText("Table: " + CompanyTableChoice.getValue());
        }
        catch (SQLException e)
        {
            System.out.println(e);
            currentTableView.setText("Table: Please choose an option");
        }
    }

    private ObservableList<TableData> getDataForTable(String company) throws SQLException
    {
        String sqlAccounts = "SELECT * FROM " + company;
        PreparedStatement pstmt = DBUtil.getConnection().prepareStatement(sqlAccounts);
        ResultSet set = pstmt.executeQuery();
        ObservableList<TableData> data = FXCollections.observableArrayList();
        String idType = null;

        switch (company)
        {
            case "kooperation":
                idType = "KID";
                break;
            case "centercoop":
                idType = "CID";
                break;
            case "admin":
                idType = "AID";
                break;
        }

        while(set.next())
        {
            data.add(new TableData(set.getInt(idType), set.getString("Name"), set.getString("Password")));
        }

        return data;
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
    public void addUser() throws SQLException
    {
        if(newField1.getText().equals("") || newField2.getText().equals("") || CompanyTypeChoice.getValue() == null)
        {
            insertionStatus.setText("Please fill all the fields");
        }
        else
        {
            String insertionResult = DBUtil.insertUser(newField1.getText(), newField2.getText(), CompanyTypeChoice.getValue());
            userTable.setItems(getDataForTable(CompanyTableChoice.getValue()));
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
    public void removeUser() throws SQLException
    {
        if(newField2.getText().equals(""))
        {
            insertionStatus.setText("Please fill the field");
        }
        else
        {
            String insertionResult = DBUtil.removeUser(newField2.getText(), CompanyTypeChoice.getValue());
            userTable.setItems(getDataForTable(CompanyTableChoice.getValue()));
            insertionStatus.setText(insertionResult);
        }
    }
    @FXML
    public void returnToMainMenu()
    {
        ViewSwitch.switchView(View.LoggedInAdmin);
    }

}