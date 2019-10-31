package TowerDefense.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import TowerDefense.thegame.entity.GameEntity;

public final class SpawnerDrawer implements EntityDrawer {
	@Override
	public void draw(long tickCount, GraphicsContext graphicsContext, GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double zoom) {
		graphicsContext.setStroke(Color.DARKBLUE);
		graphicsContext.setLineWidth(4);
		graphicsContext.strokeRect(screenPosX, screenPosY, screenWidth, screenHeight);
	}
}
