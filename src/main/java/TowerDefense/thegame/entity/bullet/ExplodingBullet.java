package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.GameField;
import TowerDefense.thegame.entity.LivingEntity;

public class ExplodingBullet extends AbstractBullet {

    public ExplodingBullet(double posX, double posY, double deltaX, double deltaY, double speed) {
        super(posX, posY, deltaX, deltaY, speed);
    }

    @Override
    public boolean onEffect(GameField field, LivingEntity livingEntity) {
        return false;
    }
}
