package TowerDefense.thegame.entity.Tower;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.Gun.AbstractGun;
import TowerDefense.thegame.entity.Gun.NormalGun;
import TowerDefense.thegame.entity.bullet.AbstractBullet;
import TowerDefense.thegame.entity.bullet.NormalBullet;

public class NormalTower extends AbstractTower {
    public NormalTower(double posX, double posY, double width, double height) {
        super(posX, posY, width, height, Config.NORMAL_TOWER_RANGE, Config.NORMAL_TOWER_SPEED,
                new NormalGun(posX, posY), NormalBullet.class);
    }
}
