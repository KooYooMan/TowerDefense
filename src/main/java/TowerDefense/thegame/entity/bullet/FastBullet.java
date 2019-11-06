package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.effect.ShootEffect;

public class FastBullet extends AbstractBullet {
    public FastBullet(double posX, double posY, double deltaX, double deltaY, int timeToLive) {
        super(posX, posY, deltaX, deltaY, Config.FAST_BULLET_SPEED,
                new ShootEffect(Config.NORMAL_BULLET_DAMAGE), timeToLive);
    }
}
