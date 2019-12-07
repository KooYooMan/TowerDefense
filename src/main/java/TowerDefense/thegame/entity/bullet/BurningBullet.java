package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.buff.BurningBuff;

public class BurningBullet extends AbstractBullet {
    public static final String NAME = "Burning Bullet";
    public static final long DAMAGE = Config.BURNING_BULLET_DAMAGE;
    public static final String EFFECT = "Inflicts damage over time";
    public static final long TIME = Config.BURNING_BUFF_TIME;

    public BurningBullet(double posX, double posY, double deltaX, double deltaY, double towerRange, double scale) {
        super(posX, posY, deltaX, deltaY,
                Config.BURNING_BULLET_DAMAGE, Config.BURNING_BULLET_SPEED,
                new BurningBuff(),
                towerRange,
                scale,
                Config.BURNING_BULLET_COST);
    }
}
