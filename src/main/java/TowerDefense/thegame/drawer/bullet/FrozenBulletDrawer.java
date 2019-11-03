package TowerDefense.thegame.drawer.bullet;

import javafx.scene.image.Image;

import java.io.FileInputStream;

public final class FrozenBulletDrawer extends AbstractBulletDrawer {
    public FrozenBulletDrawer() {
        try {
            this.image = new Image( new FileInputStream("target/classes/bullet/180.png"));
        } catch (Exception e) {
            System.out.println("Error opening image");
        }
    }
}
