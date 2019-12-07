package TowerDefense.thegame;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class StartScreenController extends AnimationTimer {
    private GraphicsContext startScreenGraphicsContext;
    private Pane pane;
    private StartScreen startScreen;
    private MapPickerScreen mapPickerScreen;

    public StartScreenController(GraphicsContext startScreenGraphicsContext, Pane pane) throws IOException {
        this.startScreenGraphicsContext = startScreenGraphicsContext;
        this.pane = pane;
        //this.mapPickerScreen = new MapPickerScreen(pane);
        this.startScreen = new StartScreen(pane);
    }

    @Override
    public void handle(long l) {
        if (startScreen.isInStartScreen()) {
            startScreenGraphicsContext.drawImage(startScreen.getStartScreenImage(), 0, 0,
                    Config.SCREEN_WIDTH + Config.SHOP_WIDTH, Config.SCREEN_HEIGHT);
            startScreen.handleEvent();

            if (startScreen.isInMapPickingScreen()) {
                startScreen.removeAll(pane);
            }
        }
    }

    public StartScreen getStartScreen() { return startScreen; }
    public Pane getPane() { return pane; }

    public void start() { super.start(); }
}
