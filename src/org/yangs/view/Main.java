package org.yangs.view;

import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    private ImageView iv_blur = null;

    @Override
    public void start(Stage primaryStage) {

        // 设置窗口没有标题栏
        primaryStage.initStyle(StageStyle.UNDECORATED);

        // 两个操作按钮，一个进入，一个退出
        Button in = new Button("  IN  ");
        Button out = new Button("  OUT  ");

        // 窗口背景图片
        ImageView iv = new ImageView("images/image.jpg");
        // 用于承载图片和上层组件的面板
        AnchorPane pane = new AnchorPane();
        AnchorPane.setLeftAnchor(in, 180.0);
        AnchorPane.setLeftAnchor(out, 300.0);
        pane.getChildren().addAll(iv, in, out);
        // 准备虚化的节点NODE
        Node node = getView(primaryStage);

        // 根节点root,就是最接近Screen的节点
        AnchorPane root = new AnchorPane();
        root.getChildren().addAll(pane, node);


        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setWidth(800);
        primaryStage.setHeight(500);
        primaryStage.show();

        // 绑定iv的大小随窗口一起变化
        iv.fitWidthProperty().bind(primaryStage.widthProperty());
        iv.fitHeightProperty().bind(primaryStage.heightProperty());

        // 为节点创建动态动画
        TranslateTransition tt = new TranslateTransition(Duration.seconds(1), node);
        tt.setInterpolator(Interpolator.EASE_OUT);

        /*
        为两个按钮创建点击事件
         */
        in.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tt.setFromX(-200);
                tt.setToX(0);
                tt.play();

            }
        });
        out.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tt.setFromX(0);
                tt.setToX(-200);
                tt.play();
            }
        });

        // 监听node的X数值的变化
        node.translateXProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                // node不断变化的X值，也就是Width
                int w = 200 - (-newValue.intValue());
                int h = (int) root.getHeight();
                if (w > 0) {
                    WritableImage wi = new WritableImage(w, h);
                    // 从pane中截图像像素
                    pane.snapshot(new SnapshotParameters(), wi);
                    iv_blur.setImage(wi);
                }
            }
        });


    }

    /**
     *
     * @param stage
     * @return
     */
    private Node getView(Stage stage) {

        StackPane sp = new StackPane();

        // 阴影部分  --- 开始
        DropShadow ds = new DropShadow();
        ds.setRadius(5);
        ds.setColor(Color.valueOf("#a3a3a399"));
        ds.setOffsetX(1);
        sp.setEffect(ds);
        // 阴影部分 --- 结束

        // 第一层视图 ------------------------------------
        AnchorPane ap = new AnchorPane();
        iv_blur = new ImageView();
        iv_blur.setEffect(new GaussianBlur(30));
        AnchorPane.setRightAnchor(iv_blur, 0.0);
        ap.getChildren().add(iv_blur);
        // 第二层视图 ------------------------------------
        VBox vBox = new VBox(20);
        vBox.setStyle("-fx-background-color: #ffffff45");
        vBox.setPrefWidth(200);
        vBox.setBorder(new Border(new BorderStroke(Color.valueOf("#45454555"), BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        for (int i = 0; i < 5; i++) {
            vBox.getChildren().add(new Text("hello javafx " + i));
        }

        sp.getChildren().addAll(ap, vBox);
        sp.setTranslateX(-200);

        // 绑定高度和state一致
        vBox.prefHeightProperty().bind(stage.heightProperty());

        return sp;
    }

}
