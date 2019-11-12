package TowerDefense.thegame.entity;

public interface DestroyableEntity extends GameEntity {
	void doDestroy();
	boolean isDestroyed();
}

