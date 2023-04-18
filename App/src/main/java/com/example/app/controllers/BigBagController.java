package com.example.app.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.app.TableStructure.Admin;
import com.example.app.TableStructure.DBUtil;
import com.example.app.TableStructure.HashTable;
import com.example.app.TableStructure.User;
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
        locationChoicebox.getItems().addAll(locations);
        processChoicebox.getItems().addAll(processes);
    }


    @FXML
    public void back() throws IOException{
        ViewSwitch.switchView(View.LoggedIn);
    }


    @FXML
    public void createBigbag() throws IOException{
        System.out.println(processChoicebox.getValue());
        HashTable.makeHashTables();
        int processId = HashTable.getProcessHashValue(processChoicebox.getValue());
        int locationId = HashTable.getLocationHashValue(locationChoicebox.getValue());

        System.out.println(processId + " " + locationId);
        DBUtil.insertBigbag(User.getID(),processId,typeField.getText(),locationId,User.getName());



    }

}
