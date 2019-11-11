package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.buff.BurningBuff;

public class BurningBullet extends AbstractBullet {
    public BurningBullet(double posX, double posY, double deltaX, double deltaY, double towerRange) {
        super(posX, posY, deltaX, deltaY, Config.NORMAL_BULLET_SPEED,
                new BurningBuff(Config.BURNING_BULLET_DAMAGE, Config.TIME_BURNING_BULLET), towerRange);
    }
}
