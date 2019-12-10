package TowerDefense.thegame;

import TowerDefense.thegame.entity.shop.ButtonHandler;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.WindowEvent;

import java.io.FileNotFoundException;

public class MainController extends AnimationTimer {
    //private Pane allPane;
    private Scene scene;
    private StartScreenController startScreenController;
    private ClosingScreenController closingScreenController;
    private GameController gameController;
    private ShopController shopController;
    private ButtonHandler buttonHandler;

    public MainController(Scene scene, StartScreenController startScreenController,
                          ClosingScreenController closingScreenController,
                          GameController gameController, ShopController shopController) {
        //this.allPane = allPane;
        this.scene = scene;
        this.startScreenController = startScreenController;
        this.closingScreenController = closingScreenController;
        this.gameController = gameController;
        this.shopController = shopController;
        this.buttonHandler = new ButtonHandler(gameController, gameController.getGameStage(),
                gameController.getGamePane(), gameController.getGameDrawer(), shopController.getShopDrawer());

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
                //GameController backupGameController = gameController;
                if (startScreenController.getStartScreen().getMapPickingScreen().isPickedMap1()) {
//                    gameController.getGameDrawer().setMap(1);
//                    gameController.setGameAutoplay(new GameAutoplay(gameController.getGameDrawer().getStageLoader().getLayout()));

                    try {
                        gameController = new GameController(gameController.getGraphicsContext(), gameController.getGamePane(),
                                "resources/map/layout/Map1.txt"
                        );
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    startScreenController.getStartScreen().getMapPickingScreen().setPickedMap1(false);
                } else if (startScreenController.getStartScreen().getMapPickingScreen().isPickedMap2()) {
//                    gameController.getGameDrawer().setMap(2);
//                    gameController.setGameAutoplay(new GameAutoplay(gameController.getGameDrawer().getStageLoader().getLayout()));

                    try {
                        gameController = new GameController(gameController.getGraphicsContext(), gameController.getGamePane(),
                                "resources/map/layout/Map2.txt"
                        );
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    startScreenController.getStartScreen().getMapPickingScreen().setPickedMap2(false);
                }

                scene.setRoot(new HBox(gameController.getGamePane(), shopController.getShopPane()));

                if (!gameController.isGameOver()) {
                    if (!gameController.isPause()) {
                        gameController.handle(l);
                    }
                    shopController.handle(l);
                } else {
                    closingScreenController.getClosingScreen().setInClosingScreen(true);
                    scene.setRoot(closingScreenController.getPane());
                    closingScreenController.handle(l);
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
}
