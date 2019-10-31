package TowerDefense.thegame.entity;

import TowerDefense.thegame.GameField;

public interface DestroyListener extends DestroyableEntity {
	void onDestroy(GameField field);
}
