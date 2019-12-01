package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.buff.NoBuff;

public class NormalBullet extends AbstractBullet {
    public NormalBullet(double posX, double posY, double deltaX, double deltaY, double towerRange, double scale) {
        super(posX, posY, deltaX, deltaY,
                Config.NORMAL_BULLET_DAMAGE, Config.NORMAL_BULLET_SPEED,
                new NoBuff(),
                towerRange,
                scale,
                Config.NORMAL_BULLET_COST);
    }
}
