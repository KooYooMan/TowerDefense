package TowerDefense.thegame.entity.buff;

import TowerDefense.thegame.Config;

public class BurningBuff extends AbstractBuff {
    private long damage, damageInterval;

    @Override
    public String toString() {
        return damage + " " + damageInterval + " " + super.toString();
    }

    public BurningBuff() {
        super(Config.BURNING_BUFF_TIME);
        this.damage = Config.BURNING_BUFF_DAMAGE;
        this.damageInterval = Config.BURNING_BUFF_DAMAGE_INTERVAL;
    }
    public void setDamage(long damage) {
        this.damage = damage;
    }
    public long getDamage() {
        return this.damage;
    }
    public long getDamageInterval() { return this.damageInterval; }

    @Override
    public void stackToOtherBuff(AbstractBuff otherBuff) {
        super.stackToOtherBuff(otherBuff);
        if (isAvailable()) {
            damage = Math.max(damage, ((BurningBuff) otherBuff).getDamage());
        }
        else {
            damage = ((BurningBuff) otherBuff).getDamage();
        }

    }

    public long getRealDamage() { /// get damage when it run a cycle;
        if (!isAvailable()) {
            return 0;
        }
        if (getTime() % damageInterval != 0) {
            return 0;
        }
        return damage;
    }

    @Override
    public void doScale(double scale) {
        super.doScale(scale);
        damage *= scale;
    }
}
