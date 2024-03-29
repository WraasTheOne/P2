package com.example.app.View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


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
