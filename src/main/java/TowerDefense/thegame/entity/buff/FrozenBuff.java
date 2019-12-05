package TowerDefense.thegame.entity.buff;

import TowerDefense.thegame.Config;

public class FrozenBuff extends AbstractBuff {
    private double speedDown;

    @Override
    public String toString() {
        return "FrozenBuff " + speedDown + " " + super.toString();
    }

    public FrozenBuff() {
        super(Config.FROZEN_BUFF_TIME);
        this.speedDown = Config.FROZEN_BUFF_SPEED_DOWN;
    }
    public void setSpeedDown(double speedDown) {
        this.speedDown = speedDown;

    }
    @Override
    public void stackToOtherBuff(AbstractBuff buff) {
        super.stackToOtherBuff(buff);
        if (isAvailable()) {
            speedDown = Math.min(speedDown, ((FrozenBuff) buff).getSpeedDown());
        }
        else {
            speedDown = ((FrozenBuff) buff).getSpeedDown();
        }

    }

    public double getSpeedDown() {
        return this.speedDown;
    }
    public double getRealSpeedDown() {
        if (!isAvailable()) return 1;
        return this.speedDown;
    }

    @Override
    public void doScale(double scale) {
        super.doScale(scale);
        speedDown /= scale;
    }
}
