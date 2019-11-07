package TowerDefense.thegame;

import TowerDefense.thegame.drawer.shop.ShopDrawer;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class ShopController extends AnimationTimer {
    private final GraphicsContext graphicsContext;
    private final ShopDrawer shopDrawer;

    public ShopController(GraphicsContext graphicsContext) throws IOException {
        this.graphicsContext = graphicsContext;
        this.shopDrawer = new ShopDrawer(graphicsContext, "target/classes/shop/Background.png");
    }

    final void closeRequestHandler(WindowEvent windowEvent) {
        stop();
        Platform.exit();
        System.exit(0);
    }

    @Override
    public void handle(long now) {
        shopDrawer.render();
    }

    public void start() { super.start(); }
}
