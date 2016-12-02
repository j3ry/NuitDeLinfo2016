package com.bubbletext.ai.ui;

import ai.api.AIServiceException;
import com.bubbletext.ai.AI;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

/**
 * Created by charles on 12/2/16.
 */
public class Main extends Application{
    public static final String TOKEN = "5e854aa33c104c7e856ca03ae4e0ade0";
    private TextArea ta;
    private TextField tf;
    private AI ai;
    private Button button;

    public static void main(String args[]){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        ai = new AI(TOKEN);

        primaryStage.setTitle("BubbleText");
        primaryStage.setHeight(500);
        primaryStage.setWidth(700);

        tf = new TextField();
        tf.setLayoutX(60);
        tf.setPrefWidth(630);
        tf.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER)
                this.send();
        });

        button = new Button("Send");
        ta = new TextArea();
        ta.setLayoutY(30);
        ta.setWrapText(true);
        ta.setPrefWidth(700);
        ta.setPrefHeight(470);
        ta.setEditable(false);


        button.setOnMouseClicked(event -> this.send());

        Group g = new Group();
        g.getChildren().addAll(tf, button, ta);

        Scene scene = new Scene(g);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public void send(){
        ta.setText(ta.getText() + "Vous: " + tf.getText() + "\n");
        try {
            ta.setText(ta.getText() + "BubbleText: " + ai.sendMessage(tf.getText()));
        } catch (AIServiceException e) {
            e.printStackTrace();
        }
        tf.setText("");
    }
}
