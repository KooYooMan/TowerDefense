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
    private Pane startScreenPane;

    private Image startScreenImage;
    private boolean isInStartScreen;
    private boolean isInWelcomeScreen;
    private boolean isInMapPickingScreen;
    private boolean isQuit;

    private WelcomeScreen welcomeScreen;
    private MapPickingScreen mapPickingScreen;

    public StartScreen(Pane startScreenPane) throws IOException {
        this.startScreenPane = startScreenPane;

        this.startScreenImage = new Image(new FileInputStream("target/classes/startScreen/StartScreen.jpg"));

        this.welcomeScreen = new WelcomeScreen(this);
        this.mapPickingScreen = new MapPickingScreen(this);

        this.startScreenPane.getChildren().add(welcomeScreen.getVBox());

        this.isInStartScreen = true;
        this.isInWelcomeScreen = true;
        this.isInMapPickingScreen = false;
        this.isQuit = false;
    }

    public Image getStartScreenImage() { return startScreenImage; }

    public Pane getStartScreenPane() { return startScreenPane; }

    public boolean isInStartScreen() { return isInStartScreen; }
    public boolean isInWelcomeScreen() { return isInWelcomeScreen; }
    public boolean isInMapPickingScreen() { return isInMapPickingScreen; }
    public boolean isQuit() { return isQuit; }

    public void setInStartScreen(boolean inStartScreen) { isInStartScreen = inStartScreen; }
    public void setInWelcomeScreen(boolean inWelcomeScreen) { isInWelcomeScreen = inWelcomeScreen; }
    public void setInMapPickingScreen(boolean inMapPickingScreen) { isInMapPickingScreen = inMapPickingScreen; }
    public void setQuit(boolean quit) { isQuit = quit; }

    public WelcomeScreen getWelcomeScreen() { return welcomeScreen; }
    public MapPickingScreen getMapPickingScreen() { return mapPickingScreen; }

    public void handleEvent() {
        if (isInWelcomeScreen) {
            welcomeScreen.handleEvent();
        }

        if (isInMapPickingScreen) {
            mapPickingScreen.handleEvent();
        }
    }
}

class WelcomeScreen {
    private VBox vBox;
    private Button startButton;
    private Button loadButton;
    private Button quitButton;

    private StartScreen startScreen;

    public WelcomeScreen(StartScreen startScreen) {
        this.startScreen = startScreen;

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
    }

    public VBox getVBox() { return vBox; }

    public void handleEvent() {
        startButton.setOnMousePressed(mouseEvent -> {
            startScreen.getStartScreenPane().getChildren().remove(vBox);
            startScreen.getStartScreenPane().getChildren().add(startScreen.getMapPickingScreen().getHBox());

            startScreen.setInWelcomeScreen(false);
            startScreen.setInMapPickingScreen(true);
        });

//        loadButton.setOnMousePressed(mouseEvent -> {
//            //isInStartScreen = false;
//            isInMapPickingScreen = true;
//        });

        quitButton.setOnMousePressed(mouseEvent -> startScreen.setQuit(true));
    }
}

class MapPickingScreen {
    private ImageView map1;
    private ImageView map2;
    private Button map1PickingButton;
    private Button map2PickingButton;
    private HBox hBox;

    private boolean pickedMap1;
    private boolean pickedMap2;

    private StartScreen startScreen;

    public MapPickingScreen(StartScreen startScreen) throws IOException {
        this.startScreen = startScreen;

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

        this.pickedMap1 = false;
        this.pickedMap2 = false;
    }

    public HBox getHBox() { return hBox; }

    public void setPickedMap1(boolean pickedMap1) { this.pickedMap1 = pickedMap1; }
    public void setPickedMap2(boolean pickedMap2) { this.pickedMap2 = pickedMap2; }

    public boolean isPickedMap1() { return pickedMap1; }
    public boolean isPickedMap2() { return pickedMap2; }

    public void handleEvent() {
        map1PickingButton.setOnMousePressed(mouseEvent -> {
            pickedMap1 = true;
            pickedMap2 = false;

            startScreen.setInMapPickingScreen(false);
            startScreen.setInStartScreen(false);
        });

        map2PickingButton.setOnMousePressed(mouseEvent -> {
            pickedMap2 = true;
            pickedMap1 = false;

            startScreen.setInMapPickingScreen(false);
            startScreen.setInStartScreen(false);
        });
    }
}
