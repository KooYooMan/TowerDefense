package TowerDefense.thegame.entity.tile;

import TowerDefense.thegame.Config;

public class Target extends AbstractTile implements LivingEntity {
    long health;
    public Target (double posX, double posY) { super(posX, posY, Config.TARGET_WIDTH, Config.TARGET_HEIGHT); }

    @Override
    public long getHealth() {
        return health;
    }

    @Override
    public void doEffect(long value) {
        health += value;
    }



    @Override
    public boolean isDestroyed() {
        return false;
    }
}
