package TowerDefense.thegame.entity.tile.spawner;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.enemy.BossEnemy;
import TowerDefense.thegame.entity.enemy.NormalEnemy;

import javax.annotation.Nonnull;

public class BossSpawner extends AbstractSpawner {
    public BossSpawner(double posX, double posY) {
        super(posX, posY, Config.BOSS_ENEMY_SIZE, Config.BOSS_ENEMY_SIZE, Config.BOSS_ENEMY_SIZE, BossEnemy.class,
                Config.BOSS_SPAWNINTERVAL, Config.BOSS_INITDELAY, Config.BOSS_NUM_OF_SPAWN);
    }
    @Nonnull
    @Override
    protected final BossEnemy doSpawn(double posX, double posY) {
        return new BossEnemy(posX, posY);
    }

    @Override
    public String toString() {
        return "BossSpawner\n" + getPosX() + " " + getPosY() + " " + super.toString() + "\n";
    }
}
