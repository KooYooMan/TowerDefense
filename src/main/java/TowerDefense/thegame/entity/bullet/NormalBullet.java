package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.effect.ShootEffect;

public class NormalBullet extends AbstractBullet {
    public NormalBullet(double posX, double posY, double deltaX, double deltaY, int timeToLive) {
        super(posX, posY, deltaX, deltaY, Config.NORMAL_BULLET_SPEED,
                new ShootEffect(Config.NORMAL_BULLET_DAMAGE), timeToLive);
    }
}
