package com.example.app.controllers;

import com.example.app.TableStructure.BigBag;
import com.example.app.TableStructure.DBUtil;
import com.example.app.TableStructure.HashTable;
import com.example.app.TableStructure.Kooperation;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;

public class ChangeProcessController {

    @FXML
    private ChoiceBox<String> changeProcessChoicebox;



    public void initialize(){
        changeProcessChoicebox.getItems().addAll(HashTable.getProcesNames());
    }

    //This is a function to print the qr code.
    @FXML
    public void printQR() throws IOException{

    }
    @FXML
    public void changeProcess() throws IOException{

        Kooperation kooperation = new Kooperation();
        kooperation.changeProcess(changeProcessChoicebox.getValue());

    }





}
