package TowerDefense.thegame.entity.tile.spawner;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.enemy.NormalEnemy;
import TowerDefense.thegame.entity.enemy.SmallerEnemy;
import TowerDefense.thegame.entity.enemy.TankerEnemy;

import javax.annotation.Nonnull;

public class SmallerSpawner extends AbstractSpawner {
    public SmallerSpawner(double posX, double posY) {
        super(posX, posY, Config.SMALLER_ENEMY_SIZE, Config.SMALLER_ENEMY_SIZE, Config.SMALLER_ENEMY_SIZE, SmallerEnemy.class,
                Config.SMALLER_SPAWNINTERVAL, Config.SMALLER_INITDELAY, Config.SMALLER_NUM_OF_SPAWN);
    }
    @Nonnull
    @Override
    protected final SmallerEnemy doSpawn(double posX, double posY) {
        return new SmallerEnemy(posX, posY);
    }

}
