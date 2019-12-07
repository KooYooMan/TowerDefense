package TowerDefense.thegame.entity.enemy;

import TowerDefense.thegame.Config;

public class SmallerEnemy extends AbstractEnemy{
    public SmallerEnemy(double posX, double posY) {
        super(posX, posY, Config.SMALLER_ENEMY_SIZE, Config.SMALLER_ENEMY_HEALTH, Config.SMALLER_ENEMY_ARMOR, Config.SMALLER_ENEMY_SPEED, Config.SMALLER_ENEMY_REWARD);
//        System.out.printf("%f %f\n", posX, posY);

    }

    @Override
    public String toString() {
        return "SmallerEnemy\n" + getPosX() + " " + getPosY() + " " + super.toString() + "\n";
    }
}
