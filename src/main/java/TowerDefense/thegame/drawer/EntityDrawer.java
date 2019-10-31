package TowerDefense.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import TowerDefense.thegame.entity.GameEntity;

public interface EntityDrawer {
	void draw(long tickCount, GraphicsContext graphicsContext, GameEntity entity, double screenPosX, double screenPosY, double screenWidth, double screenHeight, double zoom);
}
