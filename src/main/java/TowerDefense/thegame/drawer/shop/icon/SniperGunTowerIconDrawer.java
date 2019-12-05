package TowerDefense.thegame.drawer.shop.icon;

import TowerDefense.thegame.Config;

import java.io.IOException;

public class SniperGunTowerIconDrawer extends AbstractIconDrawer {
    public SniperGunTowerIconDrawer(String filePath) throws IOException {
        super(filePath, "Sniper Tower", Config.SNIPER_TOWER_COST);
    }
}
