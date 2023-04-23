package com.example.app.controllers;

import com.example.app.TableStructure.BigBags;
import com.example.app.TableStructure.DBUtil;
import com.example.app.TableStructure.HashTable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import com.example.app.TableStructure.BigBags;

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
    public void changeProcess(){
        int newProcess = HashTable.getProcessHashValue(changeProcessChoicebox.getValue());
        //DBUtil.setColumnValueInt("bigbags","NUVProces",newProcess, BigBags.getBID(),);
    }



}
