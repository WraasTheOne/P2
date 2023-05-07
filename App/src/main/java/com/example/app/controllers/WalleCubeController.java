package com.example.app.controllers;

import com.example.app.TableStructure.*;
import com.example.app.View.View;
import com.example.app.View.ViewSwitch;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

public class WalleCubeController {

    @FXML
    public ChoiceBox<String> WalleCubeTypeChoicebox;
    @FXML
    public Button WalleCubeBackButton;
    @FXML
    public TextField WalleCubeTextField;
    @FXML
    public Button CreateWalleCubeButton;
    @FXML
    public TextField cidField;

    public void initialize(){
        WalleCubeTypeChoicebox.getItems().addAll(HashTable.getMaterialType());

        if(User.getUsertype().equals("admin"))
        {
            cidField.setVisible(true);
        }
    }

    @FXML
    protected void back() throws IOException {
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

    @FXML
    protected void createWalleCube() throws IOException {

        switch (User.getUsertype())
        {
            case "centercoop":
                CenterCoop centerCoop = new CenterCoop();
                centerCoop.createWalleCube(WalleCubeTypeChoicebox.getValue(),WalleCubeTextField.getText(), User.getID());
                break;
            case "admin":
                Admin admin = new Admin(User.getID(), User.getName(), User.getPassword());
                admin.createWalleCube(WalleCubeTypeChoicebox.getValue(),WalleCubeTextField.getText(),
                                        Integer.parseInt(cidField.getText()));
                break;

        }
    }
}
