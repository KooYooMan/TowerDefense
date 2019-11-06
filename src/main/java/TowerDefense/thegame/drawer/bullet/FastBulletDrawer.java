package TowerDefense.thegame.drawer.bullet;

import TowerDefense.thegame.Config;
import javafx.scene.image.Image;

import java.io.FileInputStream;

public class FastBulletDrawer extends AbstractBulletDrawer {
    public FastBulletDrawer() {
        super(Config.FAST_BULLET_IMAGE);
    }
}
