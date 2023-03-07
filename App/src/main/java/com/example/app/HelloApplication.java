package com.example.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new Pane(),420,420);

        ViewSwitch.setScene(scene);
        ViewSwitch.switchView(View.LOGIN);
        //stage.setMaximized(true);
        stage.setScene(scene);
        stage.setTitle("SagaLabs-Manager");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void viewSwitch(){

    }
}