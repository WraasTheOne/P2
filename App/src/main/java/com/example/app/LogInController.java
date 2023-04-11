package com.example.app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.sql.*;

import java.io.IOException;
import java.sql.SQLException;

public class LogInController {

    @FXML
    private Button loginButton;
    @FXML
    private TextField usernameField;
    @FXML
    private Label statusText;
    @FXML
    private PasswordField passwordField;
    private DBUtil db = DBUtil.getInstance();
    private String tableDecide;

   @FXML
    protected void Loggin() throws IOException
   {
        //KIG PÅ IGEN
       switch(usernameField.getText()) // SPØRG OM USERNAMES
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
           Connection myConn = db.connectToDB();

           /*ResultSet set = db.sendStatement("SELECT Name, Password FROM p2.admin WHERE name = '" + usernameField.getText() +
                                            "' AND password = '" + passwordField.getText()
                                            + "' Union "
                                            + "SELECT Name, Password FROM p2.centercoop WHERE name = '" + usernameField.getText() +
                                            "' AND password = '" + passwordField.getText()
                                            + "' Union "
                                            + "SELECT Name, Password FROM p2.kooperation WHERE name = '" + usernameField.getText() +
                                            "' AND password = '" + passwordField.getText() + "'", myConn);

            System.out.println("SELECT Name, Password FROM p2.admin WHERE name = '" + usernameField.getText() +
                    "' AND password = '" + passwordField.getText()
                    + "' Union "
                    + "SELECT Name, Password FROM p2.centercoop WHERE name = '" + usernameField.getText() +
                    "' AND password = '" + passwordField.getText()
                    + "' Union "
                    + "SELECT Name, Password FROM p2.kooperation WHERE name = '" + usernameField.getText() +
                    "' AND password = '" + passwordField.getText() + "'");*/


           ResultSet set = db.sendStatement("SELECT Name, password FROM p2." + tableDecide + " " +
                                            "WHERE Name = '" + usernameField.getText() + "' " + "AND " +
                                            "password = '" + passwordField.getText() + "'", myConn);

           System.out.println("SELECT Name, password FROM p2." + tableDecide + " " +
                              "WHERE Name = '" + usernameField.getText() + "' " + "AND " +
                              "password = '" + passwordField.getText() + "'");

           set.next();

           System.out.println(set.getString("Name"));
           System.out.println(set.getString("password"));

           if(set.getString("Name").equals(usernameField.getText()) &&
                   set.getString("password").equals(passwordField.getText())
                   && !tableDecide.equals("admin"))
           {
               statusText.setText("Logging in: Please wait");
               db.setUsername(set.getString("Name"));
               myConn.close();
               ViewSwitch.switchView(View.MAINPAGE);
           }
           else if(set.getString("Name").equals(usernameField.getText()) &&
                   set.getString("password").equals(passwordField.getText())
                   && tableDecide.equals("admin"))
           {
               statusText.setText("Logging in: Please wait");
               db.setUsername(set.getString("Name"));
               myConn.close();
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
