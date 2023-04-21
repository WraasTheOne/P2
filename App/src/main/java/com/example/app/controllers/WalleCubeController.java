package com.example.app.controllers;

import com.example.app.TableStructure.CenterCoop;
import com.example.app.TableStructure.HashTable;
import com.example.app.TableStructure.WalleCube;
import com.example.app.View.View;
import com.example.app.View.ViewSwitch;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

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
    public TextArea WalleCubeTextArea;


    public void initialize(){
        WalleCubeTypeChoicebox.getItems().addAll(HashTable.getMaterialType());
    }

    @FXML
    protected void back() throws IOException {
        ViewSwitch.switchView(View.LoggedIn);
    }


    @FXML
    protected void createWalleCube() throws IOException{
        CenterCoop.createBigbag(WalleCubeTypeChoicebox.getValue(),WalleCubeTextField.getText());

    }
}
