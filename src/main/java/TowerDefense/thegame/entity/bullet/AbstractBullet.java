package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.GameField;
import TowerDefense.thegame.entity.*;
import TowerDefense.thegame.entity.buff.AbstractBuff;
import TowerDefense.thegame.entity.enemy.AbstractEnemy;

public abstract class AbstractBullet extends AbstractEntity implements UpdatableEntity, DestroyableEntity, EffectEntity {
	private final double deltaX;
	private final double deltaY;
	private final AbstractBuff abstractBuff;
	protected int timetoLive;

	protected AbstractBullet(double posX, double posY, double deltaX, double deltaY,
							 double speed, AbstractBuff abstractBuff, int timetoLive) {
		super(posX, posY, Config.NORMAL_BULLET_WIDTH, Config.NORMAL_BULLET_HEIGHT);
		final double normalize = speed / Math.sqrt(deltaX * deltaX + deltaY * deltaY);
		this.deltaX = deltaX * normalize;
		this.deltaY = deltaY * normalize;
		this.abstractBuff = abstractBuff;
		this.timetoLive = timetoLive;
	}

	@Override
	public final void onUpdate(GameField field) {
		timetoLive --;
		setPosX(getPosX() + deltaX);
		setPosY(getPosY() + deltaY);
	}

	@Override
	public boolean isDestroyed() {
		return this.timetoLive <= 0;
	}

	@Override
	public boolean onEffect(GameField field, LivingEntity livingEntity) {
		return true;
	}
}
