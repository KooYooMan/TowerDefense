package TowerDefense.thegame.entity.enemy;

import TowerDefense.thegame.Config;

public class NormalEnemy extends AbstractEnemy {
    public NormalEnemy(double posX, double posY) {
        super(posX, posY, Config.NORMAL_ENEMY_SIZE, Config.NORMAL_ENEMY_HEALTH, Config.NORMAL_ENEMY_ARMOR, Config.NORMAL_ENEMY_SPEED, Config.NORMAL_ENEMY_REWARD);
        System.out.printf("%f %f\n", posX, posY);

    }
}
