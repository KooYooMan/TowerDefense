package TowerDefense.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import TowerDefense.thegame.entity.GameEntity;

import javax.annotation.Nonnull;

public final class TargetDrawer implements EntityDrawer {
	@Override
	public void draw(long tickCount, @Nonnull GraphicsContext graphicsContext, @Nonnull GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double zoom) {
		graphicsContext.setStroke(Color.DARKRED);
		graphicsContext.setLineWidth(4);
		graphicsContext.strokeRect(screenPosX, screenPosY, screenWidth, screenHeight);
	}
}
