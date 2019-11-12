package TowerDefense.thegame;

import TowerDefense.thegame.entity.shop.ButtonHandler;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.stage.WindowEvent;

public class MainController extends AnimationTimer {
    private GameController gameController;
    private ShopController shopController;
    private ButtonHandler buttonHandler;

    public MainController(GameController gameController, ShopController shopController) {
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
        gameController.handle(l);
        shopController.handle(l);
    }

    public void start() { super.start(); }
}
