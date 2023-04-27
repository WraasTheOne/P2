package com.example.app.controllers;

import com.example.app.TableStructure.BigBag;
import com.example.app.TableStructure.DBUtil;
import com.example.app.TableStructure.HashTable;
import com.example.app.TableStructure.Kooperation;
import com.example.app.View.View;
import com.example.app.View.ViewSwitch;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.io.IOException;

public class ChangeProcessController {

    public static BigBag bigBag;

    @FXML
    private ChoiceBox<String> changeProcessChoicebox;

    @FXML
    private ChoiceBox<String> changeLocationChoicebox;

    @FXML
    private ChoiceBox<String> changeMaterialChoicebox;

    public void initialize(){
        changeProcessChoicebox.getItems().addAll(HashTable.getProcesNames());
        changeLocationChoicebox.getItems().addAll(HashTable.getLocationNames());
        changeMaterialChoicebox.getItems().addAll(HashTable.getMaterialType());
    }

    //This is a function to print the qr code.
    @FXML
    public void printQR() throws IOException{

    }
    @FXML
    public void changeProcess() throws IOException{

        Kooperation kooperation = new Kooperation();
        kooperation.changeProcess(changeProcessChoicebox.getValue(),bigBag);

    }

   @FXML
   public void changeLocation() throws IOException{
        Kooperation kooperation = new Kooperation();
        kooperation.changeLocation(changeLocationChoicebox.getValue(),bigBag);
   }

   @FXML
   public void changeMaterial() throws IOException{
        Kooperation kooperation = new Kooperation();
        kooperation.changeMaterial(changeMaterialChoicebox.getValue(),bigBag);

   }

@FXML
    public void back() throws IOException{
    ViewSwitch.switchView(View.BigbagView);
}





}
