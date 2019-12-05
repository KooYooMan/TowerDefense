package TowerDefense.thegame;


import TowerDefense.thegame.entity.*;

import java.util.*;

/**
 * Game Field. Created from GameMap for each new stage. Represent the currently playing game.
 */
public final class GameField {
    private List<GameEntity> entities;
    private List<GameEntity> spawnEntities = new ArrayList<>();
    private final double width;
    private final double height;
    private GameWave gameWave;
    private GameStage gameStage;

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
        System.out.printf("Size = %d\n", entities.size());
        for (GameEntity entity : this.entities) {
            System.out.printf("%s\n", entity.toString());
        }
        System.out.println();

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
        final List<GameEntity> destroyedEntities = new ArrayList<>();
        for (final GameEntity entity : entities) {
            if (entity instanceof DestroyableEntity && ((DestroyableEntity) entity).isDestroyed()) {
                if (entity instanceof DestroyListener) ((DestroyListener) entity).onDestroy(this);
                destroyedEntities.add(entity);
            }
        }

        //4.Destroy entities
        entities.removeAll(destroyedEntities);

        //5.Destroy out-map entities
        entities.removeIf(entity -> !entity.isBeingOverlapped(0, 0, width, height));

        //6. Spawn Entity
        entities.addAll(spawnEntities);
        spawnEntities.clear();
    }

    public GameStage getGameStage() { return gameStage; }
}
