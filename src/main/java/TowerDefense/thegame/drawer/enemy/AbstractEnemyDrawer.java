package TowerDefense.thegame.drawer.enemy;

import TowerDefense.thegame.drawer.AbstractDrawer;
import TowerDefense.thegame.drawer.EntityDrawer;
import TowerDefense.thegame.entity.GameEntity;
import TowerDefense.thegame.entity.enemy.AbstractEnemy;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Rotate;

import java.io.FileInputStream;

public class AbstractEnemyDrawer extends AbstractDrawer implements EntityDrawer {
    protected AbstractEnemyDrawer(String path) {
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
        graphicsContext.drawImage(image, screenPosX, screenPosY);
        graphicsContext.restore();
    }
}
