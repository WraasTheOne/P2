package com.example.app.controllers;

import com.example.app.TableStructure.BigBag;
import com.example.app.TableStructure.DBUtil;
import com.example.app.TableStructure.HashTable;
import com.example.app.TableStructure.Kooperation;
import com.example.app.View.View;
import com.example.app.View.ViewSwitch;
import com.example.mobileapp.QrGen;
import com.google.zxing.WriterException;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javafx.embed.swing.SwingFXUtils;
import javafx.stage.Stage;


public class ChangeProcessController {

    public static BigBag bigBag;

    Popup popup = new Popup();


    @FXML
    private ChoiceBox<String> changeProcessChoicebox;

    @FXML
    private ChoiceBox<String> changeLocationChoicebox;

    @FXML
    private ChoiceBox<String> changeMaterialChoicebox;

    @FXML
    private Label currentProcess;

    @FXML
    private Label bigbagID;

    @FXML
    private Label currentLocation;

    @FXML
    private Label currentMaterial;
    Image image;
    ImageView imageView;





    public void initialize() throws UnsupportedEncodingException, WriterException {
        changeProcessChoicebox.getItems().addAll(HashTable.getProcesNames());
        changeLocationChoicebox.getItems().addAll(HashTable.getLocationNames());
        changeMaterialChoicebox.getItems().addAll(HashTable.getMaterialType());
        changeProcessChoicebox.getSelectionModel().select(bigBag.getNUVProcess()-1);
        changeLocationChoicebox.getSelectionModel().select(bigBag.getLocation()-1);
        changeMaterialChoicebox.getSelectionModel().select(bigBag.getType());
        currentProcess.setText("Current Process: " + changeProcessChoicebox.getValue());
        currentLocation.setText("Curren Location: " + changeLocationChoicebox.getValue());
        currentMaterial.setText("Current Material: " + bigBag.getType());
        bigbagID.setText("Current bigbag ID: "+ bigBag.getBID());

        image = SwingFXUtils.toFXImage(QrGen.generateQRcode(Integer.toString(bigBag.getBID())), null);
        imageView = new ImageView(image);
        //popup.getContent().add(imageView);
    }


    //This is a function to print the qr code.
    @FXML
    public void printQR() throws IOException, WriterException {
        BorderPane pane;
        Scene scene;
        Stage stage;

        pane = new BorderPane();
        pane.setCenter(imageView);
        scene = new Scene(pane);

        stage = new Stage();
        stage.setScene(scene);
        stage.setOnCloseRequest(
                e -> {
                    e.consume();
                    stage.close();
                }
        );
        stage.showAndWait();

    }
    @FXML
    public void changeProcess() throws IOException{

        Kooperation kooperation = new Kooperation();
        kooperation.changeProcess(changeProcessChoicebox.getValue(),bigBag);

    }

   @FXML
   public void changeLocation() throws IOException{
        Kooperation kooperation = new Kooperation();
        kooperation.changeLocation(changeLocationChoicebox.getValue(),bigBag);
   }

   @FXML
   public void changeMaterial() throws IOException{
        Kooperation kooperation = new Kooperation();
        kooperation.changeMaterial(changeMaterialChoicebox.getValue(),bigBag);

   }

@FXML
    public void back() throws IOException{
    ViewSwitch.switchView(View.BigbagView);
}





}
