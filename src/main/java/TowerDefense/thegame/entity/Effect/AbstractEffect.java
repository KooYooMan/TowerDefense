package TowerDefense.thegame.entity.Effect;

import TowerDefense.thegame.entity.LivingEntity;

public abstract class AbstractEffect {
    public void doEffect(LivingEntity other) {
        other.getEffected(this);
    }
}
