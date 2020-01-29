package org.yangs.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main7 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Group group = new Group();

        Button button = new Button();
        button.setText("这是一个按钮");
        button.setLayoutX(280);
        button.setLayoutY(180);
        button.setPrefWidth(200);
        button.setPrefHeight(150);
        button.setFont(Font.font("sans-serif", 18));
        button.setTextFill(Paint.valueOf("#1C86EE"));

        initButtonStyle(button);

        button.setOnMouseEntered(event -> {
            enterButtonStyle(button);
        });

        button.setOnMouseExited(event -> {
            initButtonStyle(button);
        });






        group.getChildren().addAll(button);

        Scene scene = new Scene(group);

        primaryStage.setScene(scene);

        primaryStage.setTitle("JavaFX");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.show();
    }


    private void enterButtonStyle(Button button) {
        button.setBackground(new Background(new BackgroundFill(Paint.valueOf("#69696916"), new CornerRadii(6), Insets.EMPTY)));
        button.setBorder(new Border(new BorderStroke(Paint.valueOf("#EE2C2C"), BorderStrokeStyle.SOLID, new CornerRadii(6), new BorderWidths(1))));
    }

    private void initButtonStyle(Button button) {
        button.setBackground(new Background(new BackgroundFill(Paint.valueOf("#458B7400"), new CornerRadii(6), Insets.EMPTY)));
        button.setBorder(new Border(new BorderStroke(Paint.valueOf("#454545"), BorderStrokeStyle.SOLID, new CornerRadii(6), new BorderWidths(1))));
    }
}
