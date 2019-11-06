package TowerDefense.thegame.entity.Gun;

import TowerDefense.thegame.Config;

public class NormalGun extends AbstractGun {
    public NormalGun(double posX, double posY) {
        super(posX, posY, Config.NORMAL_GUN_WIDTH, Config.NORMAL_GUN_HEIGHT);
    }
}
