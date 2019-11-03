package TowerDefense.thegame.drawer.bullet;

import javafx.scene.image.Image;

import java.io.FileInputStream;

public class BurningBulletDrawer extends AbstractBulletDrawer {
    public BurningBulletDrawer() {
        try {
            this.image = new Image(new FileInputStream("target/classes/bullet/180.png"));
        } catch (Exception e) {
            System.out.println("Error opening files");
        }
    }
}
