package TowerDefense.thegame;

import TowerDefense.thegame.entity.shop.ButtonHandler;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.WindowEvent;

import java.io.FileNotFoundException;

public class MainController extends AnimationTimer {
    private Scene scene;
    private StartScreenController startScreenController;
    private ClosingScreenController closingScreenController;
    private GameController gameController;
    private ShopController shopController;
    private ButtonHandler buttonHandler;

    public MainController(Scene scene, StartScreenController startScreenController,
                          ClosingScreenController closingScreenController,
                          GameController gameController, ShopController shopController) {
        this.scene = scene;
        this.startScreenController = startScreenController;
        this.closingScreenController = closingScreenController;
        this.gameController = gameController;
        this.shopController = shopController;
        this.buttonHandler = new ButtonHandler(this);
    }

    private void handleButton() {
        this.shopController.getShopHandler().getTowerButtonDrawerList().forEach(towerButtonDrawer ->
                this.buttonHandler.handleEventTower(towerButtonDrawer)
        );

        this.shopController.getShopHandler().getBulletButtonDrawerList().forEach(bulletButtonDrawer ->
                this.buttonHandler.handleEventBullet(bulletButtonDrawer)
        );

        this.buttonHandler.handleEventSellingTower(this.shopController.getShopHandler().getSellingTowerButton());
        this.buttonHandler.handleEventUpgradingTower(this.shopController.getShopHandler().getUpgradingTowerButton());

        this.buttonHandler.handleEnablingAutoplayEvent(this.shopController.getShopHandler().getEnableAutoButton());
        this.buttonHandler.handleDisablingAutoplayEvent(this.shopController.getShopHandler().getDisableAutoButton());

        this.buttonHandler.handlePauseEvent(this.shopController.getShopHandler().getPauseButton());
        this.buttonHandler.handleResumeEvent(this.shopController.getShopHandler().getResumeButton());
        this.buttonHandler.handleSaveButton(this.shopController.getShopHandler().getSaveButton());
        this.buttonHandler.handleExitButton(this.shopController.getShopHandler().getExitButton());
    }

    final void closeRequestHandler(WindowEvent windowEvent) {
        stop();
        Platform.exit();
        System.exit(0);
    }

    @Override
    public void handle(long l) {
        if (!startScreenController.getStartScreen().isQuit()) {
            if (startScreenController.getStartScreen().isInStartScreen()) {
                startScreenController.handle(l);
            } else {
                if (startScreenController.getStartScreen().getMapPickingScreen().isPickedMap1()) {
                    try {
                        gameController = new GameController(gameController.getGraphicsContext(),
                                gameController.getGamePane(),
                                "resources/map/layout/Map1.txt"
                        );
                        buttonHandler.setGameController(gameController);
                        handleButton();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    startScreenController.getStartScreen().getMapPickingScreen().setPickedMap1(false);
                } else if (startScreenController.getStartScreen().getMapPickingScreen().isPickedMap2()) {
                    try {
                        gameController = new GameController(gameController.getGraphicsContext(),
                                gameController.getGamePane(),
                                "resources/map/layout/Map2.txt"
                        );
                        buttonHandler.setGameController(gameController);
                        handleButton();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    startScreenController.getStartScreen().getMapPickingScreen().setPickedMap2(false);
                } else if (startScreenController.getStartScreen().isContinuePicked()) {
                    try {
                        gameController = new GameController(gameController.getGraphicsContext(),
                                gameController.getGamePane(),
                                "save/save1.txt"
                        );
                        buttonHandler.setGameController(gameController);
                        handleButton();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    startScreenController.getStartScreen().setContinuePicked(false);
                }

                scene.setRoot(new HBox(gameController.getGamePane(), shopController.getShopPane()));

                if (!gameController.isGameOver() && !gameController.isGameClear()) {
                    if (!gameController.isPause()) {
                        gameController.handle(l);
                    }
                    shopController.handle(l);
                } else {
                    closingScreenController.getClosingScreen().setInClosingScreen(true);
                    if (gameController.isGameOver()) {
                        closingScreenController.setLose(true);
                    } else if (gameController.isGameClear()) {
                        closingScreenController.setLose(false);
                    }
                    scene.setRoot(closingScreenController.getPane());

                    if (!closingScreenController.getReset()) {
                        closingScreenController.handle(l);
                    } else {
                        scene.setRoot(startScreenController.getPane());
                        closingScreenController.setReset(false);
                        this.reset();
                    }
                }
            }
        } else {
            this.stop();
            Platform.exit();
            System.exit(0);
        }
    }

    public void start() { super.start(); }

    public void stop() { super.stop(); }

    public void reset() {
        gameController.reset();
        startScreenController.reset();
        closingScreenController.reset();
    }

    public Scene getScene() { return scene; }

    public GameController getGameController() { return gameController; }
    public ShopController getShopController() { return shopController; }
    public ClosingScreenController getClosingScreenController() { return closingScreenController; }
    public StartScreenController getStartScreenController() { return startScreenController; }
}
