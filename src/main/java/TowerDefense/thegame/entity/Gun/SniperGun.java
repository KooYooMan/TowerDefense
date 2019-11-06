package TowerDefense.thegame.entity.Gun;

import TowerDefense.thegame.Config;

public class SniperGun extends AbstractGun {
    public SniperGun(double posX, double posY) {
        super(posX, posY, Config.SNIPER_GUN_WIDTH, Config.SNIPER_GUN_HEIGHT);
    }
}
