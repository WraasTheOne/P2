package com.example.app.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.app.View.View;
import com.example.app.View.ViewSwitch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class BigBagController{
    @FXML
    private ChoiceBox<String> locationChoicebox;

    private final String[] locations ={"Location 1","Location 2","Location 3"};


    public void initialize(){
        locationChoicebox.getItems().addAll(locations);
    }
    @FXML
    public void getChoiceValue() throws IOException{
        System.out.println(locationChoicebox.getValue());
        System.out.println("hi");

    }

    @FXML
    public void back() throws IOException{
        ViewSwitch.switchView(View.LoggedIn);
    }

}
