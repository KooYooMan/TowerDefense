package TowerDefense.thegame;

import TowerDefense.thegame.drawer.shop.ShopDrawer;
import TowerDefense.thegame.entity.shop.ShopHandler;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class ShopController extends AnimationTimer {
    //private final GraphicsContext graphicsContext;
    private final ShopDrawer shopDrawer;
    private final ShopHandler shopHandler;

    public ShopController(GraphicsContext graphicsContext, Pane pane) throws IOException {
        //this.graphicsContext = graphicsContext;
        this.shopDrawer = new ShopDrawer(graphicsContext, "target/classes/shop/Background.png");
        this.shopHandler = new ShopHandler(pane);
    }

    final void closeRequestHandler(WindowEvent windowEvent) {
        stop();
        Platform.exit();
        System.exit(0);
    }

    @Override
    public void handle(long l) {
        shopDrawer.render();
    }

    public void start() { super.start(); }

    public ShopHandler getShopHandler() { return shopHandler; }
}
