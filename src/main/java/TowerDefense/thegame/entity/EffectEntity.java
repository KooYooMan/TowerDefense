package TowerDefense.thegame.entity;

import TowerDefense.thegame.GameField;

public interface EffectEntity extends DestroyableEntity{
	boolean onEffect(GameField field, LivingEntity livingEntity);
}
