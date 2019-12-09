package TowerDefense.thegame;

import TowerDefense.thegame.entity.GameEntity;
import TowerDefense.thegame.entity.tile.Target;
import TowerDefense.thegame.entity.tile.spawner.BossSpawner;
import TowerDefense.thegame.entity.tile.spawner.NormalSpawner;
import TowerDefense.thegame.entity.tile.spawner.SmallerSpawner;
import TowerDefense.thegame.entity.tile.spawner.TankerSpawner;
import TowerDefense.thegame.entity.tile.tower.AbstractTower;
import TowerDefense.thegame.entity.tile.wave.Wave;

import java.util.ArrayList;
import java.util.List;

public final class GameStage {
    private final long width;
    private final long height;
    private final Target target;
    private final List<GameEntity> entities;
    private final GameWave gameWave = new GameWave();
    private long money;

    public GameStage(long width, long height, List<GameEntity> entities) {
        this.width = width;
        this.height = height;
        this.target = null;
        this.entities = List.copyOf(entities);
    }

    // for testing
    public GameStage() {
        this.money = 420L;

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

        gameWave.addWave(wave);
        gameWave.addWave(wave1);

        this.target = new Target(0 * Config.TILE_SIZE, 8 * Config.TILE_SIZE);
        this.entities.add(this.target);
        this.entities.add(gameWave);
    }

    public Target getTarget() { return target; }
    public GameWave getGameWave() { return gameWave; }
    public List<GameEntity> getEntities() {
        return entities;
    }

    public long getWidth() {
        return width;
    }

    public long getHeight() {
        return height;
    }

    public boolean addEntity(GameEntity entity) {
        if (entity instanceof AbstractTower) {
            if (money >= ((AbstractTower) entity).getCost()) {
                entities.add(entity);
                entities.add(((AbstractTower) entity).getGun());

                money -= ((AbstractTower) entity).getCost();
                if (money <= 0L) {
                    money = 0L;
                }

                return true;
            }
            return false;
        }
        return false;
    }

    public void removeEntity(GameEntity entity) {
        if (entity instanceof AbstractTower) {
            entities.remove(entity);
            entities.remove(((AbstractTower) entity).getGun());

            money += ((AbstractTower) entity).getSoldCost();
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

    public long getMoney() { return money; }

    public void addMoney(long add) { money += add; }
    public void reduceMoney(long reduce) {
        money -= reduce;

        if (money <= 0L) {
            money = 0L;
        }
    }
}
