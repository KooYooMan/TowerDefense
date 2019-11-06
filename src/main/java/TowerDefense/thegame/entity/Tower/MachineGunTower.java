package TowerDefense.thegame.entity.Tower;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.Gun.AbstractGun;
import TowerDefense.thegame.entity.bullet.AbstractBullet;
import TowerDefense.thegame.entity.bullet.NormalBullet;

public class MachineGunTower extends AbstractTower {
    public MachineGunTower(double posX, double posY, double width, double height, AbstractGun gun) {
        super(posX, posY, width, height, Config.MACHINE_GUN_TOWER_RANGE, Config.MACHINE_GUN_TOWER_SPEED, gun, NormalBullet.class);
    }
}
