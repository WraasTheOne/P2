package com.example.app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MakeCodeController {


    @FXML
    private Text myText = new Text();
    @FXML
    protected void onStatsButtonclick(ActionEvent event){
        myText.setText("Statistics");
    }

    @FXML
    protected void onProducedButtonClick(){
        myText.setText("Produced");
    }

    @FXML
    protected void onScanButtonClick(){
        myText.setText("Scan");
    }

    @FXML
    protected void onReadyButtonClick(){
        myText.setText("ready");
    }

    @FXML
    protected void onProfileButtonClick(){
        myText.setText("profile");
    }

}
