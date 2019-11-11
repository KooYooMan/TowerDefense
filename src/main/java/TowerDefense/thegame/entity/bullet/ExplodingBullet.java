package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.buff.ShootBuff;

public class ExplodingBullet extends AbstractBullet {
    public ExplodingBullet(double posX, double posY, double deltaX, double deltaY, double towerRange) {
        super(posX, posY, deltaX, deltaY, Config.NORMAL_BULLET_SPEED,
                new ShootBuff(Config.NORMAL_BULLET_DAMAGE), towerRange);
        setWidth(Config.EXPLODING_BULLET_WIDTH);
        setHeight(Config.EXPLODING_BULLET_HEIGHT);
    }
}
