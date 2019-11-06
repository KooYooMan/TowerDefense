package TowerDefense.thegame.drawer.bullet;

import TowerDefense.thegame.Config;
import javafx.scene.image.Image;

import java.io.FileInputStream;

public class ExplodingBulletDrawer extends AbstractBulletDrawer {
    public ExplodingBulletDrawer() {
        super(Config.EXPLODING_BULLET_IMAGE);
    }
}
