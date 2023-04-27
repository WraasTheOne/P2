package com.example.app.controllers;

import com.example.app.TableStructure.BigBag;
import com.example.app.TableStructure.DBUtil;
import com.example.app.TableStructure.User;
import com.example.app.TableStructure.WalleCube;
import com.example.app.View.View;
import com.example.app.View.ViewSwitch;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;

public class WalleCubeOverviewController {

    @FXML
    public Button backButton;
    @FXML
    public Button refreshButton;
    @FXML
    public TextField searchField;
    @FXML
    public TableColumn<WalleCube,String>  WIDColumn;
    @FXML
    public TableColumn<WalleCube,String>  TypeColumn;
    @FXML
    public TableColumn<WalleCube,String> CenterIdCoulmn;
    public TableView<WalleCube> Tableview;

    private ObservableList<WalleCube> dataForTable;


    public void initialize() {
        WIDColumn.setCellValueFactory(new PropertyValueFactory<>("WID"));
        TypeColumn.setCellValueFactory(new PropertyValueFactory<>("Type"));
        CenterIdCoulmn.setCellValueFactory(new PropertyValueFactory<>("CenterId"));

        Tableview.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {

                ViewSwitch.switchView(View.ChangeProcess);
            }
        });

        try{
            dataForTable = DBUtil.getDataForTableWalle("Wallecubes", User.getID());
            Tableview.setItems(dataForTable);
        }catch (SQLException e){
            System.out.println(e);

        }

    }

}
