package TowerDefense.thegame;

import TowerDefense.thegame.entity.GameEntity;
import TowerDefense.thegame.entity.bullet.NormalBullet;
import TowerDefense.thegame.entity.tile.spawner.NormalSpawner;
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
        this.width = 400;
        this.height = 400;
        this.entities = new ArrayList<>();
        NormalTower foo = new NormalTower(300, 300);
        MachineGunTower bar = new MachineGunTower(300, 300);
        SniperTower magic = new SniperTower(300, 300);
        this.entities.add(new NormalSpawner(200.0, 200.0, 100, 100, 10));

        this.entities.add(foo);
        this.entities.add(bar);
        this.entities.add(magic);
        this.entities.add(foo.getGun());
        this.entities.add(bar.getGun());
        this.entities.add(magic.getGun());

//        this.entities.add(foo.getGun());
//        this.entities.add(bar.getGun());
        this.entities.add(new NormalEnemy(100, 100));
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
