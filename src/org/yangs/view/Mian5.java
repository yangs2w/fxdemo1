package org.yangs.view;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Mian5 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setTitle("JavaFX");
        primaryStage.show();

    }
}
