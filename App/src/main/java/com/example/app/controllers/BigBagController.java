package com.example.app.controllers;

import java.io.IOException;

import com.example.app.TableStructure.*;
import com.example.app.View.View;
import com.example.app.View.ViewSwitch;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BigBagController{
    @FXML
    public ChoiceBox<String> processChoicebox;
    @FXML
    public ChoiceBox<String> typeChoicebox;

    @FXML
    public TextField userIDField;
    @FXML
    public Label statusText;

    @FXML
    private ChoiceBox<String> locationChoicebox;

    public void initialize(){
        locationChoicebox.getItems().addAll(HashTable.getLocationNames());
        processChoicebox.getItems().addAll(HashTable.getProcesNames());
        typeChoicebox.getItems().addAll(HashTable.getMaterialType());
        BigBag bb = new BigBag();

        if(User.getUsertype().equals("admin"))
        {
            userIDField.setVisible(true);
        }

    }

    @FXML
    public void back() throws IOException{

        switch (User.getUsertype())
        {
            case "admin":
                ViewSwitch.switchView(View.LoggedInAdmin);
                break;
            case "kooperation":
                ViewSwitch.switchView(View.LoggedIn);
                break;
        }

    }

    @FXML
    public void createBigbag() throws IOException{

        Kooperation kooperation = new Kooperation();
        Admin admin = new Admin(User.getID(), User.getName(), User.getPassword());
        String resultText = null;

        System.out.println(processChoicebox.getValue());
        int processId = HashTable.getProcessHashValue(processChoicebox.getValue());
        int locationId = HashTable.getLocationHashValue(locationChoicebox.getValue());

        System.out.println(processId + " " + locationId);

        switch (User.getUsertype())
        {
            case "admin":
                resultText = admin.createBigbag(Integer.parseInt(userIDField.getText()),
                                    processChoicebox.getValue(),
                                    locationChoicebox.getValue(),
                                    typeChoicebox.getValue());
                break;
            case "kooperation":
                resultText = kooperation.createBigbag(User.getID(),
                                        processChoicebox.getValue(),
                                        locationChoicebox.getValue(),
                                        typeChoicebox.getValue());
                break;
        }

        statusText.setText(resultText);

    }

}
