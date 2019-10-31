package TowerDefense.thegame.entity;

import TowerDefense.thegame.GameField;

public interface UpdatableEntity extends GameEntity {
	void onUpdate(GameField field);
}
