package TowerDefense.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import TowerDefense.thegame.entity.GameEntity;

import javax.annotation.Nonnull;

public interface EntityDrawer {
	void draw(long tickCount, @Nonnull GraphicsContext graphicsContext, @Nonnull GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double zoom);
}
