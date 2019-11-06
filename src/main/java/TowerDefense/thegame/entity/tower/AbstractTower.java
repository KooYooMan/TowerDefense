package TowerDefense.thegame.entity.tower;

import TowerDefense.thegame.GameField;
import TowerDefense.thegame.entity.AbstractEntity;
import TowerDefense.thegame.entity.UpdatableEntity;
import TowerDefense.thegame.entity.bullet.AbstractBullet;

import java.util.ArrayList;
import java.util.List;

public class AbstractTower extends AbstractEntity implements UpdatableEntity {
    private final double range;
    private final long speed;
    private List<Class<? extends AbstractBullet>> bulletList = new ArrayList<Class<? extends AbstractBullet>>();
    private AbstractGun gun;
    private long tick = 0;

    protected AbstractTower(double posX, double posY, double width, double height, double range, long speed, AbstractGun gun,
                            Class<? extends AbstractBullet> bullet) {
        super(posX, posY, width, height);
        this.range = range;
        this.speed = speed;
        this.gun = gun;
        this.bulletList.add(bullet);
    }

    public double getRange() {
        return range;
    }

    public long getSpeed() {
        return speed;
    }

    public AbstractGun getGun() {
        return gun;
    }

    public boolean addBullet(Class<? extends AbstractBullet> other) {
        if (this.bulletList.contains(other)) return false;
        this.bulletList.add(other);
        return true;
    }

    @Override
    public void onUpdate(GameField field) {
        this.tick ++; this.tick %= speed;
    }
}
