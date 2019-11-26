package TowerDefense.thegame.entity.tile.tower;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.gun.AbstractGun;
import TowerDefense.thegame.entity.bullet.NormalBullet;
import TowerDefense.thegame.entity.gun.SniperGun;
import TowerDefense.thegame.entity.tile.tower.AbstractTower;

public class SniperTower extends AbstractTower {
    public SniperTower(double posX, double posY) {
        super(posX, posY, Config.SNIPER_TOWER_WIDTH, Config.SNIPER_TOWER_HEIGHT, Config.SNIPER_TOWER_RANGE,
                Config.SNIPER_TOWER_SPEED, new SniperGun(posX, posY), NormalBullet.class, Config.SNIPER_TOWER_BULLET_TIME, Config.SNIPER_TOWER_SCALE, Config.SNIPER_TOWER_SCALEFORLEVEL);
    }
}