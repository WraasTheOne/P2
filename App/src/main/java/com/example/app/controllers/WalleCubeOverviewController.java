package com.example.app.controllers;

import com.example.app.TableStructure.*;
import com.example.app.View.View;
import com.example.app.View.ViewSwitch;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;

public class WalleCubeOverviewController {



    @FXML
    public Button backButton;
    @FXML
    public Button refreshButton;
    @FXML
    public Button removeButton;
    @FXML
    public TextField searchField;
    @FXML
    public TextField removeField;
    @FXML
    public TableColumn<WalleCube,String>  WIDColumn;
    @FXML
    public TableColumn<WalleCube,String>  TypeColumn;
    @FXML
    public TableColumn<WalleCube,String> CenterIdCoulmn;
    @FXML
    public Label statusText;
    public TableView<WalleCube> Tableview;

    private ObservableList<WalleCube> dataForTable;


    public void initialize() {
        WIDColumn.setCellValueFactory(new PropertyValueFactory<>("WID"));
        TypeColumn.setCellValueFactory(new PropertyValueFactory<>("Type"));
        CenterIdCoulmn.setCellValueFactory(new PropertyValueFactory<>("CenterId"));

        Tableview.setOnMouseClicked(event -> {
            if (event.getClickCount() == 2) {
                BigbagFromWalleCubeOverviewController.walleCube = Tableview.getSelectionModel().getSelectedItem();
                ViewSwitch.switchView(View.BigbagFromWalleCube);
            }
        });

        try{

            if(User.getUsertype().equals("admin"))
            {
                dataForTable = DBUtil.getAllWalleCubes();
            }
            else
            {
                dataForTable = DBUtil.getDataForTableWalle("Wallecubes", User.getID());
            }

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
                Tableview.setItems(dataForTable.filtered(Wallecube -> Wallecube.getWID() == Integer.parseInt(newValue)));
            }
        });



    }

    @FXML
    protected void goToCreateWalleCube()
    {
        ViewSwitch.switchView(View.WalleCube);
    }
    @FXML
    protected void showRemoveWalleCube()
    {
        removeButton.setVisible(true);
        removeField.setVisible(true);
    }
    @FXML
    protected void removeWalleCube() throws SQLException, IOException {
        if(removeField.getText().equals(""))
        {
            statusText.setText("Please enter a WID");
        }
        else
        {
            switch (User.getUsertype())
            {
                case "admin":
                    Admin admin = new Admin(User.getID(), User.getName(), User.getPassword());
                    statusText.setText(admin.removeWalleCube(Integer.parseInt(removeField.getText())));
                    refresh();
                    break;

                case "centercoop":
                    CenterCoop centerCoop = new CenterCoop();
                    statusText.setText(centerCoop.removeWalleCube(Integer.parseInt(removeField.getText())));
                    refresh();
                    break;
            }
        }
    }

    @FXML
    protected void refresh() throws IOException, SQLException {
        searchField.clear();
        Tableview.getItems().clear();

        switch (User.getUsertype())
        {
            case "admin":
                dataForTable = DBUtil.getAllWalleCubes();
                Tableview.setItems(dataForTable);
                break;
            case "centercoop":
                Tableview.setItems(DBUtil.getDataForTableWalle("Wallecubes", User.getID()));
                break;
        }



    }

    @FXML
    protected void goBack() throws IOException{

        switch(User.getUsertype())
        {
            case "centercoop":
                ViewSwitch.switchView(View.LoggedInCenterCoop);
                break;
            case "admin":
                ViewSwitch.switchView(View.LoggedInAdmin);
                break;
        }

    }

}
