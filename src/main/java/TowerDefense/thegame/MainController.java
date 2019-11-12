package TowerDefense.thegame;

import TowerDefense.thegame.entity.shop.ButtonHandler;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.stage.WindowEvent;

public class MainController extends AnimationTimer {
    private Pane allPane;
    private StartScreenController startScreenController;
    private GameController gameController;
    private ShopController shopController;
    private ButtonHandler buttonHandler;

    public MainController(Pane allPane, StartScreenController startScreenController,
                          GameController gameController, ShopController shopController) {
        this.allPane = allPane;
        this.startScreenController = startScreenController;
        this.gameController = gameController;
        this.shopController = shopController;
        this.buttonHandler = new ButtonHandler(gameController.getGameStage(), gameController.getGamePane(), gameController.getGameDrawer());

        this.shopController.getShopHandler().getTowerButtonDrawerList().forEach(towerButtonDrawer ->
                this.buttonHandler.handleEventTower(towerButtonDrawer)
        );

        this.shopController.getShopHandler().getBulletButtonDrawerList().forEach(bulletButtonDrawer ->
                this.buttonHandler.handleEventBullet(bulletButtonDrawer)
        );
    }

    final void closeRequestHandler(WindowEvent windowEvent) {
        stop();
        Platform.exit();
        System.exit(0);
    }

    @Override
    public void handle(long l) {
        if (startScreenController.getStartScreen().isInStartScreen()) {
            startScreenController.handle(l);
        } else {
            allPane.getChildren().remove(startScreenController.getPane());

            gameController.handle(l);
            shopController.handle(l);
        }
    }

    public void start() { super.start(); }
}
