package TowerDefense.thegame.entity.tile.wave;

import TowerDefense.thegame.GameField;
import TowerDefense.thegame.entity.AbstractEntity;
import TowerDefense.thegame.entity.UpdatableEntity;

import java.util.ArrayList;
import java.util.List;

public class GameWave extends AbstractEntity implements UpdatableEntity {
    int currentWave;
    List<Wave> waveList;
    protected GameWave(double posX, double posY, double width, double height) {
        super(posX, posY, width, height);
        currentWave = 0;
        waveList = new ArrayList<>();
    }

    @Override
    public void onUpdate(GameField field) {
        if (currentWave == waveList.size()) {
            System.out.println("Spawned everything");
            return;
        }
        if (waveList.get(currentWave).isDestroyed()) {
            currentWave++;
        }
        if (currentWave == waveList.size()) {
            return;
        }
        waveList.get(currentWave).onUpdate(field);
    }
}
