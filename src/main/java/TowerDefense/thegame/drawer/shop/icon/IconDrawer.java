package TowerDefense.thegame.drawer.shop.icon;

import javafx.scene.canvas.GraphicsContext;

public interface IconDrawer {
    void draw(GraphicsContext graphicsContext, double screenPosX, double screenPosY, double screenWidth, double screenHeight);
}
