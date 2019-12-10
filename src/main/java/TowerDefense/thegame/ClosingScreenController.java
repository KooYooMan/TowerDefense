package TowerDefense.thegame;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.IOException;

public class ClosingScreenController extends AnimationTimer {
    private final GraphicsContext graphicsContext;
    private final Pane pane;
    private final ClosingScreen closingScreen;

    private boolean lose;
    private boolean reset;

    public ClosingScreenController(GraphicsContext graphicsContext, Pane pane) throws IOException {
        this.graphicsContext = graphicsContext;
        this.graphicsContext.setFont(Font.loadFont(new FileInputStream("target/classes/font/pkmnfl.ttf"), 32));
        this.pane = pane;
        this.closingScreen = new ClosingScreen();
        this.lose = false;
        this.reset = false;
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

            graphicsContext.setFill(Color.DARKRED);
            graphicsContext.fillText("PRESS ANYWHERE TO CONTINUE", 310, 540);

            pane.setOnMousePressed(mouseEvent -> {
                reset = true;
                closingScreen.setInClosingScreen(false);
            });
        }
    }

    public void setLose(boolean lose) { this.lose = lose; }
    public void setReset(boolean reset) { this.reset = reset; }

    public Pane getPane() { return pane; }
    public ClosingScreen getClosingScreen() { return closingScreen; }

    public boolean getReset() { return reset; }

    public void reset() {
        lose = false;
        reset = false;
    }
}
