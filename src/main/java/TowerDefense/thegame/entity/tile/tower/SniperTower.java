package TowerDefense.thegame.entity.tile.tower;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.bullet.NormalBullet;
import TowerDefense.thegame.entity.gun.SniperGun;

public class SniperTower extends AbstractTower {
    public SniperTower(double posX, double posY) {
        super(posX, posY, Config.SNIPER_TOWER_WIDTH, Config.SNIPER_TOWER_HEIGHT,
                Config.SNIPER_TOWER_RANGE, Config.SNIPER_TOWER_SPEED,
                new SniperGun(posX, posY), NormalBullet.class,
                Config.SNIPER_TOWER_BULLET_TIME,
                Config.SNIPER_TOWER_SCALE, Config.SNIPER_TOWER_UPGRADED_SCALE,
                Config.SNIPER_TOWER_COST, Config.SNIPER_TOWER_UPGRADED_COST);
    }
    public String toString() {
        return "SniperTower\n" + getPosX() + " " + getPosY() + " " + super.toString();
    }
}