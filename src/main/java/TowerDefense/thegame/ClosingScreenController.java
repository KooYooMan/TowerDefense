package TowerDefense.thegame;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ClosingScreenController extends AnimationTimer {
    private final GraphicsContext graphicsContext;
    private final Pane pane;
    private final ClosingScreen closingScreen;

    private boolean isClickedOnPane;

    public ClosingScreenController(GraphicsContext graphicsContext, Pane pane) throws IOException {
        this.graphicsContext = graphicsContext;
        this.pane = pane;
        this.closingScreen = new ClosingScreen();
        this.isClickedOnPane = false;
    }

    @Override
    public void handle(long l) {
        if (closingScreen.isInClosingScreen()) {
            graphicsContext.drawImage(closingScreen.getClosingScreenImage(), 0, 0,
                    Config.SCREEN_WIDTH + Config.SHOP_WIDTH, Config.SCREEN_HEIGHT
            );

            pane.setOnMousePressed(mouseEvent -> isClickedOnPane = true);
        }
    }

    public Pane getPane() { return pane; }
    public ClosingScreen getClosingScreen() { return closingScreen; }
    public boolean isClickedOnPane() { return isClickedOnPane; }
}
