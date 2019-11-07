package TowerDefense.thegame.entity;

import TowerDefense.thegame.entity.effect.AbstractEffect;

public interface LivingEntity extends DestroyableEntity {
	long getHealth();
	void doEffect(long value);
	void getEffected(AbstractEffect other);
}
