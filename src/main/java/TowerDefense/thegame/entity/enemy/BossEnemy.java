package TowerDefense.thegame.entity.enemy;

import TowerDefense.thegame.Config;

public class BossEnemy extends AbstractEnemy {
    public BossEnemy(double posX, double posY) {
        super(posX, posY, Config.BOSS_ENEMY_SIZE, Config.BOSS_ENEMY_HEALTH, Config.BOSS_ENEMY_ARMOR, Config.BOSS_ENEMY_SPEED, Config.BOSS_ENEMY_REWARD);
//        System.out.printf("%f %f\n", posX, posY);

    }

    @Override
    public String toString() {
        return "BossEnemy " + getPosX() + " " + getPosY() + " " + super.toString();
    }
}
