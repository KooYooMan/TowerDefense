package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.GameField;
import TowerDefense.thegame.entity.*;
import TowerDefense.thegame.entity.Effect.AbstractEffect;

public abstract class AbstractBullet extends AbstractEntity implements UpdatableEntity, EffectEntity {
	private final double deltaX;
	private final double deltaY;
	private final AbstractEffect abstractEffect;
	protected boolean shoot = false;

	protected AbstractBullet(double posX, double posY, double deltaX, double deltaY, double speed, AbstractEffect abstractEffect) {
		super(posX, posY, Config.NORMAL_BULLET_WIDTH, Config.NORMAL_BULLET_HEIGHT);
		final double normalize = speed / Math.sqrt(deltaX * deltaX + deltaY * deltaY);
		this.deltaX = deltaX * normalize;
		this.deltaY = deltaY * normalize;
		this.abstractEffect = abstractEffect;
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
	public void doDestroy() {}

	@Override
	public boolean onEffect(GameField field, LivingEntity livingEntity) {
		return false;
	}
}
