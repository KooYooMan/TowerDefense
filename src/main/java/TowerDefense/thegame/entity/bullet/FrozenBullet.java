package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.buff.FrozenBuff;

public class FrozenBullet extends AbstractBullet {
    public FrozenBullet(double posX, double posY, double deltaX, double deltaY, double towerRange, double scale) {
        super(posX, posY, deltaX, deltaY,
                Config.FROZEN_BULLET_DAMAGE, Config.FROZEN_BULLET_SPEED,
                new FrozenBuff(),
                towerRange,
                scale,
                Config.FROZEN_BULLET_COST);
    }
}
