package com.example.app;

import com.example.app.TableStructure.DBUtil;
import com.example.app.View.View;
import com.example.app.View.ViewSwitch;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;


public class SignUpController {


    @FXML
    private Button LoginButton;

    @FXML
    private TextField textField;

   @FXML
   private PasswordField pasField;


   @FXML
    protected void Loggin() throws IOException, SQLException {
       //DBUtil.insertBigbag(3,1,"Type A",1,"TF2_Spy");
       ViewSwitch.switchView(View.LoggedIn);
   }
}
