package com.example.app.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.app.TableStructure.*;
import com.example.app.View.View;
import com.example.app.View.ViewSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class BigBagController{
    @FXML
    public ChoiceBox<String> processChoicebox;
    @FXML
    public TextField typeField;
    @FXML
    private ChoiceBox<String> locationChoicebox;



    private final String[] locations ={"Location 1","Location 2","Location 3"};

    private final String[] processes = {"proces 1","proces 2"};


    public void initialize(){
        locationChoicebox.getItems().addAll(HashTable.getLocationNames());
        processChoicebox.getItems().addAll(HashTable.getProcesNames());
        BigBags bb = new BigBags();
        bb.

    }


    @FXML
    public void back() throws IOException{
        ViewSwitch.switchView(View.LoggedIn);
    }


    @FXML
    public void createBigbag() throws IOException{
        System.out.println(processChoicebox.getValue());
        int processId = HashTable.getProcessHashValue(processChoicebox.getValue());
        int locationId = HashTable.getLocationHashValue(locationChoicebox.getValue());

        System.out.println(processId + " " + locationId);
        DBUtil.insertBigbag(User.getID(),processId,typeField.getText(),locationId,User.getName());



    }

}
