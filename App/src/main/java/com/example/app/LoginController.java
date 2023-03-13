package com.example.app;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import java.io.IOException;

public class LoginController
{
    @FXML
    private TextField textField;
    @FXML
    private Label status;
    @FXML
    private PasswordField passwordField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public static String currentUsername;
    public static String currentPassword;

    public void LogIn(ActionEvent event) throws IOException
    {

        if(textField.getText().equals(currentUsername) && passwordField.getText().equals(currentPassword))
        {
            System.out.println("Success!!");

            root = FXMLLoader.load(getClass().getResource("tutorialGUI.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else
        {
            status.setText("Incorrect password or username");
            status.setTextFill(Color.RED);
        }
    }
}
