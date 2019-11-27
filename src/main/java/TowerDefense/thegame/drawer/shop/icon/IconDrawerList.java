package TowerDefense.thegame.drawer.shop.icon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IconDrawerList {
    private static List<AbstractIconDrawer> towerIconDrawerList = null;
    static {
        try {
            towerIconDrawerList = new ArrayList<>(List.of(
                    new NormalGunTowerIconDrawer("target/classes/icon/NormalTower.png"),
                    new MachineGunTowerIconDrawer("target/classes/icon/MachineGunTower.png"),
                    new SniperGunTowerIconDrawer("target/classes/icon/SniperTower.png")
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<AbstractIconDrawer> bulletIconDrawerList = null;
    static {
        try {
            bulletIconDrawerList = new ArrayList<>(List.of(
                    new BurningBulletIconDrawer("target/classes/icon/Burning.png"),
                    new FrozenBulletIconDrawer("target/classes/icon/Frozen.png")
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<AbstractIconDrawer> getTowerIconDrawerList() { return towerIconDrawerList; }
    public static List<AbstractIconDrawer> getBulletIconDrawerList() { return bulletIconDrawerList; }
}
