package TowerDefense.thegame.entity.tile.tower;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.gun.NormalGun;
import TowerDefense.thegame.entity.bullet.NormalBullet;

public class NormalTower extends AbstractTower {
    public NormalTower(double posX, double posY) {
        super(posX, posY, Config.NORMAL_TOWER_WIDTH, Config.NORMAL_TOWER_HEIGHT, Config.NORMAL_TOWER_RANGE, Config.NORMAL_TOWER_SPEED,
                new NormalGun(posX, posY), NormalBullet.class);
    }
}
