package TowerDefense.thegame.drawer.bullet;

import TowerDefense.thegame.drawer.AbstractDrawer;
import TowerDefense.thegame.drawer.EntityDrawer;
import TowerDefense.thegame.entity.GameEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import java.awt.*;
import java.io.FileInputStream;

public abstract class AbstractBulletDrawer extends AbstractDrawer implements EntityDrawer {
    protected AbstractBulletDrawer(String path) {
        super(path);
    }

    @Override
    public void draw(GraphicsContext graphicsContext, GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double rotateDegree) {
        graphicsContext.drawImage(this.image, screenPosX, screenPosY, screenWidth, screenHeight);
    }
}
