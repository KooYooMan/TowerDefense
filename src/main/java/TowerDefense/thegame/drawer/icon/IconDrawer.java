package TowerDefense.thegame.drawer.icon;

import javafx.scene.canvas.GraphicsContext;

public interface IconDrawer {
    public void draw(GraphicsContext graphicsContext, double screenPosX, double screenPosY, double screenWidth, double screenHeight);
}
