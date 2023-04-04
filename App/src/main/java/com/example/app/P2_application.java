package com.example.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import java.io.IOException;
import java.util.Scanner;

public class P2_application extends Application
{
    int numOfAccounts = 0;
    Scanner input = new Scanner(System.in);

    @Override
    public void start(Stage stage) throws IOException
    {
        System.out.println("Please enter a Username");
        LoginController.currentUsername = input.next();
        System.out.println("Please enter a Password");
        LoginController.currentPassword = input.next();

        Image icon = new Image("C:\\Users\\yamoc\\IdeaProjects\\P2\\App\\src\\ikon.png");

        Parent root = FXMLLoader.load(getClass().getResource("login_sycene.fxml"));
        Scene scene = new Scene(root);
        stage.getIcons().add(icon);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}