package TowerDefense.thegame.entity.buff;

import TowerDefense.thegame.entity.BuffedEntity;
import TowerDefense.thegame.entity.LivingEntity;

public abstract class AbstractBuff {
    private long time;

    @Override
    public String toString() {
        return time + "";
    }

    public void setTime(long time) {
        this.time = time;
    }

    public AbstractBuff (long time) {
        this.time = time;
    }
    public boolean isAvailable() {
        return time > 0;
    }
    public void tick() {
        if (time == 0) return;
        time--;
    }
    public void doScale(double scale) {
        time = (long) (time * scale);
    }
    public void stackToOtherBuff (AbstractBuff buff) {
        time += buff.time;
    }
    public long getTime () {
        return time;
    }
}
