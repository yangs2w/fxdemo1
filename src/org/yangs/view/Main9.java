package org.yangs.view;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;


public class Main9 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Group group= new Group();

        Scene scene = new Scene(group);


        KeyCombination kcb = new KeyCodeCombination(KeyCode.C, KeyCombination.ALT_DOWN ,KeyCombination.SHORTCUT_DOWN);
        KeyCombination shiftF6 = new KeyCodeCombination(KeyCode.F6, KeyCombination.SHIFT_DOWN);
        scene.getAccelerators().put(kcb, new Runnable() {
            @Override
            public void run() {
                System.out.println("ALT + CTRL + C");
            }
        });

        scene.getAccelerators().put(shiftF6, new Runnable() {
            @Override
            public void run() {
                System.out.println("SHIFT + F6");
            }
        });



        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX");
        primaryStage.setWidth(800);
        primaryStage.setHeight(600);
        primaryStage.show();
    }

}
