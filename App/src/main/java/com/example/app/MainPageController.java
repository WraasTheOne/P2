package com.example.app;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainPageController implements Initializable{
    @FXML
    private Button Button1;
    @FXML
    private Button Button2;
    @FXML
    private BarChart<String, Integer> chart;
    @FXML
    private Label Label1;
    @FXML
    private Label usernameDisplay;

    private DBUtil db = DBUtil.getInstance();

    public MainPageController(){
    }

    public void setName(){
        Button2.setText("hi");
    }

    @FXML
    protected void buttonCliked() throws IOException {
        System.out.println("HEJ");
        //Label1.setText("Welcome to JavaFX Application!");
        //Button1.setText("hej");
        //Button2.setText("ad");
        ViewSwitch.switchView(View.HELLO);
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

    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        usernameDisplay.setText(db.getUsername());

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
