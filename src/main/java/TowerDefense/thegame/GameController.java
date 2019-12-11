package TowerDefense.thegame;

import TowerDefense.thegame.drawer.GameDrawer;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.WindowEvent;

import java.io.*;

public class GameController extends AnimationTimer {
    private final GraphicsContext graphicsContext;
    private GameStage gameStage;
    private GameField gameField;
    private GameDrawer gameDrawer;
    private GameWave gameWave;
    private GameAutoplay gameAutoplay;
    private Pane gamePane;
    boolean pause;
    boolean autoplay;

    private boolean isGameOver;
    private boolean isGameClear;

    public GameController(GraphicsContext graphicsContext, Pane gamePane) throws FileNotFoundException {
        this.graphicsContext = graphicsContext;
        String loadFile = Config.MAP_LAYOUT + 1 + ".txt";
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
        this.gameAutoplay = new GameAutoplay(gameField, gameDrawer.getStageLoader().getLayout());
    }
    public GameController(GraphicsContext graphicsContext, Pane gamePane, String filePath) throws FileNotFoundException {
        this.graphicsContext = graphicsContext;
        this.gameStage = new GameStage(filePath);
        this.gameField = new GameField(gameStage);
        this.gameDrawer = new GameDrawer(graphicsContext, gameField, filePath);
        this.gameWave = this.gameField.getGameWave();
        this.gamePane = gamePane;
        pause = false;
        autoplay = false;
        this.gameAutoplay = new GameAutoplay(gameField, gameDrawer.getStageLoader().getLayout());
        isGameOver = false;
        isGameClear = false;
    }

    final void closeRequestHandler(WindowEvent windowEvent) {
        stop();
        Platform.exit();
        System.exit(0);
    }
    public void doAutoplay() {
        gameAutoplay.doAutoplay();
    }
    @Override
    public void handle(long l) {

        if (isAutoplay()) {
            doAutoplay();
        }
        if (!isGameOver) {
            gameField.handle();
            gameDrawer.render();

            if (gameField.isLose()) {
                isGameOver = true;
            } else if (gameField.isWin()) {
                isGameClear = true;
            }
        }
    }

    public void start() { super.start(); }

    public boolean isPause() { return pause; }
    public boolean isAutoplay() { return autoplay; }
    public boolean isGameOver() {
//        MediaPlayer defeatSound = new MediaPlayer(new Media(new File(Config.DEFEAT_SOUND_PATH).toURI().toString()));
//        defeatSound.play();
        return isGameOver;
    }
    public boolean isGameClear() {
//        MediaPlayer victorySound = new MediaPlayer(new Media(new File(Config.DEFEAT_SOUND_PATH).toURI().toString()));
//        victorySound.play();
        return isGameClear;
    }

    public void reset() {
        isGameOver = false;
        isGameClear = false;
    }

    public void save(String filePath) {
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
    public void setAutoplay(boolean autoplay) { this.autoplay = autoplay; }

    public void setGameAutoplay(GameAutoplay gameAutoplay) {
        this.gameAutoplay = gameAutoplay;
    }

    public GameStage getGameStage() { return gameStage; }
    public GraphicsContext getGraphicsContext() { return graphicsContext; }
    public Pane getGamePane() { return gamePane; }
    public GameDrawer getGameDrawer() { return gameDrawer; }

    @Override
    public String toString() {
        return gameDrawer.toString() +  gameField.toString();
    }
}
