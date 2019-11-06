package TowerDefense.thegame.entity.effect;

import TowerDefense.thegame.entity.LivingEntity;

public abstract class AbstractEffect {
    public void doEffect(LivingEntity other) {
        other.getEffected(this);
    }
}
