package TowerDefense.thegame.drawer.enemy;

import TowerDefense.thegame.drawer.EntityDrawer;
import TowerDefense.thegame.entity.GameEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.FileInputStream;

public class AbstractEnemyDrawer implements EntityDrawer {
    protected Image image;
    protected AbstractEnemyDrawer(String path) {
        System.out.println(path);
        try {
            image = new Image(new FileInputStream(path));

        } catch (Exception E) {

        }

    }

    @Override
    public void draw(GraphicsContext graphicsContext, GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight) {
        System.out.println("draw");
        System.out.printf("%f %f %f %f\n", screenPosX, screenPosY, screenWidth, screenHeight);
        graphicsContext.drawImage(image, screenPosX, screenPosY, screenWidth, screenHeight);
    }
}
