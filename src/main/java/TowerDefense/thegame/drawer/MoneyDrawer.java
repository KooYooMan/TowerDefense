package TowerDefense.thegame.drawer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MoneyDrawer {
    private Image image;
    private GraphicsContext graphicsContext;

    public MoneyDrawer(GraphicsContext graphicsContext) throws FileNotFoundException {
        this.image = new Image(new FileInputStream("target/classes/icon/coin.png"));
        this.graphicsContext = graphicsContext;
        graphicsContext.setFont(Font.loadFont(new FileInputStream("target/classes/font/pkmnfl.ttf"), 24));
    }

    public void draw(long money) {
        graphicsContext.drawImage(image, 0, 0, 24, 24);
        graphicsContext.setFill(Color.BLACK);
        graphicsContext.fillText(Long.toString(money), 32, 21);
    }
}
