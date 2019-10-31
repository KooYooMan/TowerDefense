package TowerDefense.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import TowerDefense.thegame.entity.GameEntity;
import TowerDefense.thegame.entity.tile.Road;

public final class RoadDrawer implements EntityDrawer {
	@Override
	public void draw(long tickCount, GraphicsContext graphicsContext, GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double zoom) {
		graphicsContext.setFill(Color.LIGHTGREEN);
		graphicsContext.fillRect(screenPosX, screenPosY, screenWidth, screenHeight);
//		if (entity instanceof Road) {
//			graphicsContext.setFill(Color.BLACK);
//			graphicsContext.fillText(String.format("%2.2f", ((Road) entity).getDistance()), screenPosX, screenPosY + screenHeight / 2);
//		}
	}
}
