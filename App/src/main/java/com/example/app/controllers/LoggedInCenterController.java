package com.example.app.controllers;

import com.example.app.TableStructure.BigBag;
import com.example.app.TableStructure.DBUtil;
import com.example.app.TableStructure.User;
import com.example.app.View.View;
import com.example.app.View.ViewSwitch;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;

public class LoggedInCenterController {



        @FXML
        protected void goToCreateBigBag() throws IOException {
            ViewSwitch.switchView(View.BigBag);
        }

        @FXML
        protected void goToCreateWalleCube() throws IOException{
            ViewSwitch.switchView(View.WalleCube);
        }
        @FXML
        protected void goToUserManagement() throws IOException
        {
            ViewSwitch.switchView(View.USERMANAGEMENT);
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
        protected void logOut()
        {
            ViewSwitch.switchView(View.LOGIN);
        }

        public void initialize(){

        }

        @FXML
        public void goToWalleOverview() throws IOException{
            ViewSwitch.switchView(View.WalleCubeOverview);
        }

}


