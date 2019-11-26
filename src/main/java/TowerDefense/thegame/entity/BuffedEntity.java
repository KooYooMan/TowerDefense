package TowerDefense.thegame.entity;

import TowerDefense.thegame.entity.buff.AbstractBuff;

public interface BuffedEntity extends LivingEntity {
    void getBuffed(AbstractBuff other);

}
