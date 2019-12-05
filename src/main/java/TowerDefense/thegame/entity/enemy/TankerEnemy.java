package TowerDefense.thegame.entity.enemy;

import TowerDefense.thegame.Config;

public class TankerEnemy extends AbstractEnemy{
    public TankerEnemy(double posX, double posY) {
        super(posX, posY, Config.TANKER_ENEMY_SIZE, Config.TANKER_ENEMY_HEALTH, Config.TANKER_ENEMY_ARMOR, Config.TANKER_ENEMY_SPEED, Config.TANKER_ENEMY_REWARD);
//        System.out.printf("%f %f\n", posX, posY);

    }

    @Override
    public String toString() {
        return "TankerEnemy " + getPosX() + " " + getPosY() + " " +  super.toString();
    }
}
