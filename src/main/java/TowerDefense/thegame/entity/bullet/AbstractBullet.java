package TowerDefense.thegame.entity.bullet;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.GameField;
import TowerDefense.thegame.entity.*;
import TowerDefense.thegame.entity.buff.AbstractBuff;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.net.URL;

public abstract class AbstractBullet extends AbstractEntity implements UpdatableEntity, DestroyableEntity, EffectEntity, RotatableEntity, SpawnListener {
	private final double deltaX;
	private final double deltaY;
	private long damage;
	private final AbstractBuff abstractBuff;
	protected int timetoLive;
	private double degreeRotate;
	private long cost;

	protected AbstractBullet(double posX, double posY, double deltaX, double deltaY,
							 long damage, double speed, AbstractBuff abstractBuff, double towerRange, double scale, long cost) {
		super(posX - Config.NORMAL_BULLET_WIDTH / 2, posY - Config.NORMAL_BULLET_HEIGHT / 2, Config.NORMAL_BULLET_WIDTH, Config.NORMAL_BULLET_HEIGHT);
		final double normalize = speed / Math.sqrt(deltaX * deltaX + deltaY * deltaY);
		this.deltaX = deltaX * normalize;
		this.deltaY = deltaY * normalize;
		this.damage = (long) (damage * scale);
		abstractBuff.doScale(scale);
		this.abstractBuff = abstractBuff;
		this.timetoLive = (int)(towerRange / speed) + 4;
		this.cost = cost;
	}

	public long getCost() {
		return cost;
	}

	@Override
	public final void onUpdate(GameField field) {
		timetoLive --;
		setPosX(getPosX() + deltaX);
		setPosY(getPosY() + deltaY);
		this.degreeRotate += 5;
		if (this.degreeRotate >= 360) this.degreeRotate -= 360;
	}

	@Override
	public void doDestroy() {
		timetoLive = -1;
	}

	@Override
	public boolean isDestroyed() {
		return this.timetoLive <= -1;
	}

	@Override
	public boolean onEffect(GameField field, LivingEntity livingEntity) {
		livingEntity.takeDamage(-damage);
		if (!isDestroyed()) {
			((BuffedEntity) livingEntity).getBuffed(abstractBuff);
			this.timetoLive = 0;
		}
		return false;
	}

	@Override
	public double getDegreeRotate() {
		return this.degreeRotate;
	}
	public long getDamage() {
		return this.damage;
	}

	@Override
	public void onSpawn(GameField field) {
		field.getGameStage().reduceMoney(cost);
	}

	@Override
	public String toString() {
		return "";
	}
}
