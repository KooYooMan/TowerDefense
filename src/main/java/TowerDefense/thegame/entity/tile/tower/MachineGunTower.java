package TowerDefense.thegame.entity.tile.tower;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.gun.AbstractGun;
import TowerDefense.thegame.entity.bullet.NormalBullet;
import TowerDefense.thegame.entity.gun.MachineGun;
import TowerDefense.thegame.entity.tile.tower.AbstractTower;

public class MachineGunTower extends AbstractTower {
    public MachineGunTower(double posX, double posY) {
        super(posX, posY, Config.MACHINE_TOWER_WIDTH, Config.MACHINE_TOWER_HEIGHT, Config.MACHINE_GUN_TOWER_RANGE, Config.MACHINE_GUN_TOWER_SPEED,
                new MachineGun(posX, posY), NormalBullet.class, Config.MACHINE_GUN_TOWER_BULLET_TIME, Config.MACHINE_TOWER_SCALE, Config.MACHINE_TOWER_SCALEFORLEVEL);
    }
}

