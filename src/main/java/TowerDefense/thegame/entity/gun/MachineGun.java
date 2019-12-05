package TowerDefense.thegame.entity.gun;

import TowerDefense.thegame.Config;

public class MachineGun extends AbstractGun {
    public MachineGun(double posX, double posY) {
        super(posX, posY, Config.MACHINE_GUN_WIDTH, Config.MACHINE_GUN_HEIGHT);
    }

}
