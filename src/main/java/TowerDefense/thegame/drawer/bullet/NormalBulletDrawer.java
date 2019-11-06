package TowerDefense.thegame.drawer.bullet;

import TowerDefense.thegame.Config;
import javafx.scene.image.Image;

import java.io.FileInputStream;

public class NormalBulletDrawer extends AbstractBulletDrawer {
    public NormalBulletDrawer() {
        super(Config.NORMAL_BULLET_IMAGE);
    }
}
