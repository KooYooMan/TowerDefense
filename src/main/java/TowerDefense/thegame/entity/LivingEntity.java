package TowerDefense.thegame.entity;

import TowerDefense.thegame.entity.Effect.AbstractEffect;

public interface LivingEntity extends DestroyableEntity {
	long getHealth();
	void getEffected(AbstractEffect other);
}
