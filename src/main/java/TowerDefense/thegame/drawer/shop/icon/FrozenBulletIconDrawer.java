package TowerDefense.thegame.drawer.shop.icon;

import TowerDefense.thegame.Config;

import java.io.IOException;

public class FrozenBulletIconDrawer extends AbstractIconDrawer {
    public FrozenBulletIconDrawer(String filePath) throws IOException {
        super(filePath, "Frozen", Config.FROZEN_BULLET_COST);
    }
}
