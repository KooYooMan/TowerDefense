package TowerDefense.thegame.entity.tower;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.gun.SniperGun;
import TowerDefense.thegame.entity.bullet.NormalBullet;

public class SniperTower extends AbstractTower {
    public SniperTower(double posX, double posY) {
        super(posX, posY, Config.SNIPER_TOWER_WIDTH, Config.SNIPER_GUN_HEIGHT, Config.SNIPER_TOWER_RANGE, Config.SNIPER_TOWER_SPEED,
                new SniperGun(posX, posY), NormalBullet.class);
    }
}
