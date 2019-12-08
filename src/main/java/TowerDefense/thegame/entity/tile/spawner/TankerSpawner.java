package TowerDefense.thegame.entity.tile.spawner;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.enemy.NormalEnemy;
import TowerDefense.thegame.entity.enemy.TankerEnemy;

import javax.annotation.Nonnull;

public class TankerSpawner extends AbstractSpawner {
    public TankerSpawner(double posX, double posY) {
        super(posX, posY, Config.TANKER_ENEMY_SIZE, Config.TANKER_ENEMY_SIZE, Config.TANKER_ENEMY_SIZE, TankerEnemy.class,
                Config.TANKER_SPAWNINTERVAL, Config.TANKER_INITDELAY, Config.TANKER_NUM_OF_SPAWN);
    }
    @Nonnull
    @Override
    protected final TankerEnemy doSpawn(double posX, double posY) {
        return new TankerEnemy(posX, posY);
    }

    @Override
    public String toString() {
        return "TankerSpawner\n" + getPosX() + " " + getPosY() + " " + super.toString() + "\n";
    }
}
