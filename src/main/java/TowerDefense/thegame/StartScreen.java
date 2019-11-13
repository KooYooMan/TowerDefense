package TowerDefense.thegame;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.IOException;

public class StartScreen {
    private Image startScreenImage;
    private Button startButton;
    private boolean isInStartScreen;

    public StartScreen(Pane pane) throws IOException {
        this.startScreenImage = new Image(new FileInputStream("target/classes/startScreen/StartScreen.jpg"));

        this.startButton = new Button("Start");
        this.startButton.setFont(Font.font(20));
        this.startButton.setPrefSize(420, 69);

        pane.getChildren().add(startButton);

        this.isInStartScreen = true;
    }

    public Image getStartScreenImage() { return startScreenImage; }
    public boolean isInStartScreen() { return isInStartScreen; }

    public void setInStartScreen(boolean inStartScreen) { isInStartScreen = inStartScreen; }

    public void handleEvent() {
        startButton.setOnMousePressed(mouseEvent -> isInStartScreen = false);
    }
}
