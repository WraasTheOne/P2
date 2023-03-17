package com.example.app;

import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.fxml.FXML;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Controller {

    @FXML

    private Circle myCircle;
    private double x;
    private double y;

    Text text = new Text();


    public void up(ActionEvent e)
    {
        myCircle.setCenterY(y = y - 5);
        text.setText("UP");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Verdana", 50));
        text.setFill(Color.WHITE);
    }
    public void down(ActionEvent e)
    {
        myCircle.setCenterY(y = y + 5);
        text.setText("DOWN");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Verdana", 50));
        text.setFill(Color.WHITE);
    }
    public void left(ActionEvent e)
    {
        myCircle.setCenterX(x = x - 5);
        text.setText("LEFT");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Verdana", 50));
        text.setFill(Color.WHITE);
    }
    public void right(ActionEvent e)
    {
        myCircle.setCenterX(x = x + 5);
        text.setText("RIGHT");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Verdana", 50));
        text.setFill(Color.WHITE);
    }

}
