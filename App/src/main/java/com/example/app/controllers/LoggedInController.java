package com.example.app.controllers;

import com.example.app.TableStructure.BigBag;
import com.example.app.TableStructure.DBUtil;
import com.example.app.TableStructure.User;
import com.example.app.View.View;
import com.example.app.View.ViewSwitch;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;

public class LoggedInController {
    public Button BigbagOverviewButton;
    public Button WallecubeButton;
    @FXML
    private Button Button2;
    @FXML
    private Label userLabel;

    @FXML
    public TextField searchField;
    @FXML
    TableView<BigBag> Tableview;
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


    public LoggedInController(){}

    @FXML
    protected void goToCreateBigBag() throws IOException{
        ViewSwitch.switchView(View.BigBag);
    }

    @FXML
    protected void logOut()
    {
        ViewSwitch.switchView(View.LOGIN);
    }

    public void initialize(){



        BIDColumn.setCellValueFactory(new PropertyValueFactory<>("BID"));
        OwnerIDColumn.setCellValueFactory(new PropertyValueFactory<>("OwnerId"));
        NUVProcesColumn.setCellValueFactory(new PropertyValueFactory<>("NUVProcess"));
        TidligProcesColumn.setCellValueFactory(new PropertyValueFactory<>("TidligProcess"));
        TidSenOpColumn.setCellValueFactory(new PropertyValueFactory<>("TidSenOp"));
        TypeColumn.setCellValueFactory(new PropertyValueFactory<>("Type"));
        LocationColumn.setCellValueFactory(new PropertyValueFactory<>("Location"));
        BrugerSenOpColumn.setCellValueFactory(new PropertyValueFactory<>("BrugerSenop"));
        WalleIDColumn.setCellValueFactory(new PropertyValueFactory<>("WalleID"));

        Tableview.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                ChangeProcessController.bigBag = Tableview.getSelectionModel().getSelectedItem();
                ViewSwitch.switchView(View.ChangeProcess);
            }
        });

        try{
            dataForTable = DBUtil.getDataForTable("Bigbags", User.getID(),"ownerid");
            System.out.println();
            Tableview.setItems(dataForTable);
        }catch (SQLException e){
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
    protected void refresh() throws IOException, SQLException {
        searchField.clear();
        Tableview.getItems().clear();
        Tableview.setItems(DBUtil.getDataForTable("Bigbags", User.getID(),"ownerid"));

    }

 }