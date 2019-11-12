package TowerDefense.thegame.drawer.target;

import TowerDefense.thegame.drawer.AbstractDrawer;
import TowerDefense.thegame.drawer.EntityDrawer;
import TowerDefense.thegame.entity.GameEntity;
import TowerDefense.thegame.entity.LivingEntity;
import TowerDefense.thegame.entity.enemy.AbstractEnemy;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TargetDrawer extends AbstractDrawer {
    public TargetDrawer() {
        super("resources/asset/PNG/Target/1.png");


    }
    @Override
    public void draw(GraphicsContext graphicsContext, GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double rotateDegree) {
        graphicsContext.setFill(Color.RED);
        graphicsContext.fillRect(screenPosX + screenWidth / 4, screenPosY, screenWidth / 2, 10);
        graphicsContext.setFill(Color.GREEN);
        graphicsContext.fillRect(screenPosX + screenWidth / 4, screenPosY, screenWidth / 2 * ((LivingEntity) entity).getRatioHealth(), 10);

        graphicsContext.drawImage(this.image, screenPosX, screenPosY, screenWidth, screenHeight);
    }
}
