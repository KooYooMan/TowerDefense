package TowerDefense.thegame.drawer;

import javafx.scene.image.Image;

import java.io.FileInputStream;

public abstract class AbstractDrawer implements EntityDrawer {
    protected Image image;
    protected AbstractDrawer(String path) {
        try {
            this.image = new Image(new FileInputStream(path));
        } catch (Exception e) {
            System.out.println(e.getClass() + " Error opening files");
        }
    }
}
