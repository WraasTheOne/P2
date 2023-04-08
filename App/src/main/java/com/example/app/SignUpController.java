package com.example.app;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.sql.*;

import java.io.IOException;
import java.sql.SQLException;

public class SignUpController {

    private DBUtil db = new DBUtil();
    private String tableDecide;
    @FXML
    private Button loginButton;

    @FXML
    private TextField usernameField;
    @FXML
    private Label statusText;
   @FXML
   private PasswordField passwordField;

   @FXML
    protected void Loggin() throws IOException
   {

       switch(usernameField.getText())
       {

           case "Admin":
               tableDecide = "admin";
               break;

           case "CenterCoop":
               tableDecide = "centercoop";
               break;

           default:
               tableDecide = "kooperation";
       }

       try
       {
           String currentUser = usernameField.getText();

           ResultSet set = db.sendStatement("SELECT Name, password FROM p2." + tableDecide + " " +
                                            "WHERE Name = '" + currentUser + "' " + "AND " +
                                            "password = '" + passwordField.getText() + "'");

           System.out.println("SELECT Name, password FROM p2." + tableDecide + " " +
                              "WHERE Name = '" + currentUser + "' " + "AND " +
                              "password = '" + passwordField.getText() + "'");

           set.next();

           System.out.println(set.getString("Name"));
           System.out.println(set.getString("password"));

           if(set.getString("Name").equals(usernameField.getText()) && set.getString("password").equals(passwordField.getText())
                   && !tableDecide.equals("admin"))
           {
               statusText.setText("Logging in: Please wait");
               ViewSwitch.switchView(View.MAINPAGE);
           }
           else if(set.getString("Name").equals(usernameField.getText()) && set.getString("password").equals(passwordField.getText())
                   && tableDecide.equals("admin"))
           {
               statusText.setText("Logging in: Please wait");
               ViewSwitch.switchView(View.MAINPAGEADMIN);
           }
       }
       catch (SQLException ex)
       {
           statusText.setTextFill(Color.RED);
           statusText.setText("Incorrect username or password");
       }
   }
}
