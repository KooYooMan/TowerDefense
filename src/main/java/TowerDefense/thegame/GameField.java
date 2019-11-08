package TowerDefense.thegame;


import TowerDefense.thegame.entity.*;
import TowerDefense.thegame.entity.tile.spawner.NormalSpawner;

import java.util.*;

/**
 * Game Field. Created from GameMap for each new stage. Represent the currently playing game.
 */
public final class GameField {
    private final Set<GameEntity> entities = new LinkedHashSet<>();

    private final double width;
    private final double height;

    public GameField(GameStage gameStage) {
        this.width = gameStage.getWidth();
        this.height = gameStage.getHeight();
        entities.addAll(gameStage.getEntities());
    }

    public Set<GameEntity> getEntities() {
        return entities;
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

        //1.Update UpdatableEntity
        for (final GameEntity entity : entities) {
            if (entity instanceof UpdatableEntity) ((UpdatableEntity) entity).onUpdate(this);
        }
        //2.Update EffectEntity & Living Entity

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
    }

}
