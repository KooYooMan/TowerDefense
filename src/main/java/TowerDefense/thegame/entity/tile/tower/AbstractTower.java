package TowerDefense.thegame.entity.tile.tower;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.GameField;
import TowerDefense.thegame.entity.AbstractEntity;
import TowerDefense.thegame.entity.GameEntity;
import TowerDefense.thegame.entity.UpdatableEntity;
import TowerDefense.thegame.entity.UpgradableEntity;
import TowerDefense.thegame.entity.bullet.AbstractBullet;
import TowerDefense.thegame.entity.bullet.BurningBullet;
import TowerDefense.thegame.entity.bullet.FrozenBullet;
import TowerDefense.thegame.entity.bullet.NormalBullet;
import TowerDefense.thegame.entity.enemy.AbstractEnemy;
import TowerDefense.thegame.entity.gun.AbstractGun;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AbstractTower extends AbstractEntity implements UpgradableEntity, UpdatableEntity {
    private final double range;
    private final long speed;
    private List<Class<? extends AbstractBullet>> bulletClassList = new ArrayList<>();
    private List<AbstractBullet> bulletList = new ArrayList<>();
    private AbstractGun gun;
    private long tick = 0;
    private int bulletTime;
    private int level;
    private double scale;
    private double upgradedScale;
    private long cost;
    private long upgradedCost;
    private final Class<?>[] cArg = new Class<?>[]{double.class, double.class, double.class, double.class, double.class, double.class};

    protected AbstractTower(double posX, double posY, double width, double height, double range, long speed, AbstractGun gun,
                            Class<? extends AbstractBullet> bullet, int bulletTime, double scale, double upgradeScale, long cost, long upgradedCost) {
        super(posX, posY, width, height);
        this.range = range;
        this.speed = speed;
        this.gun = gun;
        this.bulletTime = bulletTime;
        this.level = 1;
        this.scale = scale;
        this.upgradedScale = upgradeScale;
        this.cost = cost;
        this.upgradedCost = upgradedCost;
    }

    public long getCost() {
        return cost;
    }
    public long getSoldCost() {
        return cost / 2;

    }
    public long getUpgradedCost() {
        return upgradedCost;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public void upgrade() {
        cost += upgradedCost;
        scale *= upgradedScale;
        level++;
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
        if (this.bulletClassList.contains(other)) return false;
        this.bulletClassList.add(other);
        if (other == FrozenBullet.class) {
            cost += Config.FROZEN_BULLET_COST;
        }
        if (other == NormalBullet.class) {
            cost += Config.NORMAL_BULLET_COST;
        }
        if (other == BurningBullet.class) {
            cost += Config.BURNING_BULLET_COST;
        }

        return true;
    }

    double Distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    @Override
    public void onUpdate(GameField field) {
        if (this.tick != 0) {
            this.tick ++;
            if (this.tick >= speed) this.tick -= speed;
        }
        if (this.tick != 0) return;
        double centerX = this.getPosX() + this.getWidth() / 2, centerY = this.getPosY() + this.getHeight() / 2;
        double targetX = 0, targetY = 0, distance = Double.MAX_VALUE;
        for (GameEntity entity : field.getEntities()) {
            if (!(entity instanceof AbstractEnemy)) continue;
            double centerEnemyX = entity.getPosX() + entity.getWidth() / 2;
            double centerEnemyY = entity.getPosY() + entity.getHeight() / 2;
            double thisDistance = Distance(centerX, centerY, centerEnemyX, centerEnemyY);
            if (thisDistance < distance) {
                distance = thisDistance;
                targetX = centerEnemyX;
                targetY = centerEnemyY;
            }
        }
        if (distance == Double.MAX_VALUE) return;
        if (distance > range) return;
        this.tick ++;
        long len = bulletClassList.size();
        int id = new Random().nextInt((int) len);
        //System.out.println(id);
        try {
            field.getSpawnEntities().add(bulletClassList.get(id).getDeclaredConstructor(cArg)
                    .newInstance(centerX, centerY, targetX - centerX, targetY - centerY, range, scale));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.gun.update(targetX - centerX,  centerY - targetY);
    }


}

