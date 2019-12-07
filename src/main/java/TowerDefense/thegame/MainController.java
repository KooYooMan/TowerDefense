package TowerDefense.thegame;

import TowerDefense.thegame.entity.shop.ButtonHandler;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.WindowEvent;

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
        this.buttonHandler = new ButtonHandler(gameController.getGameStage(), gameController.getGamePane(),
                gameController.getGameDrawer(), shopController.getShopDrawer());

        this.shopController.getShopHandler().getTowerButtonDrawerList().forEach(towerButtonDrawer ->
                this.buttonHandler.handleEventTower(towerButtonDrawer)
        );

        this.shopController.getShopHandler().getBulletButtonDrawerList().forEach(bulletButtonDrawer ->
                this.buttonHandler.handleEventBullet(bulletButtonDrawer)
        );

        this.buttonHandler.handleEventSellingTower(this.shopController.getShopHandler().getSellingTowerButton());
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
                //allPane.getChildren().remove(startScreenController.getPane());
                scene.setRoot(new HBox(gameController.getGamePane(), shopController.getShopPane()));

                gameController.handle(l);
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
