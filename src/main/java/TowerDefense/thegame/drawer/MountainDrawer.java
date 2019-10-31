package TowerDefense.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import TowerDefense.thegame.drawer.EntityDrawer;
import TowerDefense.thegame.entity.GameEntity;

public final class MountainDrawer implements EntityDrawer {
	@Override
	public void draw(long tickCount, GraphicsContext graphicsContext, GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double zoom) {
		graphicsContext.setFill(Color.DARKGREEN);
		graphicsContext.fillRect(screenPosX, screenPosY, screenWidth, screenHeight);
	}
}
