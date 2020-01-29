package org.yangs.view;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;

public class Main6 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        URL url = getClass().getClassLoader().getResource("images/pointer1.png");

        String path = url.toExternalForm();

        Button button = new Button("按钮");
        button.setPrefWidth(120);
        button.setPrefHeight(120);
        button.setCursor(Cursor.WAIT);

        Group group = new Group();
        group.getChildren().add(button);

        Scene scene = new Scene(group);

        scene.setCursor(Cursor.cursor(path));

        primaryStage.setScene(scene);

        // 设置stage基本样式
        primaryStage.setTitle("JavaFX");
        primaryStage.setWidth(600);
        primaryStage.setHeight(450);
        primaryStage.show();
    }
}
