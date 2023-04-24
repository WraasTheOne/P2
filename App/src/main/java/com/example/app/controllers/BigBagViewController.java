package com.example.app.controllers;

import com.example.app.TableStructure.BigBag;
import com.example.app.TableStructure.DBUtil;
import com.example.app.TableStructure.User;
import com.example.app.View.View;
import com.example.app.View.ViewSwitch;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;

public class BigBagViewController {
    @FXML
    public TableColumn<BigBag, Integer> WalleIDCoulmn;
    @FXML
    TableView<BigBag> Tableview;
    @FXML
    public Button backButton;
    @FXML
    public Button refreshButton;
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
            Tableview.setItems(DBUtil.getDataForTable("Bigbags", User.getID()));
        }catch (SQLException e){
            System.out.println(e);

        }

    }

    @FXML
    protected void goBack() throws IOException{
        ViewSwitch.switchView(View.LoggedIn);
    }





}
