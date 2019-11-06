package TowerDefense.thegame.entity.Effect;

public class BurningEffect extends AbstractEffect {
    private long damage;
    private long timeBurning;

    public BurningEffect(long damage, long timeBurning) {
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
