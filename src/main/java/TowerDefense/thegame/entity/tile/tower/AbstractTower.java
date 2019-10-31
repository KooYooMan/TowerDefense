package TowerDefense.thegame.entity.tile.tower;

import TowerDefense.thegame.GameEntities;
import TowerDefense.thegame.GameField;
import TowerDefense.thegame.entity.UpdatableEntity;
import TowerDefense.thegame.entity.bullet.AbstractBullet;
import TowerDefense.thegame.entity.enemy.AbstractEnemy;
import TowerDefense.thegame.entity.tile.AbstractTile;

import java.util.Collection;

public abstract class AbstractTower<E extends AbstractBullet> extends AbstractTile implements UpdatableEntity {
	private final double range;
	private final long speed;

	private long tickDown;

	protected AbstractTower(long createdTick, long posX, long posY, double range, long speed) {
		super(createdTick, posX, posY, 1L, 1L);
		this.range = range;
		this.speed = speed;
		this.tickDown = 0;
	}

	@Override
	public final void onUpdate(GameField field) {
		this.tickDown -= 1;
		if (tickDown <= 0) {
			// TODO: Find a target and spawn a bullet to that direction.
			// Use GameEntities.getFilteredOverlappedEntities to find target in range
			// Remember to set this.tickDown back to this.speed after shooting something.
			// this.tickDown = speed;
		}
	}

	/**
	 * Create a new bullet. Each tower spawn different type of bullet.
	 * Override this method and return the type of bullet that your tower shot out.
	 * See NormalTower for example.
	 *
	 * @param createdTick createdTick
	 * @param posX posX
	 * @param posY posY
	 * @param deltaX deltaX
	 * @param deltaY deltaY
	 * @return the bullet entity
	 */
	protected abstract E doSpawn(long createdTick, double posX, double posY, double deltaX, double deltaY);
}
