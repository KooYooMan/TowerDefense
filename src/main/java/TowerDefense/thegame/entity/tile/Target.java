package TowerDefense.thegame.entity.tile;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.LivingEntity;

public class Target extends AbstractTile implements LivingEntity {
    long health;
    long maxHealth;
    public Target (double posX, double posY) {
        super(posX, posY, Config.TARGET_WIDTH, Config.TARGET_HEIGHT);
        health = Config.TARGET_HEALTH;
        maxHealth = health;
    }

    @Override
    public long getHealth() {
        return health;
    }

    @Override
    public double getRatioHealth() {
        return (double)health / maxHealth;
    }

    @Override
    public void doEffect (long value) {
        health += value;
    }

    @Override
    public void doDestroy() {
        health = 0;
    }

    @Override
    public boolean isDestroyed() {
        System.out.printf("Health = %d\n", health);
        return health <= 0;
    }
}
