package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.GameField;
import TowerDefense.thegame.entity.Effect.ShootEffect;
import TowerDefense.thegame.entity.LivingEntity;

public class FastBullet extends AbstractBullet {
    public FastBullet(double posX, double posY, double deltaX, double deltaY) {
        super(posX, posY, deltaX, deltaY, Config.FAST_BULLET_SPEED,
                new ShootEffect(Config.NORMAL_BULLET_DAMAGE));
    }
}
