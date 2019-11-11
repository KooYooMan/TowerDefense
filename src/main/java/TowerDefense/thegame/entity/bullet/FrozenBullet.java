package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.buff.FrozenBuff;

public class FrozenBullet extends AbstractBullet {
    public FrozenBullet(double posX, double posY, double deltaX, double deltaY, double towerRange) {
        super(posX, posY, deltaX, deltaY, Config.NORMAL_BULLET_SPEED,
                new FrozenBuff(Config.FROZEN_SPEED, Config.TIME_FROZEN_BULLET), towerRange);
    }
}
