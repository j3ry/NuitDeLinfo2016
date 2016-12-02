package com.bubbletext.ai.ui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;

/**
 * Created by charles on 12/2/16.
 */
public class Main extends Application{

    public static void main(String args[]){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("BubbleText");
        primaryStage.setHeight(500);
        primaryStage.setWidth(700);

        Button button = new Button("Send");
        TextField tf = new TextField();
        tf.setLayoutX(60);
        tf.setPrefWidth(630);
        TextArea ta = new TextArea();
        ta.setLocation(0, 30);

        Group g = new Group();
        g.getChildren().addAll(button, tf);

        Scene scene = new Scene(g);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
