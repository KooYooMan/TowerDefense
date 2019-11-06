package TowerDefense.thegame.drawer.bullet;

import TowerDefense.thegame.Config;
import javafx.scene.image.Image;

import java.io.FileInputStream;

public final class FrozenBulletDrawer extends AbstractBulletDrawer {
    public FrozenBulletDrawer() {
        super(Config.FROZEN_BULLET_IMAGE);
    }
}
