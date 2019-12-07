package TowerDefense.thegame;

import TowerDefense.thegame.entity.GameEntity;
import TowerDefense.thegame.entity.enemy.*;
import TowerDefense.thegame.entity.enemy.path.Path;
import TowerDefense.thegame.entity.tile.Target;
import TowerDefense.thegame.entity.tile.spawner.*;
import TowerDefense.thegame.entity.tile.tower.AbstractTower;
import TowerDefense.thegame.entity.tile.wave.Wave;
import TowerDefense.utilities.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class GameStage {
    private final long width;
    private final long height;
    private final List<GameEntity> entities;
    private final GameWave gameWave = new GameWave();
    private long money;
    private Path[] enemyPath = new Path[Config.MAX_PATH];
    public String toString() {
        String gameStageString = new String();

        gameStageString += width + " " + height + " " + money + "\n";
        for (int i = 0; i < Config.MAX_PATH; i++) {
            if (enemyPath[i] != null) {
                gameStageString += enemyPath[i].toString();
            }
        }
        gameStageString += gameWave.toString();
        gameStageString += "entities\n";
        gameStageString += entities.size() + "\n";
        for (GameEntity ge : entities) {
            if (ge instanceof GameWave) {
                continue;
            }
            gameStageString += ge.toString();
        }
        return gameStageString;
    }

    public Path[] getEnemyPath() {
        return enemyPath;
    }
    public Path getPath(int id) {
        return enemyPath[id];
    }
    public GameStage(long width, long height, List<GameEntity> entities) {
        this.width = width;
        this.height = height;
        this.entities = List.copyOf(entities);
    }
    // for testing
    public GameStage() {
        this.money = 420L;

        this.width = Config.SCREEN_WIDTH;
        this.height = Config.SCREEN_HEIGHT;
        this.entities = new ArrayList<>();
        Wave wave = new Wave(5000);
        wave.addSpawner(new NormalSpawner(9 * Config.TILE_SIZE, 1.25 * Config.TILE_SIZE).setPath(this, 0));
        wave.addSpawner(new SmallerSpawner(9 * Config.TILE_SIZE, 1.25 * Config.TILE_SIZE).setPath(this, 0));
        wave.addSpawner(new TankerSpawner(9 * Config.TILE_SIZE, 1.25 * Config.TILE_SIZE).setPath(this, 0));
        //wave.addSpawner(new BossSpawner(9 * Config.TILE_SIZE, 1.25 * Config.TILE_SIZE));

        Wave wave1 = new Wave(2000);
        //wave1.addSpawner(new TankerSpawner(9 * Config.TILE_SIZE, 1.25 * Config.TILE_SIZE));
        wave1.addSpawner(new BossSpawner(9 * Config.TILE_SIZE, 1.0  * Config.TILE_SIZE).setPath(this, 0));

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
        enemyPath[0] = new Path();
        enemyPath[0].addInstruction(Pair.immutableOf(8.0 * Config.TILE_SIZE, 2));
        enemyPath[0].addInstruction(Pair.immutableOf(4.0 * Config.TILE_SIZE, 1));
        enemyPath[0].addInstruction(Pair.immutableOf(6.0 * Config.TILE_SIZE, 3));
        enemyPath[0].addInstruction(Pair.immutableOf(3.0 * Config.TILE_SIZE, 1));
        enemyPath[0].addInstruction(Pair.immutableOf(10.0 * Config.TILE_SIZE, 2));
    }
    public GameStage(String filePath) {
        filePath = Config.SAVE_FOLDER + filePath;
        File file = new File(filePath);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.width = sc.nextLong();
        this.height = sc.nextLong();
        this.money = sc.nextLong();
        entities = new ArrayList<>();
        int nPath = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.println(line);
            if (line.equals("")) continue;
            if (line.equals("Path")) {
                int pathSize = sc.nextInt();
                System.out.println(pathSize);
                enemyPath[nPath] = new Path();
                for (int i = 0; i < pathSize; i++) {
                    double len = sc.nextDouble();
                    int dir = sc.nextInt();
                    System.out.printf("%f %d\n", len, dir);
                    enemyPath[nPath].addInstruction(Pair.immutableOf(len, dir));
                }
                nPath++;
                continue;
            }
            else if (line.equals("GameWave")) {
                int curID = sc.nextInt();
                int numWave = sc.nextInt();
                System.out.printf("%d %d\n", curID, numWave);
                gameWave.setCurrentWaveID(curID);
                for (int i = 0; i < numWave; i++) {
                    String waveString = sc.nextLine();
                    System.out.printf("%s\n", waveString);
                    int timeToLive = sc.nextInt();
                    int numSpawners = sc.nextInt();
                    System.out.printf("%d %d\n", timeToLive, numSpawners);
                    Wave wave = new Wave(timeToLive);
                    for (int j = 0; j < numSpawners; j++) {
                        String spawnerString = sc.nextLine();
                        long posX = sc.nextLong();
                        long posY = sc.nextLong();
                        long tickDown = sc.nextLong();
                        long numOfSpawn = sc.nextLong();
                        int idPath = sc.nextInt();
                        AbstractSpawner spawner;
                        if (spawnerString.equals("BossSpawner")) {
                            spawner = new BossSpawner(posX, posY);
                        } else if (spawnerString.equals("NormalSpawner")) {
                            spawner = new NormalSpawner(posX, posY);
                        } else if (spawnerString.equals("SmallerSpawner")) {
                            spawner = new SmallerSpawner(posX, posY);
                        } else if (spawnerString.equals("TankerSpawner")) {
                            spawner = new TankerSpawner(posX, posY);
                        } else {
                            System.out.println("Not found\n");
                            continue;
                        }
                        spawner.setInfo(tickDown, numOfSpawn, idPath);
                        wave.addSpawner(spawner);
                    }
                    gameWave.addWave(wave);
                    continue;
                }
                entities.add(gameWave);
            } else if (line.equals("entities")) {
                int size = sc.nextInt();
            } else if (line.equals("Target")) {
                double posX = sc.nextDouble();
                double posY = sc.nextDouble();
                long health = sc.nextLong();
                long maxHealth = sc.nextLong();

                Target target = new Target(posX, posY);
                target.setHealth(health);
                target.setMaxHealth(maxHealth);
                entities.add(target);
            } else if (line.equals("NormalEnemy") || line.equals("SmallerEnemy") || line.equals("TankerEnemy") || line.equals("BossEnemy")) {
                /// maxhealth, health, armor, speed, reward, degreerotate, didinstr, currins

                double posX = sc.nextDouble();
                double posY = sc.nextDouble();
                long maxHealth = sc.nextLong();
                long health = sc.nextLong();
                long armor = sc.nextLong();
                double speed = sc.nextDouble();
                long reward = sc.nextLong();
                double degreeRotate = sc.nextDouble();
                double didInstruction = sc.nextDouble();
                int currInstruction = sc.nextInt();
                int idPath = sc.nextInt();
                long damage, damageInterval, time, time2;
                double speedDown;
                damage = sc.nextLong();
                damageInterval = sc.nextLong();
                time = sc.nextLong();
                speedDown = sc.nextDouble();
                time2 = sc.nextLong();
                AbstractEnemy enemy;
                if (line.equals("NormalEnemy")) {
                    enemy = new NormalEnemy(posX, posY);
                } else if (line.equals("SmallerEnemy")) {
                    enemy = new SmallerEnemy(posX, posY);
                } else if (line.equals("TankerEnemy")) {
                    enemy = new TankerEnemy(posX, posY);
                } else if (line.equals("BossEnemy")) {
                    enemy = new BossEnemy(posX, posY);
                } else {
                    System.out.println("Not found\n");
                    continue;
                }
                enemy.setInfo(maxHealth, health, armor, speed, reward, degreeRotate, didInstruction, currInstruction);
                enemy.setPath(this, idPath);
                enemy.setBuff(damage, damageInterval, time, speedDown, time2);
            } else if (line.equals("NormalTower") || line.equals("SniperTower") || line.equals("MachineGunTower")) {

            }
        }
    }
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

    public void addEntity(GameEntity entity) {
        if (entity instanceof AbstractTower) {
            if (money >= ((AbstractTower) entity).getCost()) {
                entities.add(entity);
                entities.add(((AbstractTower) entity).getGun());

                money -= ((AbstractTower) entity).getCost();
                if (money <= 0L) {
                    money = 0L;
                }
            }
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
