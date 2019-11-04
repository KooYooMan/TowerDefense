package TowerDefense.thegame.entity.Effect;

public class ShootEffect extends AbstractEffect {
    private long damage;

    public ShootEffect(long damage) {
        this.damage = damage;
    }

    public long getDamage() {
        return damage;
    }
}
