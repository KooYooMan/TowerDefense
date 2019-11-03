package TowerDefense.thegame.drawer.bullet;

import TowerDefense.thegame.drawer.EntityDrawer;
import TowerDefense.thegame.entity.GameEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.awt.*;

public abstract class AbstractBulletDrawer implements EntityDrawer {
    protected Image image;

    @Override
    public void draw(GraphicsContext graphicsContext, GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight) {
        graphicsContext.drawImage(this.image, screenPosX, screenPosY, screenWidth, screenHeight);
    }
}
