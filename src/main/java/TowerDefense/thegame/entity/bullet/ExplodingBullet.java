package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.effect.ShootEffect;

public class ExplodingBullet extends AbstractBullet {
    public ExplodingBullet(double posX, double posY, double deltaX, double deltaY, int timeToLive) {
        super(posX, posY, deltaX, deltaY, Config.NORMAL_BULLET_SPEED,
                new ShootEffect(Config.NORMAL_BULLET_DAMAGE), timeToLive);
        setWidth(Config.EXPLODING_BULLET_WIDTH);
        setHeight(Config.EXPLODING_BULLET_HEIGHT);
    }
}
