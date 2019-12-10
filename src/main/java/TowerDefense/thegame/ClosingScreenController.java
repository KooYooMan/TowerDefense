package TowerDefense.thegame;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ClosingScreenController extends AnimationTimer {
    private final GraphicsContext graphicsContext;
    private final Pane pane;
    private final ClosingScreen closingScreen;

    private boolean lose;

    public ClosingScreenController(GraphicsContext graphicsContext, Pane pane) throws IOException {
        this.graphicsContext = graphicsContext;
        this.pane = pane;
        this.closingScreen = new ClosingScreen();
        this.lose = false;
    }

    @Override
    public void handle(long l) {
        if (closingScreen.isInClosingScreen()) {
            if (lose) {
                graphicsContext.drawImage(closingScreen.getClosingScreenImage(), 0, 0,
                        Config.SCREEN_WIDTH + Config.SHOP_WIDTH, Config.SCREEN_HEIGHT
                );
            } else {
                graphicsContext.drawImage(closingScreen.getGameClearImage(), 0, 0,
                        Config.SCREEN_WIDTH + Config.SHOP_WIDTH, Config.SCREEN_HEIGHT
                );
            }
        }
    }

    public void setLose(boolean lose) { this.lose = lose; }

    public Pane getPane() { return pane; }
    public ClosingScreen getClosingScreen() { return closingScreen; }
}
