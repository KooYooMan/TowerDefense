package TowerDefense.thegame.entity.tile;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.LivingEntity;

public class Target extends AbstractTile implements LivingEntity {
    long health;
    long maxHealth;

    @Override
    public String toString() {
        return "Target\n" + getPosX() + " " + getPosY() + " " + health + " " + maxHealth + "\n";
    }

    public Target (double posX, double posY) {
        super(posX, posY, Config.TARGET_WIDTH, Config.TARGET_HEIGHT);
        health = Config.TARGET_HEALTH;
        maxHealth = health;
    }

    public void setMaxHealth(long maxHealth) {
        this.maxHealth = maxHealth;
    }

    public void setHealth(long health) {
        this.health = health;
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
    public void takeDamage(long value) {
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
