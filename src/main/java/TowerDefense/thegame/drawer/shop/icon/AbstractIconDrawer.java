package TowerDefense.thegame.drawer.shop.icon;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.IOException;

public abstract class AbstractIconDrawer implements IconDrawer {
    private Image icon;
    private ImageView imageView;
    private String label;
    private long price;

    public AbstractIconDrawer(String filePath, String label, long price) throws IOException {
        this.icon = new Image(new FileInputStream(filePath));
        this.imageView = new ImageView(icon);
        imageView.setFitWidth(48);
        imageView.setFitHeight(48);
        this.label = label;
        this.price = price;
    }

    public ImageView getImageView() { return imageView; }
    public String getLabel() { return label; }
    public long getPrice() { return price; }

    @Override
    public void draw(GraphicsContext graphicsContext, double screenPosX, double screenPosY, double screenWidth, double screenHeight) {
        graphicsContext.strokeRect(screenPosX, screenPosY, screenWidth, screenHeight);
        graphicsContext.drawImage(icon, screenPosX, screenPosY, screenWidth, screenHeight);
    }
}
