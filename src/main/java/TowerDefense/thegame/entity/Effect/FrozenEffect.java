package TowerDefense.thegame.entity.Effect;

public class FrozenEffect extends AbstractEffect {
    private double speedFrozen;
    private long timeFronzen;

    public FrozenEffect(double speedFrozen, long timeFronzen) {
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
