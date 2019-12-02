package TowerDefense.thegame.drawer.shop.icon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IconDrawerList {
    private static List<AbstractIconDrawer> towerIconDrawerList = null;
    static {
        try {
            towerIconDrawerList = new ArrayList<>(List.of(
                    new NormalGunTowerIconDrawer("resources/asset/icon/NormalTower.png"),
                    new MachineGunTowerIconDrawer("resources/asset/icon/MachineGunTower.png"),
                    new SniperGunTowerIconDrawer("resources/asset/icon/SniperTower.png")
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<AbstractIconDrawer> bulletIconDrawerList = null;
    static {
        try {
            bulletIconDrawerList = new ArrayList<>(List.of(
                    new NormalBulletIconDrawer("resources/asset/icon/Normal.png"),
                    new BurningBulletIconDrawer("resources/asset/icon/Burning.png"),
                    new FrozenBulletIconDrawer("resources/asset/icon/Frozen.png")
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<AbstractIconDrawer> getTowerIconDrawerList() { return towerIconDrawerList; }
    public static List<AbstractIconDrawer> getBulletIconDrawerList() { return bulletIconDrawerList; }
}
