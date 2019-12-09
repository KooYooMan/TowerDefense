package TowerDefense.thegame;

import TowerDefense.thegame.drawer.GameDrawer;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.WindowEvent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class GameController extends AnimationTimer {
    private final GraphicsContext graphicsContext;
    private GameStage gameStage;
    private GameField gameField;
    private GameDrawer gameDrawer;
    private GameWave gameWave;
    private Pane gamePane;
    boolean pause;
    boolean autoplay;

    public GameController(GraphicsContext graphicsContext, Pane gamePane) {
        this.graphicsContext = graphicsContext;
        String loadFile = Config.MAP_LAYOUT + 2 + ".txt";
        String savedFile = "save/save1.txt";
        int DEBUG = 1;
        if (DEBUG == 0) {
            this.gameStage = new GameStage();
        } else if (DEBUG == 1) {
            //this.gameStage = new GameStage("save/save1.txt");
            this.gameStage = new GameStage(loadFile);
        } else if (DEBUG == 2) {
            this.gameStage = new GameStage(savedFile);
        }
        this.gameField = new GameField(gameStage);
        //this.gameDrawer = new GameDrawer(graphicsContext, gameField, "save/save3.txt");
        if (DEBUG == 0) {
            this.gameDrawer = new GameDrawer(graphicsContext, gameField);
        } else if (DEBUG == 1) {
            this.gameDrawer = new GameDrawer(graphicsContext, gameField, loadFile);
        } else if (DEBUG == 2) {
            this.gameDrawer = new GameDrawer(graphicsContext, gameField, savedFile);
        }
        this.gameWave = this.gameField.getGameWave();
        this.gamePane = gamePane;
        pause = false;
        autoplay = false;
    }
    public GameController(GraphicsContext graphicsContext, Pane gamePane, String filePath) {
        this.graphicsContext = graphicsContext;
        this.gameStage = new GameStage(filePath);
        this.gameField = new GameField(gameStage);
        this.gameDrawer = new GameDrawer(graphicsContext, gameField, filePath);
        this.gameWave = this.gameField.getGameWave();
        this.gamePane = gamePane;
        pause = false;
        autoplay = false;

    }
    final void closeRequestHandler(WindowEvent windowEvent) {
        stop();
        Platform.exit();
        System.exit(0);
    }

    @Override
    public void handle(long l) {
        gameField.handle();
        gameDrawer.render();

        //System.out.println();
        System.out.printf("%b %b %b\n", gameField.isPlaying(), gameField.isLose(), gameField.isWin());
        //System.out.println();
        //save("save/save1.txt");
    }

    public void start() {
        super.start();
    }

    public boolean isPause() {
        return pause;
    }
    public boolean isAutoplay() {
        return autoplay;
    }
    void changePause() {
        pause = !pause;
    }
    void changeAutoplay() {
        autoplay = !autoplay;

    }
    void save(String filePath) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }

    public GameStage getGameStage() { return gameStage; }
    public Pane getGamePane() { return gamePane; }
    public GameDrawer getGameDrawer() { return gameDrawer; }

    @Override
    public String toString() {
        return gameDrawer.toString() +  gameField.toString();
    }
}
