package TowerDefense.thegame.entity.tower;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.gun.MachineGun;
import TowerDefense.thegame.entity.bullet.NormalBullet;

public class MachineGunTower extends AbstractTower {
    public MachineGunTower(double posX, double posY) {
        super(posX, posY, Config.MACHINE_TOWER_WIDTH, Config.MACHINE_TOWER_HEIGHT, Config.MACHINE_GUN_TOWER_RANGE, Config.MACHINE_GUN_TOWER_SPEED,
                new MachineGun(posX, posY), NormalBullet.class);
    }
}
