package TowerDefense.thegame;

import TowerDefense.thegame.drawer.GameDrawer;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.WindowEvent;

public class GameController extends AnimationTimer {
    private final GraphicsContext graphicsContext;
    private GameField gameField;
    private GameDrawer drawer;

    public GameController(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
        this.gameField = new GameField(new GameStage());
        this.drawer = new GameDrawer(graphicsContext, gameField);
    }

    final void closeRequestHandler(WindowEvent windowEvent) {
        stop();
        Platform.exit();
        System.exit(0);
    }

    @Override
    public void handle(long l) {
        gameField.handle();
        drawer.render();
    }

    public void start() {
        super.start();
    }
}
