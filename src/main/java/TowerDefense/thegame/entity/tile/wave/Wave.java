package TowerDefense.thegame.entity.tile.wave;

import TowerDefense.thegame.GameField;
import TowerDefense.thegame.entity.AbstractEntity;
import TowerDefense.thegame.entity.DestroyableEntity;
import TowerDefense.thegame.entity.GameEntity;
import TowerDefense.thegame.entity.UpdatableEntity;
import TowerDefense.thegame.entity.tile.spawner.AbstractSpawner;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class Wave extends AbstractEntity implements UpdatableEntity, DestroyableEntity {
    int timeToLive;
    List<AbstractSpawner> spawnerList;

    protected Wave(double posX, double posY, double width, double height, int timeToLive) {
        super(posX, posY, width, height);
        this.timeToLive = timeToLive;
        spawnerList = new ArrayList<>();
    }
    void setTimeToLive(int timeToLive) {
        this.timeToLive = timeToLive;
    }
    void addSpawner (AbstractSpawner spawner) {
        spawnerList.add(spawner);
    }

    @Override
    public void onUpdate(@Nonnull  GameField field) {
        timeToLive--;
        for (AbstractSpawner spawner : spawnerList) {
            spawner.onUpdate(field);
        }
    }

    @Override
    public boolean isDestroyed() {
        return timeToLive <= 0;
    }
}
