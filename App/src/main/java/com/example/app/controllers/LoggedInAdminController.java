package com.example.app.controllers;

import com.example.app.TableStructure.DBUtil;
import com.example.app.TableStructure.TableData;
import com.example.app.View.View;
import com.example.app.View.ViewSwitch;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;



public class LoggedInAdminController
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
    private ChoiceBox<String> CompanyTableChoice;
    @FXML
    private TextField searchField;

    private String[] tables = {"kooperation", "centercoop", "admin"};

    private ObservableList<TableData> dataForTable;

    public void initialize()
    {
        CompanyTableChoice.getItems().addAll(tables);
        CompanyTableChoice.setValue("kooperation");

        try
        {
            kidColumn.setCellValueFactory(new PropertyValueFactory<TableData, Integer>("id"));
            usernameColumn.setCellValueFactory(new PropertyValueFactory<TableData, String>("name"));
            passwordColumn.setCellValueFactory(new PropertyValueFactory<TableData, String>("password"));

            dataForTable = DBUtil.getDataForTable("kooperation");

            userTable.setItems(dataForTable);
            currentTableView.setText("Table: kooperation");
        }
        catch (SQLException e)
        {
            System.out.println(e);
            currentTableView.setText("Table: Something went wrong");
        }

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                // If the search field is empty, show all rows in the table
                userTable.setItems(dataForTable);
            } else {
                // Filter the data by the entered search text
                userTable.setItems(dataForTable.filtered(TableData -> TableData.getId() == Integer.parseInt(newValue)));
            }
        });

    }
    @FXML
    private void refresh()
    {
        try
        {
            searchField.clear();
            userTable.getItems().clear();
            dataForTable = DBUtil.getDataForTable(CompanyTableChoice.getValue());
            userTable.setItems(DBUtil.getDataForTable(CompanyTableChoice.getValue()));
            currentTableView.setText("Table: " + CompanyTableChoice.getValue());
        }
        catch (SQLException e)
        {
            System.out.println(e);
            currentTableView.setText("Table: Please choose an option");
        }
    }

    @FXML
    protected void goToUserManagement() throws IOException
    {
        ViewSwitch.switchView(View.USERMANAGEMENT);
    }

    @FXML
    protected void goToBigBags()
    {
        ViewSwitch.switchView(View.BigbagView);
    }

    @FXML
    protected void goToWalleCubes()
    {
        ViewSwitch.switchView(View.WalleCubeOverview);
    }
    @FXML
    protected void goToLogs()
    {

    }

    @FXML
    protected void logOut()
    {
        ViewSwitch.switchView(View.LOGIN);
    }

}

