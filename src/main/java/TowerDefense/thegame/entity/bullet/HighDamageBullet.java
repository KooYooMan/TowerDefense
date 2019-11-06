package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.effect.ShootEffect;

public class HighDamageBullet extends AbstractBullet {
    public HighDamageBullet(double posX, double posY, double deltaX, double deltaY, int timeToLive) {
        super(posX, posY, deltaX, deltaY, Config.NORMAL_BULLET_SPEED,
                new ShootEffect(Config.HIGH_DAMAGE_BULLET), timeToLive);
    }
}
