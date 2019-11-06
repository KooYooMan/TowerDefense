package TowerDefense.thegame.entity;

import TowerDefense.thegame.entity.effect.AbstractEffect;

public interface LivingEntity extends DestroyableEntity {
	long getHealth();
	void getEffected(AbstractEffect other);
}
