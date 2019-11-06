package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.effect.FrozenEffect;

public class FrozenBullet extends AbstractBullet {
    public FrozenBullet(double posX, double posY, double deltaX, double deltaY, int timeToLive) {
        super(posX, posY, deltaX, deltaY, Config.NORMAL_BULLET_SPEED,
                new FrozenEffect(Config.FROZEN_SPEED, Config.TIME_FROZEN_BULLET), timeToLive);
    }
}
