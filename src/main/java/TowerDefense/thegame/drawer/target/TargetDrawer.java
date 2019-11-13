package TowerDefense.thegame.drawer.target;

import TowerDefense.thegame.drawer.AbstractDrawer;
import TowerDefense.thegame.drawer.EntityDrawer;
import TowerDefense.thegame.entity.GameEntity;
import javafx.scene.canvas.GraphicsContext;

public class TargetDrawer extends AbstractDrawer {
    public TargetDrawer() {
        super("resources/asset/PNG/Target/1.png");


    }
    @Override
    public void draw(GraphicsContext graphicsContext, GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double rotateDegree) {
        graphicsContext.drawImage(this.image, screenPosX, screenPosY, screenWidth, screenHeight);
    }
}
