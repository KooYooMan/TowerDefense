package TowerDefense.thegame.entity.buff;

public class ShootBuff extends AbstractBuff {
    private long damage;

    public ShootBuff(long damage) {
        this.damage = damage;
    }

    public long getDamage() {
        return damage;
    }
}
