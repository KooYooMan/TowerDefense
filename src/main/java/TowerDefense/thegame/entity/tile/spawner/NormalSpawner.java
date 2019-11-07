package TowerDefense.thegame.entity.tile.spawner;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.enemy.NormalEnemy;

import javax.annotation.Nonnull;

public class NormalSpawner extends AbstractSpawner<NormalEnemy> {
    public NormalSpawner(double posX, double posY, long spawnInterval, long initialDelay, long numOfSpawn) {
        super(posX, posY, Config.NORMAL_ENEMY_SIZE, Config.NORMAL_ENEMY_SIZE, Config.NORMAL_ENEMY_SIZE, NormalEnemy.class, spawnInterval, initialDelay, numOfSpawn);
    }
    @Nonnull
    @Override
    protected final NormalEnemy doSpawn(double posX, double posY) {
        return new NormalEnemy(posX, posY);
    }
}
