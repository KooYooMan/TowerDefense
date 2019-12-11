package TowerDefense.thegame.drawer.enemy;

import TowerDefense.thegame.drawer.AbstractDrawer;
import TowerDefense.thegame.drawer.EntityDrawer;
import TowerDefense.thegame.entity.GameEntity;
import TowerDefense.thegame.entity.LivingEntity;
import TowerDefense.thegame.entity.enemy.AbstractEnemy;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AbstractEnemyDrawer extends AbstractDrawer implements EntityDrawer {
    Image boomImage;
    Image fireImage;
    protected AbstractEnemyDrawer(String path) {
        super(path);

        try {
            fireImage = new Image(new FileInputStream("resources/asset/icon/Burning.png"));
            boomImage = new Image(new FileInputStream("resources/asset/vfx/boom.png"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void rotate(GraphicsContext gc, double angle, double px, double py) {
        Rotate r = new Rotate(angle, px, py);
        gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
    }

    @Override
    public void draw(GraphicsContext graphicsContext, GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double rotateDegree) {
        if (((LivingEntity) entity).isDestroyed()) {
            graphicsContext.drawImage(boomImage, screenPosX, screenPosY, screenWidth, screenHeight);
            return;
        }
        graphicsContext.setFill(Color.RED);
        graphicsContext.fillRect(screenPosX + screenWidth / 4, screenPosY - 10, screenWidth / 2, 5);
        graphicsContext.setFill(Color.GREEN);
        graphicsContext.fillRect(screenPosX + screenWidth / 4, screenPosY - 10, screenWidth / 2 * ((LivingEntity) entity).getRatioHealth(), 5);
        graphicsContext.save();
        rotate(graphicsContext, rotateDegree, screenPosX + screenWidth / 2, screenPosY + screenHeight / 2);
        graphicsContext.drawImage(image, screenPosX, screenPosY, screenWidth, screenHeight);
        graphicsContext.restore();
        if (((AbstractEnemy) entity).isBurning()) {
            graphicsContext.drawImage(fireImage, screenPosX + screenWidth / 4, screenPosY + screenHeight / 4, screenWidth / 2, screenHeight / 2);
        }

    }
}
