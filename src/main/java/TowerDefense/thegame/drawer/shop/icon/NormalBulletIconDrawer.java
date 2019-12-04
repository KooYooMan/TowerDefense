package TowerDefense.thegame.drawer.shop.icon;

import TowerDefense.thegame.Config;

import java.io.IOException;

public class NormalBulletIconDrawer extends AbstractIconDrawer {
    public NormalBulletIconDrawer(String filePath) throws IOException {
        super(filePath, "Normal", Config.NORMAL_BULLET_COST);
    }
}
