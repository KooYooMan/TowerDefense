package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.buff.ShootBuff;

public class HighDamageBullet extends AbstractBullet {
    public HighDamageBullet(double posX, double posY, double deltaX, double deltaY, double towerRange) {
        super(posX, posY, deltaX, deltaY, Config.NORMAL_BULLET_SPEED,
                new ShootBuff(Config.HIGH_DAMAGE_BULLET), towerRange);
    }
}
