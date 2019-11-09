package TowerDefense.thegame.entity.buff;

import TowerDefense.thegame.entity.BuffedEntity;
import TowerDefense.thegame.entity.LivingEntity;

public abstract class AbstractBuff {
    public void doEffect(BuffedEntity other) {
        other.getBuffed(this);
    }
}
