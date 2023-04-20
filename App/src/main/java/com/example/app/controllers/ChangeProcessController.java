package com.example.app.controllers;

import com.example.app.TableStructure.HashTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ChangeProcessController {

    @FXML
    public ChoiceBox<String> changeProcessChoicebox;



    public void initialize(){
        changeProcessChoicebox.getItems().addAll(HashTable.getProcesNames());
    }

    //This is a function to print the qr code.
    @FXML
    public void printQR() throws IOException{

    }

    @FXML
    public void changeProcess(){
        int newProcess = HashTable.getProcessHashValue(changeProcessChoicebox.getValue());

    }



}
