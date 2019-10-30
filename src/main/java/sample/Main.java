package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.FileInputStream;

public class Main extends Application {
    final double SCENE_WIDTH = 1000;
    final double SCENE_HEIGHT = 700;

    final double IMAGE_VIEW_HEIGHT = 50;
    final double IMAGE_VIEW_WIDTH = 35;

    double dx = 5;
    double dy = 5;

    double posX = 0;
    double posY = 0;

    @Override
    public void start(Stage stage) throws Exception {
        Image image = new Image(new FileInputStream("src/133.png"));
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);

        imageView.setFitWidth(IMAGE_VIEW_WIDTH);
        imageView.setFitWidth(IMAGE_VIEW_HEIGHT);

        imageView.setX(posX);
        imageView.setY(posY);

        Group root = new Group(imageView);

        Scene scene = new Scene(root, 1000, 700);
        stage.setTitle("Loading an image");
        stage.setScene(scene);
        stage.show();
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (posX + dx > 0 && posX + dx + IMAGE_VIEW_WIDTH < SCENE_WIDTH && posY + dy > 0 && posY + dy + IMAGE_VIEW_HEIGHT < SCENE_HEIGHT) {
                    posX += dx;
                    posY += dy;
                } else {
                    dx = -dx;
                    dy = -dy;
                }
                imageView.setX(posX);
                imageView.setY(posY);
            }
        }.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
