package TowerDefense.thegame;

import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.IOException;

public class ClosingScreen {
    private Image closingScreenImage;
    private Image gameClearImage;

    private boolean isInClosingScreen;

    public ClosingScreen() throws IOException {
        this.closingScreenImage = new Image(new FileInputStream("resources/endgame/closingScreen.png"));
        this.gameClearImage = new Image(new FileInputStream("resources/endgame/gameClear.png"));
        this.isInClosingScreen = false;
    }

    public Image getClosingScreenImage() { return closingScreenImage; }
    public Image getGameClearImage() { return gameClearImage; }

    public boolean isInClosingScreen() { return isInClosingScreen; }

    public void setInClosingScreen(boolean inClosingScreen) { isInClosingScreen = inClosingScreen; }
}
