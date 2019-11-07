package TowerDefense.thegame.drawer.icon;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.IOException;

public abstract class AbstractIconDrawer implements IconDrawer {
    private Image icon;

    public AbstractIconDrawer(String filePath) throws IOException {
        this.icon = new Image(new FileInputStream(filePath));
    }

    @Override
    public void draw(GraphicsContext graphicsContext, double screenPosX, double screenPosY, double screenWidth, double screenHeight) {
        graphicsContext.drawImage(icon, screenPosX, screenPosY, screenWidth, screenHeight);
    }
}
