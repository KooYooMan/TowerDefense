package TowerDefense.thegame.entity.buff;

public class FrozenBuff extends AbstractBuff {
    private double speedFrozen;
    private long timeFronzen;

    public FrozenBuff(double speedFrozen, long timeFronzen) {
        this.speedFrozen = speedFrozen;
        this.timeFronzen = timeFronzen;
    }

    public double getSpeedFrozen() {
        return this.speedFrozen;
    }

    public long getTimeFronzen() {
        return this.timeFronzen;
    }
}
