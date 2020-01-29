package org.yangs.view;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main4 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("运行Start方法");
        primaryStage.show();
    }

    @Override
    public void init() throws Exception {
        System.out.println("开始启动Main4方法");
        super.init();
    }

    @Override
    public void stop() throws Exception {
        System.out.println("准备结束Main4方法");
        super.stop();
    }
}
