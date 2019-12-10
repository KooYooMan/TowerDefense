package TowerDefense.thegame;

import TowerDefense.thegame.entity.GameEntity;
import TowerDefense.thegame.entity.bullet.BurningBullet;
import TowerDefense.thegame.entity.bullet.FrozenBullet;
import TowerDefense.thegame.entity.bullet.NormalBullet;
import TowerDefense.thegame.entity.tile.tower.AbstractTower;
import TowerDefense.thegame.entity.tile.tower.MachineGunTower;
import TowerDefense.thegame.entity.tile.tower.NormalTower;
import TowerDefense.thegame.entity.tile.tower.SniperTower;
import javafx.util.Pair;

import java.io.ObjectInputFilter;
import java.util.ArrayList;
import java.util.List;

public class GameAutoplay {
    private int[][] layout;
    private int[][][] score;
    private int[][] lane;
    int numberOfLanes = 0;
    static private final int[] nx = {0, 0, 0, -1, 1, 1, 1, 1};
    static private final int[] ny = {-1, 0, 1, 0, 0, -1, 0, 1};

    static private final int dx[] = {0, 0, -1, 1};
    static private final int dy[] = {-1, 1, 0, 0};
    private int[] totalScore = new int[3];
    private boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < Config.TILE_VERTICAL && y < Config.TILE_HORIZONTAL;
    }
    GameField gameField;
    GameAutoplay(GameField gameField, int[][] layout) {
        totalScore[0] = 1;
        this.gameField = gameField;
        totalScore[1] = 1;
        this.layout = layout;
        boolean[][] isVisited = new boolean[(int) Config.TILE_HORIZONTAL][(int) Config.TILE_VERTICAL];
        lane = new int[(int)Config.TILE_HORIZONTAL][(int)Config.TILE_VERTICAL];
        for (int x = 0; x < Config.TILE_HORIZONTAL; x++) {
            for (int y = 0; y < Config.TILE_VERTICAL; y++) {
                isVisited[x][y] = false;
            }
        }

        List<Pair<Integer, Integer>> startingPoints = new ArrayList<>();
        for (int x = 0; x < Config.TILE_HORIZONTAL; x++) {
            for (int y = 0; y < Config.TILE_VERTICAL; y++) {
                if (layout[x][y] == Config.START_LAYOUT) {
                    startingPoints.add(new Pair<Integer, Integer>(x, y));
                }
            }
        }
        int currLane = 0;
        for (Pair<Integer, Integer> p : startingPoints) {
            currLane++;
            int x = p.getKey();
            int y = p.getValue();
            boolean isEnd = false;
            while (true) {
                isVisited[x][y] = true;
                lane[x][y] = currLane;
                if (getLayout(x, y) == Config.END_LAYOUT) {
                    break;
                }
                for (int dir = 0; dir < 4; dir++) {
                    int x2 = x + dx[dir];
                    int y2 = y + dy[dir];
                    if (inRange(x2, y2) && (getLayout(x2, y2) == Config.END_LAYOUT || getLayout(x2, y2) == Config.ROAD_LAYOUT) && !isVisited[x2][y2]) {
                        x = x2;
                        y = y2;
                        break;
                    }

                }
            }
        }
        numberOfLanes = currLane;
        for (int x = 0; x < Config.TILE_HORIZONTAL; x++) {
            for (int y = 0; y < Config.TILE_VERTICAL; y++){
                System.out.printf("%d ", layout[x][y]);
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
        for (int x = 0; x < Config.TILE_HORIZONTAL; x++) {
            for (int y = 0; y < Config.TILE_VERTICAL; y++){
                System.out.printf("%d ", lane[x][y]);
            }
            System.out.printf("\n");
        }
        System.out.printf("currLane = %d\n", currLane);
        score = new int[(int)Config.TILE_HORIZONTAL][(int)Config.TILE_VERTICAL][currLane + 1];
        System.out.println();
        for (int x = 0; x < Config.TILE_HORIZONTAL; x++) {
            for (int y = 0; y < Config.TILE_VERTICAL; y++) {
                if (currLane == 1)
                    System.out.printf("%d ", score[x][y][1]);
                else {
                    System.out.printf("(%d, %d) ", score[x][y][1], score[x][y][2]);
                }
            }
            System.out.printf("\n");
        }
        for (int x = 0; x < Config.TILE_HORIZONTAL; x++) {
            for (int y = 0; y < Config.TILE_VERTICAL; y++) {
                if (getLayout(x, y) != Config.MOUNTAIN_LAYOUT) {
                    continue;
                }
                calcScore(x, y);
            }
        }
        System.out.println();
        for (int x = 0; x < Config.TILE_HORIZONTAL; x++) {
            for (int y = 0; y < Config.TILE_VERTICAL; y++) {
                if (currLane == 1)
                    System.out.printf("%d ", score[x][y][1]);
                else {
                    System.out.printf("(%d, %d) ", score[x][y][1], score[x][y][2]);
                }
            }
            System.out.printf("\n");
        }
    }
    void calcScore(int x, int y) {
        for (int x2 = 0; x2 < Config.TILE_HORIZONTAL; x2++) {
            score[x][y][lane[x2][y]]++;
        }
        for (int y2 = 0; y2 < Config.TILE_VERTICAL; y2++) {
            score[x][y][lane[x][y2]]++;
        }
        score[x][y][lane[x][y]]--;
        score[x][y][lane[x][y]]--;
    }
    private void setTower(int x, int y) {
        if (layout[x][y] == Config.TOWER_LAYOUT)
            return;
        int randomBullet = (int)(Math.random() * 1000);
        int randomTower = (int)(Math.random() * 1000);
        long totalCost = -1;
        AbstractTower tower;
        System.out.printf("%d %d\n", randomBullet, randomTower);
        double X = y * Config.TILE_SIZE;
        double Y = x * Config.TILE_SIZE;
        if (randomTower <= 333) {
            tower = new NormalTower(X, Y);
        } else {
            tower = new SniperTower(X, Y);
        }
        if (randomBullet <= 333) {
            if (tower.getCost() + Config.FROZEN_BULLET_COST + Config.NORMAL_BULLET_COST <= gameField.getGameStage().getMoney()) {
                totalCost = tower.getCost() + Config.FROZEN_BULLET_COST + Config.NORMAL_BULLET_COST;
                tower.addBullet(FrozenBullet.class);
                tower.addBullet(NormalBullet.class);
            }
        } else if (randomBullet <= 666) {
            if (tower.getCost() + Config.FROZEN_BULLET_COST + Config.BURNING_BULLET_COST <= gameField.getGameStage().getMoney()) {
                totalCost = tower.getCost() + Config.FROZEN_BULLET_COST + Config.BURNING_BULLET_COST;
                tower.addBullet(FrozenBullet.class);
                tower.addBullet(BurningBullet.class);

            }

        } else {
            if (tower.getCost() + Config.BURNING_BULLET_COST + Config.NORMAL_BULLET_COST <= gameField.getGameStage().getMoney()) {
                totalCost = tower.getCost() + Config.BURNING_BULLET_COST + Config.NORMAL_BULLET_COST;
                tower.addBullet(BurningBullet.class);
                tower.addBullet(NormalBullet.class);

            }
        }
        if (totalCost == -1) return;
        gameField.getGameStage().reduceMoney(totalCost);


        for (int l = 0; l <= numberOfLanes; l++) {
            totalScore[l] += score[x][y][l];
        }
        layout[x][y] = (int)Config.TOWER_LAYOUT;
        gameField.getEntities().add(tower);
        gameField.getEntities().add(tower.getGun());

    }
    private int getRealScore(int x, int y) {
        if (numberOfLanes == 1) {
            return score[x][y][1];
        }
        return score[x][y][1] * totalScore[2] + score[x][y][2] * totalScore[1];
    }
    private Pair<Integer, Integer> getMaxScore() {
        Pair<Integer, Integer> best = new Pair<>(0, 0);
        for (int x = 0; x < Config.TILE_HORIZONTAL; x++) {
            for (int y = 0; y < Config.TILE_VERTICAL; y++) {
                int bx = best.getKey();
                int by = best.getValue();

                if (layout[x][y] == Config.MOUNTAIN_LAYOUT && getRealScore(x, y) > getRealScore(bx, by)) {
                    best = new Pair<>(x, y);
                }
            }
        }
        return best;
    }

    private int getLayout(int i, int j) {
        return layout[i][j];
    }

    public int[][] getLayout() {
        return layout;
    }
    public void doAutoplay() {
        Pair<Integer, Integer> best = getMaxScore();
        setTower(best.getKey(), best.getValue());
    }
}
