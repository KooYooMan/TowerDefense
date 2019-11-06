package TowerDefense.thegame.entity.tower;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.gun.AbstractGun;
import TowerDefense.thegame.entity.bullet.NormalBullet;

public class SniperTower extends AbstractTower {
    public SniperTower(double posX, double posY, double width, double height, AbstractGun gun) {
        super(posX, posY, width, height, Config.SNIPER_TOWER_RANGE, Config.SNIPER_TOWER_SPEED, gun, NormalBullet.class);
    }
}
