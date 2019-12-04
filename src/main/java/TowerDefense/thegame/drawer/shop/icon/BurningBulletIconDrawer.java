package TowerDefense.thegame.drawer.shop.icon;

import TowerDefense.thegame.Config;

import java.io.IOException;

public class BurningBulletIconDrawer extends AbstractIconDrawer {
    public BurningBulletIconDrawer(String filePath) throws IOException {
        super(filePath, "Burning", Config.BURNING_BULLET_COST);
    }
}
