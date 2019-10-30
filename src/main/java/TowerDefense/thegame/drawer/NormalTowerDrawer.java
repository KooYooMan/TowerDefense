package TowerDefense.thegame.drawer;

import TowerDefense.thegame.entity.GameEntity;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import javax.annotation.Nonnull;

public final class NormalTowerDrawer implements EntityDrawer {
	@Override
	public void draw(long tickCount, @Nonnull GraphicsContext graphicsContext, @Nonnull GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double zoom) {
		graphicsContext.setFill(Color.RED);
		graphicsContext.fillOval(screenPosX, screenPosY, screenWidth, screenHeight);
	}
}
