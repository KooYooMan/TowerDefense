package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.effect.BurningEffect;

public class BurningBullet extends AbstractBullet {
    public BurningBullet(double posX, double posY, double deltaX, double deltaY, int timeToLive) {
        super(posX, posY, deltaX, deltaY, Config.NORMAL_BULLET_DAMAGE,
                new BurningEffect(Config.BURNING_BULLET_DAMAGE, Config.TIME_BURNING_BULLET), timeToLive);
    }
}
