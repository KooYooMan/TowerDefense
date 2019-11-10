package TowerDefense.thegame.entity.buff;

public class BurningBuff extends AbstractBuff {
    private long damage;
    private long timeBurning;

    public BurningBuff(long damage, long timeBurning) {
        this.damage = damage;
        this.timeBurning = timeBurning;
    }

    public long getDamage() {
        return this.damage;
    }

    public long getTimeBurning() {
        return this.timeBurning;
    }
}
