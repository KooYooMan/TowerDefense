package TowerDefense.thegame.entity.tile.spawner;

import TowerDefense.thegame.GameEntities;
import TowerDefense.thegame.GameField;
import TowerDefense.thegame.entity.UpdatableEntity;
import TowerDefense.thegame.entity.enemy.AbstractEnemy;
import TowerDefense.thegame.entity.tile.AbstractTile;

public abstract class AbstractSpawner<E extends AbstractEnemy> extends AbstractTile implements UpdatableEntity {
	private final double spawningSize;
	private final Class<E> spawningClass;
	private final long spawnInterval;
	private long tickDown;
	private long numOfSpawn;

	protected AbstractSpawner(long createdTick, long posX, long posY, long width, long height, double spawningSize,Class<E> spawningClass, long spawnInterval, long initialDelay, long numOfSpawn) {
		super(createdTick, posX, posY, width, height);
		this.spawningSize = spawningSize;
		this.spawningClass = spawningClass;
		this.spawnInterval = spawnInterval;
		this.tickDown = initialDelay;
		this.numOfSpawn = numOfSpawn;
	}

	@Override
	public final void onUpdate(GameField field) {
		this.tickDown -= 1;
		if (tickDown <= 0 && numOfSpawn > 0) {
			// TODO: get a random spot inside spawn range
			// Check if the spot is valid and then spawn an enemy
			// Remember to set this.tickDown back to this.spawnInterval
			// and decrease this.numOfSpawn once you spawn an enemy.
			// this.tickDown = spawnInterval;
			// this.numOfSpawn -= 1;
		}
	}

	/**
	 * Create a new enemy. Each spawner spawn different type of enemy.
	 * Override this method and return the type of enemy that your spawner spawn.
	 * See NormalSpawner for example.
	 *
	 * @param createdTick createdTick
	 * @param posX posX
	 * @param posY posY
	 * @return new enemy entity
	 */
	protected abstract E doSpawn(long createdTick, double posX, double posY);
}
