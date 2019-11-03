package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.GameField;
import TowerDefense.thegame.entity.*;

public abstract class AbstractBullet extends AbstractEntity implements UpdatableEntity, EffectEntity {
	private final double deltaX;
	private final double deltaY;
	protected boolean shoot = false;

	protected AbstractBullet(double posX, double posY, double deltaX, double deltaY, double speed) {
		super(posX, posY, 10, 10);
		final double normalize = speed / Math.sqrt(deltaX * deltaX + deltaY * deltaY);
		this.deltaX = deltaX * normalize;
		this.deltaY = deltaY * normalize;
	}

	@Override
	public final void onUpdate(GameField field) {
		setPosX(getPosX() + deltaX);
		setPosY(getPosY() + deltaY);
	}

	@Override
	public boolean isDestroyed() {
		return this.shoot;
	}

	@Override
	public void doDestroy() {

	}
}
