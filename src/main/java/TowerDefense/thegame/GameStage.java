package TowerDefense.thegame;

import TowerDefense.thegame.entity.GameEntity;
import TowerDefense.thegame.entity.bullet.NormalBullet;
import TowerDefense.thegame.entity.tile.Target;
import TowerDefense.thegame.entity.tile.spawner.BossSpawner;
import TowerDefense.thegame.entity.bullet.*;
import TowerDefense.thegame.entity.tile.spawner.NormalSpawner;
import TowerDefense.thegame.entity.tile.spawner.SmallerSpawner;
import TowerDefense.thegame.entity.tile.spawner.TankerSpawner;
import TowerDefense.thegame.entity.tile.spawner.NormalSpawner;
import TowerDefense.thegame.entity.tile.tower.AbstractTower;
import TowerDefense.thegame.entity.tile.tower.MachineGunTower;
import TowerDefense.thegame.entity.tile.tower.NormalTower;
import TowerDefense.thegame.entity.tile.tower.SniperTower;
import TowerDefense.thegame.entity.tile.wave.GameWave;
import TowerDefense.thegame.entity.tile.wave.Wave;

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
        Wave wave = new Wave(5000);
        wave.addSpawner(new NormalSpawner(9 * Config.TILE_SIZE, 1.25 * Config.TILE_SIZE));
        wave.addSpawner(new SmallerSpawner(9 * Config.TILE_SIZE, 1.25 * Config.TILE_SIZE));
        wave.addSpawner(new TankerSpawner(9 * Config.TILE_SIZE, 1.25 * Config.TILE_SIZE));
        //wave.addSpawner(new BossSpawner(9 * Config.TILE_SIZE, 1.25 * Config.TILE_SIZE));

        Wave wave1 = new Wave(2000);
        //wave1.addSpawner(new TankerSpawner(9 * Config.TILE_SIZE, 1.25 * Config.TILE_SIZE));
        wave1.addSpawner(new BossSpawner(9 * Config.TILE_SIZE, 1.0  * Config.TILE_SIZE));




        GameWave gameWave = new GameWave();
        gameWave.addWave(wave);
        gameWave.addWave(wave1);

        this.entities.add(new Target(0 * Config.TILE_SIZE, 8 * Config.TILE_SIZE));
        this.entities.add(gameWave);
        //magic.addBullet(HighDamageBullet.class); magic.addBullet(BurningBullet.class);
        //magic.addBullet(FrozenBullet.class);

//        this.entities.add(foo.getGun());
//        this.entities.add(bar.getGun());
//        for (GameEntity entity : this.entities) {
//            System.out.printf("%s\n", entity.toString());
//        }
//        this.entities.add(foo.getGun());
//        this.entities.add(bar.getGun());
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

    public void addEntity(GameEntity entity) {
        if (entity instanceof AbstractTower) {
            entities.add(entity);
            entities.add(((AbstractTower) entity).getGun());

//            for (GameEntity entity1 : this.entities) {
//                System.out.printf("%s\n", entity1.toString());
//            }
        }
    }

    public GameEntity getGameEntity(int i, int j) {
        for (GameEntity entity : entities) {
            if ((int) entity.getPosY() / Config.TILE_SIZE == i && (int) entity.getPosX() / Config.TILE_SIZE == j) {
                return entity;
            }
        }

        return null;
    }
}
