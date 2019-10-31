package TowerDefense.thegame.entity;

import TowerDefense.thegame.GameField;

public interface SpawnListener extends GameEntity {
	void onSpawn(GameField field);
}
