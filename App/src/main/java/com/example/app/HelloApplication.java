package com.example.app;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.Chart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.awt.*;
import java.io.IOException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {


        Scene scene = new Scene(new Pane(), java.awt.Toolkit.getDefaultToolkit().getScreenSize().width, java.awt.Toolkit.getDefaultToolkit().getScreenSize().height);

        ViewSwitch.setScene(scene);
        ViewSwitch.switchView(View.LOGIN);

        stage.setScene(scene);
        stage.setTitle("P2 - app");
        stage.show();


    }

    public static void main(String[] args) {
        launch();
    }

}