package TowerDefense.thegame.entity.stage;

import TowerDefense.thegame.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class StageLoader {
    private int[][] layout = new int[(int) Config.TILE_VERTICAL][(int) Config.TILE_HORIZONTAL];

    public StageLoader(String filePath) throws IOException {
        Scanner scan = new Scanner(new FileInputStream(filePath));

        for (int i = 0; i < Config.TILE_VERTICAL; ++i) {
            String[] entries = scan.nextLine().split("\\s+");
            for (int j = 0; j < entries.length; ++j) {
                layout[i][j] = Integer.parseInt(entries[j]);
            }
        }

        scan.close();
    }

    public int[][] getLayout() { return layout; }

    public int getCurrentLayout(int i, int j) {
        if (i < Config.TILE_VERTICAL && j < Config.TILE_HORIZONTAL) {
            return layout[i][j];
        }
        return -1;
    }

    public void setCurrentLayout(int i, int j, int modifiedLayout) {
        if (i < Config.TILE_VERTICAL && j < Config.TILE_HORIZONTAL) {
            if (layout[i][j] != modifiedLayout) {
                layout[i][j] = modifiedLayout;
            }
        }
    }
}
