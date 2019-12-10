package TowerDefense.thegame;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class StartScreenController extends AnimationTimer {
    private GraphicsContext startScreenGraphicsContext;
    private Pane pane;
    private StartScreen startScreen;

    public StartScreenController(GraphicsContext startScreenGraphicsContext, Pane pane) throws IOException {
        this.startScreenGraphicsContext = startScreenGraphicsContext;
        this.pane = pane;
        this.startScreen = new StartScreen(pane);
    }

    @Override
    public void handle(long l) {
        if (startScreen.isInStartScreen()) {
            startScreenGraphicsContext.drawImage(startScreen.getStartScreenImage(), 0, 0,
                    Config.SCREEN_WIDTH + Config.SHOP_WIDTH, Config.SCREEN_HEIGHT
            );

            startScreenGraphicsContext.drawImage(startScreen.getLogo(), 250, 25, 500, 250);

            startScreen.handleEvent();
        }
    }

    public StartScreen getStartScreen() { return startScreen; }
    public Pane getPane() { return pane; }

    public void reset() {
        startScreen.reset();
    }

    public void start() { super.start(); }
}
