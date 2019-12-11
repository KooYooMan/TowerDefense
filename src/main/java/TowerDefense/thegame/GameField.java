package TowerDefense.thegame;


import TowerDefense.thegame.entity.*;
import TowerDefense.thegame.entity.enemy.AbstractEnemy;
import TowerDefense.thegame.entity.tile.Target;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.*;

/**
 * Game Field. Created from GameMap for each new stage. Represent the currently playing game.
 */
public final class GameField {
    private List<GameEntity> entities;
    private List<GameEntity> spawnEntities = new ArrayList<>();
    private List<GameEntity> destroyedEntities = new ArrayList<>();
    private final double width;
    private final double height;
    private GameWave gameWave;
    private GameStage gameStage;
    int state = 0;
    private void checkWin() {
        for (GameEntity e : entities) {
            if (e instanceof AbstractEnemy) {
                return;
            }
        }
        for (GameEntity e : spawnEntities) {
            if (e instanceof AbstractEnemy) {
                return;
            }
        }
        if (!gameWave.isDestroyed()) {
            return;
        }
        if (state == 0) {
            state = 1;
        }
    }
    private void checkLose() {
        for (GameEntity e : destroyedEntities) {
            if (e instanceof Target) {
                if (state == 0) state = 2;
                return;
            }
        }
    }
    public boolean isPlaying() {
        return state == 0;
    }
    public boolean isWin() {
        return state == 1;
    }
    public boolean isLose() {
        return state == 2;
    }
    @Override
    public String toString() {
        String gameFieldString = gameStage.toString();

        return gameFieldString;
    }

    public GameField(GameStage gameStage) {
        this.gameStage = gameStage;
        this.width = gameStage.getWidth();
        this.height = gameStage.getHeight();
        this.entities = gameStage.getEntities();
        this.gameWave = gameStage.getGameWave();
    }

    public List<GameEntity> getEntities() { return entities; }

    public List<GameEntity> getSpawnEntities() {
        return spawnEntities;
    }

    public GameWave getGameWave() {
        return gameWave;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public final void handle() {

//        //4.Destroy entities
//        if (!destroyedEntities.isEmpty()) {
//            MediaPlayer soundHit = new MediaPlayer(new Media(new File(Config.ENEMY_HIT_SOUND_PATH).toURI().toString()));
//            soundHit.play();
//        }
        entities.removeAll(destroyedEntities);

        //5.Destroy out-map entities
        entities.removeIf(entity -> !entity.isBeingOverlapped(0, 0, width, height));

        //6. Spawn Entity
        entities.addAll(spawnEntities);
        spawnEntities.clear();

        //1.Update UpdatableEntity
        for (final GameEntity entity : entities) {
            if (entity instanceof UpdatableEntity) {
                ((UpdatableEntity) entity).onUpdate(this);
            }
        }

        //2.Update EffectEntity & Living Entity
        for (final GameEntity entity : entities) {
            if (entity instanceof EffectEntity) {
                final EffectEntity effectEntity = (EffectEntity) entity;
                final Collection<LivingEntity> livingEntities = GameEntities.getAffectedEntities(entities,
                        effectEntity.getClass(), entity.getPosX(), entity.getPosY(), entity.getWidth(), entity.getHeight());
                for (final LivingEntity livingEntity : livingEntities) {
                    if (!effectEntity.onEffect(this, livingEntity)) break;
                }
            }
        }
        //3.Update Destroyable Entity
        for (final GameEntity entity : entities) {
            if (entity instanceof DestroyableEntity && ((DestroyableEntity) entity).isDestroyed()) {
                if (entity instanceof DestroyListener) ((DestroyListener) entity).onDestroy(this);
                destroyedEntities.add(entity);
            }
        }

        checkLose();
        checkWin();
    }

    public GameStage getGameStage() { return gameStage; }
}
