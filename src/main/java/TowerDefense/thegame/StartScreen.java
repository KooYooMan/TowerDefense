package TowerDefense.thegame;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.IOException;

public class StartScreen {
    private Image startScreenImage;
    private VBox vBox;
    private Button startButton;
    private Button loadButton;
    private Button quitButton;
    private boolean isInStartScreen;
    private boolean isInMapPickingScreen;
    private boolean isQuit;

    public StartScreen(Pane pane) throws IOException {
        this.startScreenImage = new Image(new FileInputStream("target/classes/startScreen/StartScreen.jpg"));

        this.vBox = new VBox(8);

        this.startButton = new Button("Start");
        this.startButton.setFont(Font.font(20));
        this.startButton.setPrefSize(420, 69);

        this.loadButton = new Button("Load");
        this.loadButton.setFont(Font.font(20));
        this.loadButton.setPrefSize(420, 69);

        this.quitButton = new Button("Quit");
        this.quitButton.setFont(Font.font(20));
        this.quitButton.setPrefSize(420, 69);

        this.vBox.getChildren().addAll(startButton, loadButton, quitButton);

        this.vBox.setAlignment(Pos.CENTER);

        pane.getChildren().add(vBox);

        this.isInStartScreen = true;
        this.isInMapPickingScreen = false;
        this.isQuit = false;
    }

    public Image getStartScreenImage() { return startScreenImage; }

    public boolean isInStartScreen() { return isInStartScreen; }
    public boolean isInMapPickingScreen() { return isInMapPickingScreen; }
    public boolean isQuit() { return isQuit; }

    public void setInStartScreen(boolean inStartScreen) { isInStartScreen = inStartScreen; }

    public void handleEvent() {
        startButton.setOnMousePressed(mouseEvent -> isInStartScreen = false);
//        loadButton.setOnMousePressed(mouseEvent -> {
//            //isInStartScreen = false;
//            isInMapPickingScreen = true;
//        });
        quitButton.setOnMousePressed(mouseEvent -> isQuit = true);
    }

    public void removeAll(Pane pane) {
        pane.getChildren().removeAll(vBox);
    }
}

class MapPickerScreen {
    private ImageView map1;
    private ImageView map2;
    private Button map1PickingButton;
    private Button map2PickingButton;
    private HBox hBox;
    private Pane pane;

    public MapPickerScreen(Pane pane) throws IOException {
        this.pane = pane;

        this.hBox = new HBox(200);

        this.map1 = new ImageView(new Image(
                new FileInputStream("resources/map/image/Map1.png")
        ));
        this.map1.setFitWidth(200);
        this.map1.setFitHeight(200);
        this.map1PickingButton = new Button("", map1);
        this.map1PickingButton.setMaxSize(200, 200);

        this.map2 = new ImageView(new Image(
                new FileInputStream("resources/map/image/Map2.png")
        ));
        this.map2.setFitWidth(200);
        this.map2.setFitHeight(200);
        this.map2PickingButton = new Button("", map2);
        this.map2PickingButton.setMaxSize(200, 200);

        this.hBox.getChildren().addAll(map1PickingButton, map2PickingButton);
        this.hBox.setAlignment(Pos.CENTER);

        pane.getChildren().add(hBox);
    }
}
