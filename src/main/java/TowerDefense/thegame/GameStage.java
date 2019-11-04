package TowerDefense.thegame;

import TowerDefense.thegame.entity.GameEntity;
import TowerDefense.thegame.entity.bullet.ExplodingBullet;
import TowerDefense.thegame.entity.bullet.FastBullet;
import TowerDefense.thegame.entity.bullet.NormalBullet;

import java.util.ArrayList;
import java.util.List;

public final class GameStage {
    private final long width;
    private final long height;
    private final List<GameEntity> entities;

    public GameStage(long width, long height, List<GameEntity> entities) {
        this.width = width;
        this.height = height;
        this.entities = List.copyOf(entities);
    }

    // for testing
    public  GameStage() {
        this.width = 400;
        this.height = 400;
        this.entities = new ArrayList<>();
        this.entities.add(new FastBullet(10, 10, 10, 10));
        this.entities.add(new ExplodingBullet(10, 10, 10, 10));
        this.entities.add(new NormalBullet(10, 10, 10, 10));
    }

    public List<GameEntity> getEntities() {
        return entities;
    }

    public long getWidth() {
        return width;
    }

    public long getHeight() {
        return height;
    }
}
