package TowerDefense.thegame.drawer.bullet;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.drawer.AbstractDrawer;
import TowerDefense.thegame.drawer.EntityDrawer;
import TowerDefense.thegame.entity.GameEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

import java.awt.*;
import java.io.FileInputStream;

public abstract class AbstractBulletDrawer extends AbstractDrawer implements EntityDrawer {
    protected AbstractBulletDrawer(String path) {
        super(path);
    }

    private void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

    @Override
    public void draw(GraphicsContext graphicsContext, GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double rotateDegree) {
        graphicsContext.save();
        rotate(graphicsContext, rotateDegree, screenPosX + screenWidth / 2, screenPosY + screenHeight / 2);
        graphicsContext.drawImage(image, screenPosX, screenPosY, screenWidth, screenHeight);
        graphicsContext.restore();
    }
}
