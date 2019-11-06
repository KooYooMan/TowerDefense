package TowerDefense.thegame.entity.tower;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.gun.AbstractGun;
import TowerDefense.thegame.entity.bullet.NormalBullet;

public class MachineGunTower extends AbstractTower {
    public MachineGunTower(double posX, double posY, double width, double height, AbstractGun gun) {
        super(posX, posY, width, height, Config.MACHINE_GUN_TOWER_RANGE, Config.MACHINE_GUN_TOWER_SPEED, gun, NormalBullet.class);
    }
}
