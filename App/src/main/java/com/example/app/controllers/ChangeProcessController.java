package com.example.app.controllers;

import com.example.app.TableStructure.HashTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ChangeProcessController {

    @FXML
    public ChoiceBox<String> changeProcessChoicebox;

   @FXML
    private Button printQR;

    public void initialize(){
        changeProcessChoicebox.getItems().addAll(HashTable.getProcesNames());
    }


}
