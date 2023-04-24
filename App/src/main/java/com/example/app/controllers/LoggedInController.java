package com.example.app.controllers;

import com.example.app.View.View;
import com.example.app.View.ViewSwitch;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;

import java.io.IOException;

public class LoggedInController {
    @FXML
    private Button Button1;

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;
    @FXML
    private BarChart<String, Integer> chart;
    @FXML
    private Label Label1;

    public LoggedInController(){

    }

    public void setName(){
        Button2.setText("hi");
    }

    @FXML
    protected void goToCreateBigBag() throws IOException{
        ViewSwitch.switchView(View.BigBag);
    }

    @FXML
    protected void goToCreateWalleCube() throws IOException{
        ViewSwitch.switchView(View.WalleCube);
    }

    @FXML
    protected void goToChangeProces() throws IOException{
        ViewSwitch.switchView(View.ChangeProcess);
    }


    @FXML
    protected void showChart() throws IOException {
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("test");
        series1.getData().add(new XYChart.Data<>("Test1", 17));
        series1.getData().add(new XYChart.Data<>("Test2", 10));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("test");
        series2.getData().add(new XYChart.Data<>("Test1", 130));
        series2.getData().add(new XYChart.Data<>("Test2", 75));

        chart.getData().setAll(series1, series2);
    }

    public void initialize(){
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("test");
        series1.getData().add(new XYChart.Data<>("Test1", 17));
        series1.getData().add(new XYChart.Data<>("Test2", 10));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("test");
        series2.getData().add(new XYChart.Data<>("Test1", 130));
        series2.getData().add(new XYChart.Data<>("Test2", 75));

        chart.getData().setAll(series1, series2);
    }


}
