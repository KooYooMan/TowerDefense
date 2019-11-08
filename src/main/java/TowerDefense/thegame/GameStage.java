package TowerDefense.thegame;

import TowerDefense.thegame.entity.GameEntity;
import TowerDefense.thegame.entity.tile.spawner.NormalSpawner;
import TowerDefense.thegame.entity.tile.tower.NormalTower;
import TowerDefense.thegame.entity.enemy.NormalEnemy;
import TowerDefense.thegame.entity.tile.tower.SniperTower;

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
        this.width = Config.SCREEN_WIDTH;
        this.height = Config.SCREEN_HEIGHT;
        this.entities = new ArrayList<>();
//        NormalTower foo = new NormalTower(100.0, 70.0);
//        MachineGunTower bar = new MachineGunTower(50.0, 50.0);
        SniperTower magic = new SniperTower(200, 200);
        this.entities.add(magic);
        this.entities.add(new NormalSpawner(9 * Config.TILE_SIZE, 1.5 * Config.TILE_SIZE, 100, 100, 10));
//        NormalTower foo = new NormalTower(100.0, 70.0);
//        NormalTower bar = new NormalTower(50.0, 50.0);



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
