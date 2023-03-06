package com.example.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class ViewSwitch {
    private static Scene scene;

    public static void setScene(Scene scene) {
        ViewSwitch.scene = scene;
    }

    public static void switchView(View view) {
        Parent root = null;
        try {
            root = FXMLLoader.load(ViewSwitch.class.getResource(view.getFileName()));
            scene.setRoot(root);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
