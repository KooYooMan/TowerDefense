package TowerDefense.thegame;

import TowerDefense.thegame.drawer.stage.StageDrawer;
import TowerDefense.thegame.entity.shop.ButtonHandler;
import TowerDefense.thegame.entity.stage.StageLoader;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class MainController extends AnimationTimer {
    //private Pane allPane;
    private Scene scene;
    private StartScreenController startScreenController;
    private GameController gameController;
    private ShopController shopController;
    private ButtonHandler buttonHandler;

    public MainController(Scene scene, StartScreenController startScreenController,
                          GameController gameController, ShopController shopController) {
        //this.allPane = allPane;
        this.scene = scene;
        this.startScreenController = startScreenController;
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
                if (startScreenController.getStartScreen().getMapPickingScreen().isPickedMap1()) {
                    try {
                        gameController.getGameDrawer().setStageLoader(new StageLoader(
                                "resources/map/layout/Map1.txt", "resources/map/image/Map1.png"
                        ));
                        gameController.getGameDrawer().setStageDrawer(new StageDrawer(
                                gameController.getGameDrawer().getGraphicsContext(),
                                gameController.getGameDrawer().getStageLoader()
                        ));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    startScreenController.getStartScreen().getMapPickingScreen().setPickedMap1(false);
                } else if (startScreenController.getStartScreen().getMapPickingScreen().isPickedMap2()) {
                    try {
                        gameController.getGameDrawer().setStageLoader(new StageLoader(
                                "resources/map/layout/Map2.txt", "resources/map/image/Map2.png"
                        ));
                        gameController.getGameDrawer().setStageDrawer(new StageDrawer(
                                gameController.getGameDrawer().getGraphicsContext(),
                                gameController.getGameDrawer().getStageLoader()
                        ));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    startScreenController.getStartScreen().getMapPickingScreen().setPickedMap2(false);
                }

                scene.setRoot(new HBox(gameController.getGamePane(), shopController.getShopPane()));

                if (!gameController.isPause()) {
                    gameController.handle(l);
                }
                shopController.handle(l);
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
