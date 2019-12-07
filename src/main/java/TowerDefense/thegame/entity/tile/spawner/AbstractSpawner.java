package TowerDefense.thegame.entity.tile.spawner;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.GameField;
import TowerDefense.thegame.GameStage;
import TowerDefense.thegame.entity.DestroyableEntity;
import TowerDefense.thegame.entity.UpdatableEntity;
import TowerDefense.thegame.entity.enemy.AbstractEnemy;
import TowerDefense.thegame.entity.enemy.path.Path;
import TowerDefense.thegame.entity.tile.AbstractTile;
import TowerDefense.utilities.Pair;

import javax.annotation.Nonnull;

public abstract class AbstractSpawner<E extends AbstractEnemy> extends AbstractTile implements UpdatableEntity, DestroyableEntity {
    private final double spawningSize;
    @Nonnull private final Class<E> spawningClass;
    private final long spawnInterval;
    private long tickDown;
    private long numOfSpawn;
    private Path path;
    private int idPath;
    @Override

    public String toString() {
        String spawnerString = tickDown + " " + numOfSpawn + " " + idPath;
        return spawnerString;
    }
    public void setInfo(long tickDown, long numOfSpawn, int idPath) {
        this.tickDown = tickDown;
        this.numOfSpawn = numOfSpawn;
        this.idPath = idPath;
    }
    protected AbstractSpawner(double posX, double posY, double width, double height, double spawningSize, @Nonnull Class<E> spawningClass, long spawnInterval, long initialDelay, long numOfSpawn) {
        super(posX, posY, width, height);
        this.spawningSize = spawningSize;
        this.spawningClass = spawningClass;
        this.spawnInterval = spawnInterval;
        this.tickDown = initialDelay;
        this.numOfSpawn = numOfSpawn;
    }
    public AbstractSpawner setPath (GameStage gameStage, int idPath) {
        this.idPath = idPath;
        this.path = gameStage.getPath(idPath);
        return this;
    }
    public final void onUpdate(@Nonnull GameField field) {
        //System.out.printf("spawn pos = %f %f, size = %f %f, spawningSize = %f, tickdown = %d\n", getPosX(), getPosY(), getWidth(), getHeight(), spawningSize, tickDown);
        this.tickDown -= 1;
        if (tickDown <= 0 && numOfSpawn > 0) {
            numOfSpawn -= 1;
            E newEnemy = doSpawn(getPosX(), getPosY());
            newEnemy.setPath(field.getGameStage(), idPath);
            field.getSpawnEntities().add(newEnemy);
            this.tickDown = spawnInterval;
        }
    }

    @Override
    public void doDestroy() {
        numOfSpawn = 0;
    }

    @Override
    public boolean isDestroyed() {
        return numOfSpawn <= 0;
    }

    @Nonnull
    protected abstract E doSpawn(double posX, double posY);
}
