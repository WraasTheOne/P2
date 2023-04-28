package com.example.app.controllers;

import com.example.app.TableStructure.Admin;
import com.example.app.TableStructure.BigBag;
import com.example.app.TableStructure.DBUtil;
import com.example.app.TableStructure.User;
import com.example.app.View.View;
import com.example.app.View.ViewSwitch;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;

import java.io.IOException;
import java.sql.SQLException;
import java.util.function.Predicate;

public class BigBagViewController{

    @FXML
    public TableColumn<BigBag, Integer> WalleIDCoulmn;
    @FXML
    public TextField searchField;
    @FXML
    TableView<BigBag> Tableview;
    @FXML
    public Button backButton;
    @FXML
    public Button refreshButton;
    @FXML
    public Button addBigBagButton;
    @FXML
    public Button removeBigBagButton;
    @FXML
    public TextField removeBigBagBIDField;
    @FXML
    public Button removeButton;

    @FXML
    public Label removeBigBagStatus;

    @FXML
    public TableColumn<BigBag, Integer> BIDColumn;
    @FXML
    public TableColumn<BigBag, Integer> WalleIDColumn;
    @FXML
    public TableColumn<BigBag, String> BrugerSenOpColumn;
    @FXML
    public TableColumn<BigBag, Integer> LocationColumn;
    @FXML
    public TableColumn<BigBag, String> TypeColumn;
    @FXML
    public TableColumn<BigBag, String> TidSenOpColumn;
    @FXML
    public TableColumn<BigBag, Integer> TidligProcesColumn;
    @FXML
    public TableColumn<BigBag, Integer> NUVProcesColumn;
    @FXML
    public TableColumn<BigBag, Integer> OwnerIDColumn;

    private ObservableList<BigBag> dataForTable;

    public void initialize() throws SQLException, IOException {


        BIDColumn.setCellValueFactory(new PropertyValueFactory<BigBag, Integer>("BID"));
        OwnerIDColumn.setCellValueFactory(new PropertyValueFactory<BigBag, Integer>("OwnerId"));
        NUVProcesColumn.setCellValueFactory(new PropertyValueFactory<BigBag, Integer>("NUVProcess"));
        TidligProcesColumn.setCellValueFactory(new PropertyValueFactory<BigBag, Integer>("TidligProcess"));
        TidSenOpColumn.setCellValueFactory(new PropertyValueFactory<BigBag, String>("TidSenOp"));
        TypeColumn.setCellValueFactory(new PropertyValueFactory<BigBag, String>("Type"));
        LocationColumn.setCellValueFactory(new PropertyValueFactory<BigBag, Integer>("Location"));
        BrugerSenOpColumn.setCellValueFactory(new PropertyValueFactory<BigBag, String>("BrugerSenop"));
        WalleIDCoulmn.setCellValueFactory(new PropertyValueFactory<BigBag, Integer>("WalleID"));

        Tableview.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                ChangeProcessController.bigBag = Tableview.getSelectionModel().getSelectedItem();
                ViewSwitch.switchView(View.ChangeProcess);
            }
        });

        try{
            if(User.getUsertype().equals("admin"))
            {
                dataForTable = DBUtil.getAllBigBags();
                addBigBagButton.setVisible(true);
                removeBigBagButton.setVisible(true);
            }
            else
            {
                dataForTable = DBUtil.getDataForTable("Bigbags", User.getID());
            }

            Tableview.setItems(dataForTable);
        }
        catch (SQLException e) {
            System.out.println(e);
        }

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                // If the search field is empty, show all rows in the table
                Tableview.setItems(dataForTable);
            } else {
                // Filter the data by the entered search text
                Tableview.setItems(dataForTable.filtered(bigbag -> bigbag.getBID() == Integer.parseInt(newValue)));
            }
        });

    }

    @FXML
    protected void goBack() throws IOException{

        switch(User.getUsertype())
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

    }

    @FXML
    protected void goToCreateBigBag() throws IOException{
        ViewSwitch.switchView(View.BigBag);
    }

    @FXML
    protected void showRemoveBigBag()
    {
        removeButton.setVisible(true);
        removeBigBagBIDField.setVisible(true);
    }

    @FXML
    protected void removeBigBag() throws IOException, SQLException{

        if(removeBigBagBIDField.getText().equals(""))
        {
            removeBigBagStatus.setText("Please enter a BID");
        }
        else
        {
            removeBigBagStatus.setText(Admin.removeBigBag(Integer.parseInt(removeBigBagBIDField.getText())));
            refresh();
        }

    }

    @FXML
    protected void refresh() throws IOException, SQLException {
        searchField.clear();
        Tableview.getItems().clear();

        if(User.getUsertype().equals("admin"))
        {
            Tableview.setItems(DBUtil.getAllBigBags());
        }
        else
        {
            Tableview.setItems(DBUtil.getDataForTable("Bigbags", User.getID()));
        }

    }

}
