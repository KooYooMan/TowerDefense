package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.GameField;
import TowerDefense.thegame.entity.LivingEntity;

public final class NormalBullet extends AbstractBullet {
	public NormalBullet(double posX, double posY, double deltaX, double deltaY) {
		super(posX, posY, deltaX, deltaY, 400);
	}

	@Override
	public boolean onEffect(GameField field, LivingEntity livingEntity) {
		return false;
	}
}
