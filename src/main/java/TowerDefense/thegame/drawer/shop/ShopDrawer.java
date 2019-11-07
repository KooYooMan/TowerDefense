package TowerDefense.thegame.drawer.shop;

import TowerDefense.thegame.Config;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.IOException;

public final class ShopDrawer {
    private final GraphicsContext graphicsContext;
    private final Image background;

    public ShopDrawer(GraphicsContext graphicsContext, String filePath) throws IOException {
        this.graphicsContext = graphicsContext;
        this.background = new Image(new FileInputStream(filePath));
    }

    public final void render() {
        graphicsContext.drawImage(background, 0, 0, Config.SHOP_WIDTH, Config.SCREEN_HEIGHT);
    }
}
