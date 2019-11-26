package TowerDefense.thegame.entity;

import TowerDefense.thegame.entity.buff.AbstractBuff;

public interface LivingEntity extends DestroyableEntity {
	long getHealth();
	double getRatioHealth();
	void takeDamage(long value);
}
