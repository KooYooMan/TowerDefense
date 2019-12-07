package TowerDefense.thegame.entity.tile.tower;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.bullet.NormalBullet;
import TowerDefense.thegame.entity.gun.SniperGun;

public class SniperTower extends AbstractTower {
    public static final String NAME = "Sniper Tower";
    public static final long RANGE = (long) Config.SNIPER_TOWER_RANGE / Config.TILE_SIZE;
    public static final long SPEED = Config.SNIPER_TOWER_SPEED;

    public SniperTower(double posX, double posY) {
        super(posX, posY, Config.SNIPER_TOWER_WIDTH, Config.SNIPER_TOWER_HEIGHT,
                Config.SNIPER_TOWER_RANGE, Config.SNIPER_TOWER_SPEED,
                new SniperGun(posX, posY), NormalBullet.class,
                Config.SNIPER_TOWER_BULLET_TIME,
                Config.SNIPER_TOWER_SCALE, Config.SNIPER_TOWER_UPGRADED_SCALE,
                Config.SNIPER_TOWER_COST, Config.SNIPER_TOWER_UPGRADED_COST);
    }
}