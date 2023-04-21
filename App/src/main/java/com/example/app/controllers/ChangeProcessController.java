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
    public void changeProcessButton() throws IOException{

        int tidProcess = DBUtil.getsingleValue("bigbags",1);
        int newProcess = HashTable.getProcessHashValue(changeProcessChoicebox.getValue());
        DBUtil.copyColumnValue("bigbags",tidProcess,1);
        DBUtil.updateTimeForBigbag(1);
        BigBags.setBID(1);
        System.out.println(BigBags.getBID());
        BigBags.setNUVProcess(newProcess);
    }

    @FXML
    public void changeProcess(){
        int newProcess = HashTable.getProcessHashValue(changeProcessChoicebox.getValue());
        BigBags.setBID(1);
        BigBags.setNUVProcess(newProcess);
    }



}
