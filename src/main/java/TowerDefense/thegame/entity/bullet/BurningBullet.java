package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.buff.BurningBuff;

public class BurningBullet extends AbstractBullet {
    public BurningBullet(double posX, double posY, double deltaX, double deltaY, double towerRange, double scale) {
        super(posX, posY, deltaX, deltaY,
                Config.BURNING_BULLET_DAMAGE, Config.BURNING_BULLET_SPEED,
                new BurningBuff(),
                towerRange,
                scale,
                Config.BURNING_BULLET_COST);
    }
}
