package TowerDefense.thegame;

import TowerDefense.thegame.entity.GameEntity;
import TowerDefense.thegame.entity.bullet.NormalBullet;
import TowerDefense.thegame.entity.tile.spawner.BossSpawner;
import TowerDefense.thegame.entity.bullet.*;
import TowerDefense.thegame.entity.tile.spawner.NormalSpawner;
import TowerDefense.thegame.entity.tile.spawner.SmallerSpawner;
import TowerDefense.thegame.entity.tile.spawner.TankerSpawner;
import TowerDefense.thegame.entity.tile.tower.MachineGunTower;
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
        NormalTower foo = new NormalTower(300, 200);
        MachineGunTower bar = new MachineGunTower(130, 200);
        SniperTower magic = new SniperTower(200, 200);
        this.entities.add(new NormalSpawner(9 * Config.TILE_SIZE, 0.5 * Config.TILE_SIZE));
        this.entities.add(new SmallerSpawner(9 * Config.TILE_SIZE, 0.5 * Config.TILE_SIZE));
        this.entities.add(new TankerSpawner(9 * Config.TILE_SIZE, 0.5 * Config.TILE_SIZE));
        this.entities.add(new BossSpawner(7 * Config.TILE_SIZE, 0.5 * Config.TILE_SIZE));

        this.entities.add(foo);
        this.entities.add(foo.getGun());
        this.entities.add(bar);
        this.entities.add(bar.getGun());
        this.entities.add(magic);
        this.entities.add(magic.getGun());
        //magic.addBullet(HighDamageBullet.class); magic.addBullet(BurningBullet.class);
        magic.addBullet(ExplodingBullet.class); //magic.addBullet(FastBullet.class);
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
}
