package TowerDefense.thegame.entity.effect;

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
