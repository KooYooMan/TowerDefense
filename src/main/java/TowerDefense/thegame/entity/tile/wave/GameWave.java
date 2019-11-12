package TowerDefense.thegame.entity.tile.wave;

import TowerDefense.thegame.GameField;
import TowerDefense.thegame.entity.AbstractEntity;
import TowerDefense.thegame.entity.DestroyableEntity;
import TowerDefense.thegame.entity.UpdatableEntity;

import java.util.ArrayList;
import java.util.List;

public class GameWave extends AbstractEntity implements UpdatableEntity, DestroyableEntity {
    private int currentWave;
    private List<Wave> waveList;
    public GameWave() {
        super(1, 1, 1, 1);
        currentWave = -1;
        waveList = new ArrayList<>();
    }
    public void addWave(Wave wave) {
        waveList.add(wave);
    }
    @Override
    public void onUpdate(GameField field) {
        if (currentWave == waveList.size()) {
            System.out.println("Spawned everything");
            return;
        }
        if (currentWave == -1 || waveList.get(currentWave).isDestroyed()) {
            currentWave++;
            if (currentWave == waveList.size()) {
                return;
            }
            field.getSpawnEntities().add(waveList.get(currentWave));
            waveList.get(currentWave).spawnSpawner(field);
        }

        waveList.get(currentWave).onUpdate(field);
    }

    @Override
    public boolean isDestroyed() {
        return currentWave >= waveList.size();
    }
}
