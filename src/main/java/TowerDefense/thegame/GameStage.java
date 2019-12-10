package TowerDefense.thegame;

import TowerDefense.thegame.entity.GameEntity;
import TowerDefense.thegame.entity.bullet.BurningBullet;
import TowerDefense.thegame.entity.bullet.FrozenBullet;
import TowerDefense.thegame.entity.bullet.NormalBullet;
import TowerDefense.thegame.entity.enemy.*;
import TowerDefense.thegame.entity.enemy.path.Path;
import TowerDefense.thegame.entity.gun.AbstractGun;
import TowerDefense.thegame.entity.tile.Target;
import TowerDefense.thegame.entity.tile.spawner.*;
import TowerDefense.thegame.entity.tile.tower.AbstractTower;
import TowerDefense.thegame.entity.tile.tower.MachineGunTower;
import TowerDefense.thegame.entity.tile.tower.NormalTower;
import TowerDefense.thegame.entity.tile.tower.SniperTower;
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
    public GameStage(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        Scanner sc = null;
        sc = new Scanner(file);
        String skipLine = new String();
        for (int i = 0; i < 1 + Config.TILE_HORIZONTAL; i++) {
            skipLine = sc.nextLine();
        }
        this.width = sc.nextLong();
        this.height = sc.nextLong();
        this.money = sc.nextLong();
        entities = new ArrayList<>();
        int nPath = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            System.out.printf("line = %s\n", line);
            if (line.equals("Path")) {
                int pathSize = Integer.parseInt(sc.nextLine());
                System.out.println(pathSize);
                enemyPath[nPath] = new Path();
                for (int i = 0; i < pathSize; i++) {
                    String[] insInfo = sc.nextLine().split(" ");
                    double len = Double.parseDouble(insInfo[0]);
                    int dir = Integer.parseInt(insInfo[1]);
                    System.out.printf("%f %d\n", len, dir);
                    enemyPath[nPath].addInstruction(Pair.immutableOf(len, dir));
                }
                nPath++;
                continue;
            }
            else if (line.equals("GameWave")) {
                int curID = Integer.parseInt(sc.nextLine());
                int numWave = Integer.parseInt(sc.nextLine());
                gameWave.setCurrentWaveID(curID);
                for (int i = 0; i < numWave; i++) {
                    String waveString = sc.nextLine();

                    int timeToLive = Integer.parseInt(sc.nextLine());
                    int numSpawners = Integer.parseInt(sc.nextLine());
                    System.out.printf("%d %d\n", timeToLive, numSpawners);

                    Wave wave = new Wave(timeToLive);
                    for (int j = 0; j < numSpawners; j++) {
                        String spawnerString = sc.nextLine();
                        String spawnerInfoLine = sc.nextLine();
                        String[] splits = spawnerInfoLine.split(" ");
                        System.out.printf("%s\n%s\n", spawnerString, spawnerInfoLine);
                        double posX = Double.parseDouble(splits[0]);
                        double posY = Double.parseDouble(splits[1]);
                        long tickDown = Long.parseLong(splits[2]);
                        long numOfSpawn = Long.parseLong(splits[3]);
                        int idPath = Integer.parseInt(splits[4]);
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
                int size = Integer.parseInt(sc.nextLine());
                System.out.printf("size = %d\n", size);
            } else if (line.equals("Target")) {
                String targetInfoLine = sc.nextLine();
                String[] targetSplits = targetInfoLine.split(" ");
                double posX = Double.parseDouble(targetSplits[0]);
                double posY = Double.parseDouble(targetSplits[1]);
                long health = Long.parseLong(targetSplits[2]);
                long maxHealth = Long.parseLong(targetSplits[3]);

                Target target = new Target(posX, posY);
                target.setHealth(health);
                target.setMaxHealth(maxHealth);
                entities.add(target);
            } else if (line.equals("NormalEnemy") || line.equals("SmallerEnemy") || line.equals("TankerEnemy") || line.equals("BossEnemy")) {
                /// maxhealth, health, armor, speed, reward, degreerotate, didinstr, currins
                String enemyInfoLine = sc.nextLine();
                String[] enemySplits = enemyInfoLine.split(" ");
                double posX = Double.parseDouble(enemySplits[0]);
                double posY = Double.parseDouble(enemySplits[1]);
                long maxHealth = Long.parseLong(enemySplits[2]);
                long health = Long.parseLong(enemySplits[3]);
                long armor = Long.parseLong(enemySplits[4]);
                double speed = Double.parseDouble(enemySplits[5]);
                long reward = Long.parseLong(enemySplits[6]);
                double degreeRotate = Double.parseDouble(enemySplits[7]);
                double didInstruction = Double.parseDouble(enemySplits[8]);
                int currInstruction = Integer.parseInt(enemySplits[9]);
                int idPath = Integer.parseInt(enemySplits[10]);
                long damage, damageInterval, time, time2;
                double speedDown;
                damage = Long.parseLong(enemySplits[11]);
                damageInterval = Long.parseLong(enemySplits[12]);
                time = Long.parseLong(enemySplits[13]);
                speedDown = Double.parseDouble(enemySplits[14]);
                time2 = Long.parseLong(enemySplits[15]);
                System.out.printf("%f %f\n", posX, posY);
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
                entities.add(enemy);
            } else if (line.equals("NormalTower") || line.equals("SniperTower") || line.equals("MachineGunTower")) {
                //double range, long speed, long tick, int level, double scale, double upgradedScale, long cost, long upgradedCost
                String towerInfoLine = sc.nextLine();
                String[] towerSplits = towerInfoLine.split(" ");
                double posX = Double.parseDouble(towerSplits[0]);
                double posY = Double.parseDouble(towerSplits[1]);
                double range = Double.parseDouble(towerSplits[2]);
                long speed = Long.parseLong(towerSplits[3]);
                long tick = Long.parseLong(towerSplits[4]);
                int level = Integer.parseInt(towerSplits[5]);
                double scale = Double.parseDouble(towerSplits[6]);
                double upgradedScale = Double.parseDouble(towerSplits[7]);
                long cost = Long.parseLong(towerSplits[8]);
                long upgradedCost = Long.parseLong(towerSplits[9]);
                int numberBullet = Integer.parseInt(towerSplits[10]);
                AbstractTower tower;
                if (line.equals("NormalTower")) {
                    tower = new NormalTower(posX, posY);
                } else if (line.equals("SniperTower")) {
                    tower = new SniperTower(posX, posY);
                } else if (line.equals("MachineGunTower")) {
                    tower = new MachineGunTower(posX, posY);
                } else {
                    System.out.printf("Not found\n");
                    continue;
                }
                tower.setInfo(range, speed, tick, level, scale, upgradedScale, cost, upgradedCost);
                for (int i = 0; i < numberBullet; i++) {
                    String bulletClass = sc.nextLine();
                    System.out.printf("bulletClass = %s\n", bulletClass);
                    if (bulletClass.equals(NormalBullet.class.toString())) {
                        tower.addBullet(NormalBullet.class);
                    } else if (bulletClass.equals(FrozenBullet.class.toString())) {
                        tower.addBullet(FrozenBullet.class);
                    } else if (bulletClass.equals(BurningBullet.class.toString())) {
                        tower.addBullet(BurningBullet.class);
                    } else {
                        System.out.println("Not found");
                        continue;
                    }
                }
                AbstractGun gun = tower.getGun();
                entities.add(tower);
                entities.add(gun);
            }
        }
        sc.close();
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
