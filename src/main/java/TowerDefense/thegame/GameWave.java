package TowerDefense.thegame;

import TowerDefense.thegame.entity.AbstractEntity;
import TowerDefense.thegame.entity.DestroyableEntity;
import TowerDefense.thegame.entity.UpdatableEntity;
import TowerDefense.thegame.entity.tile.wave.Wave;
import TowerDefense.thegame.sound.GameSound;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GameWave extends AbstractEntity implements UpdatableEntity, DestroyableEntity {
    private int currentWaveID;
    private List<Wave> waveList;
    boolean hasSpawned;

    @Override
    public String toString() {
        String gameWaveString = "GameWave\n" + currentWaveID + "\n";
        gameWaveString += waveList.size() + "\n";
        for (Wave wave : waveList) {
            gameWaveString += wave.toString();
        }
        return gameWaveString;
    }

    public GameWave() {
        super(1, 1, 1, 1);
        currentWaveID = -1;
        waveList = new ArrayList<>();
    }
    public void setCurrentWaveID(int currentWaveID) {
        this.currentWaveID = currentWaveID;
    }

    public int getCurrentWaveID() {
        return currentWaveID;
    }
    public int getNumberWave() { return waveList.size(); }
    public void addWave(Wave wave) {
        waveList.add(wave);
    }
    public void nextWave (Wave wave) {
        waveList.get(currentWaveID).doDestroy();
    }
    @Override
    public void onUpdate(GameField field) {
        if (currentWaveID == waveList.size()) {
            System.out.println("Spawned everything");
            return;
        }
        System.out.println(currentWaveID);
        if (currentWaveID == -1 || waveList.get(currentWaveID).isDestroyed()) {
            currentWaveID++;
            System.out.println(currentWaveID);
            if (currentWaveID == waveList.size()) {
                return;
            }
            GameSound.playSpawning();

            Wave currentWave = waveList.get(currentWaveID);
            field.getSpawnEntities().add(currentWave);
            currentWave.spawnSpawner(field);
        }
        Wave currentWave = waveList.get(currentWaveID);
        currentWave.onUpdate(field);
    }

    @Override
    public void doDestroy() {
        currentWaveID = waveList.size();
    }

    @Override
    public boolean isDestroyed() {
        return currentWaveID >= waveList.size();
    }
}
