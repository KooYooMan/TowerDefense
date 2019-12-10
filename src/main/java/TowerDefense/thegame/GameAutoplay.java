package TowerDefense.thegame;

import javafx.util.Pair;

import java.io.ObjectInputFilter;
import java.util.ArrayList;
import java.util.List;

public class GameAutoplay {
    int[][] layout;
    int[][][] score;
    int[][] lane;
    boolean[][] isVisited;
    static final int[] nx = {0, 0, 0, -1, 1, 1, 1, 1};
    static final int[] ny = {-1, 0, 1, 0, 0, -1, 0, 1};

    static final int dx[] = {0, 0, -1, 1};
    static final int dy[] = {-1, 1, 0, 0};
    int[] totalScore = new int[2];
    boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < Config.TILE_VERTICAL && y < Config.TILE_HORIZONTAL;
    }
    GameAutoplay(int[][] layout) {
        totalScore[0] = 1;
        totalScore[1] = 1;
        this.layout = layout;
        isVisited = new boolean[(int)Config.TILE_HORIZONTAL][(int)Config.TILE_VERTICAL];
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
        score = new int[(int)Config.TILE_HORIZONTAL][(int)Config.TILE_VERTICAL][currLane];

        for (int x = 0; x < Config.TILE_HORIZONTAL; x++) {
            for (int y = 0; y < Config.TILE_VERTICAL; y++) {
                if (getLayout(x, y) != Config.MOUNTAIN_LAYOUT) {
                    continue;
                }
                for (int dir = 0; dir < 8; dir++) {
                    int x2 = x + nx[dir];
                    int y2 = y + ny[dir];
                    if (inRange(x2, y2) && (getLayout(x2, y2) == Config.START_LAYOUT || getLayout(x2, y2) == Config.ROAD_LAYOUT)) {
                        score[x][y][lane[x][y]]++;
                    }
                }
            }
        }
        for (int x = 0; x < Config.TILE_HORIZONTAL; x++) {
            for (int y = 0; y < Config.TILE_VERTICAL; y++) {
                if (currLane == 1)
                    System.out.printf("%d ", score[x][y][0]);
                else {
                    System.out.printf("(%d, %d) ", score[x][y][0], score[x][y][1]);
                }
            }
            System.out.printf("\n");
        }
    }
    public int getLayout(int i, int j) {
        return layout[i][j];
    }
    public int[][] getLane() {
        return lane;
    }

    public int[][][] getScore() {
        return score;
    }

    public int[][] getLayout() {
        return layout;
    }
}
