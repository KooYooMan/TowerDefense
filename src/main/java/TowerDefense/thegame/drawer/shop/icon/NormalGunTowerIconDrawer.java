package TowerDefense.thegame.drawer.shop.icon;

import TowerDefense.thegame.Config;

import java.io.IOException;

public class NormalGunTowerIconDrawer extends AbstractIconDrawer {
    public NormalGunTowerIconDrawer(String filePath) throws IOException {
        super(filePath, "Normal Tower", Config.NORMAL_TOWER_COST);
    }
}
