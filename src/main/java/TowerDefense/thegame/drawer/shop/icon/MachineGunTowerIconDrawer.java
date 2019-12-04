package TowerDefense.thegame.drawer.shop.icon;

import TowerDefense.thegame.Config;

import java.io.IOException;

public class MachineGunTowerIconDrawer extends AbstractIconDrawer {
    public MachineGunTowerIconDrawer(String filePath) throws IOException {
        super(filePath, "Machine Gun Tower", Config.MACHINE_TOWER_COST);
    }
}
