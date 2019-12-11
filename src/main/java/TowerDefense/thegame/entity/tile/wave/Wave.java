package TowerDefense.thegame.entity.tile.wave;

import TowerDefense.thegame.GameField;
import TowerDefense.thegame.entity.AbstractEntity;
import TowerDefense.thegame.entity.DestroyableEntity;
import TowerDefense.thegame.entity.UpdatableEntity;
import TowerDefense.thegame.entity.tile.spawner.AbstractSpawner;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class Wave extends AbstractEntity implements UpdatableEntity, DestroyableEntity {
    private int timeToLive;
    private List<AbstractSpawner> spawnerList;

    @Override
    public String toString() {
        String waveString = "Wave\n" + timeToLive + "\n";
        waveString += spawnerList.size() + "\n";
        for (AbstractSpawner spawner : spawnerList) {
            waveString += spawner.toString();
        }
        return waveString;
    }

    public Wave(int timeToLive) {
        super(1, 1, 1, 1);
        this.timeToLive = timeToLive;
        spawnerList = new ArrayList<>();
    }
    public void setTimeToLive(int timeToLive) {
        this.timeToLive = timeToLive;
    }
    public void addSpawner (AbstractSpawner spawner) {
        spawnerList.add(spawner);
    }
    public void spawnSpawner (@Nonnull GameField field) {
        for (AbstractSpawner spawner : spawnerList) {
            field.getSpawnEntities().add(spawner);
        }
    }
    @Override
    public void onUpdate(@Nonnull  GameField field) {
        timeToLive--;
        if (isSpawned()) timeToLive = Math.min(timeToLive, 600);
        for (AbstractSpawner spawner : spawnerList) {
            spawner.onUpdate(field);
        }
    }

    @Override
    public void doDestroy() {
        timeToLive = 0;
    }

    @Override
    public boolean isDestroyed() {
        return timeToLive <= 0;
    }
    private boolean isSpawned() {
        long maxNumOfSpawn = 0;
        for (int i = 0; i < spawnerList.size(); i++) {
            maxNumOfSpawn = Math.max(maxNumOfSpawn, spawnerList.get(i).getNumOfSpawn());
        }
        if (maxNumOfSpawn == 0) return true;
        return false;
    }

}
