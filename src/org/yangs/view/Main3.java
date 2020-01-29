package org.yangs.view;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane root = new AnchorPane();

        Scene scene = new Scene(root);

        Arc arc = new Arc();
        arc.setCenterX(50);
        arc.setCenterY(50);
        arc.setRadiusX(30);
        arc.setRadiusY(30);
        arc.setStartAngle(45);
        arc.setLength(1);
        arc.setType(ArcType.ROUND);

        Button button = new Button("start");

        root.setPrefWidth(300);
        root.setPrefHeight(300);

        root.getChildren().addAll(button, arc);

        primaryStage.setScene(scene);
        primaryStage.show();

        TranslateTransition tt = new TranslateTransition(Duration.seconds(1), arc);
        tt.setInterpolator(Interpolator.EASE_OUT);

        AtomicInteger count = new AtomicInteger(1);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (count.intValue() < 360) {
                    count.addAndGet(1);
                    arc.setLength(count.intValue());
                }else {
                    Thread.interrupted();
                }
            }
        };

        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 0, 10, TimeUnit.MILLISECONDS);


        button.setOnAction(event -> {
            count.addAndGet(10);
            arc.setLength(count.intValue());
        });

    }
}
