package TowerDefense.thegame.entity.tile.spawner;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.enemy.NormalEnemy;

import javax.annotation.Nonnull;

public class NormalSpawner extends AbstractSpawner<NormalEnemy> {
    public NormalSpawner(double posX, double posY) {
        super(posX, posY, Config.NORMAL_ENEMY_SIZE, Config.NORMAL_ENEMY_SIZE, Config.NORMAL_ENEMY_SIZE, NormalEnemy.class,
                          Config.NORMAL_SPAWNINTERVAL, Config.NORMAL_INITDELAY, Config.NORMAL_NUM_OF_SPAWN);
    }
    @Nonnull
    @Override
    protected final NormalEnemy doSpawn(double posX, double posY) {
        return new NormalEnemy(posX, posY);
    }
}
