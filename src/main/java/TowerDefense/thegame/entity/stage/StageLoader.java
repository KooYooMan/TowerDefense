package TowerDefense.thegame.entity.stage;

import TowerDefense.thegame.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class StageLoader {
    private String[][] layout = new String[(int) Config.TILE_VERTICAL][];

    public StageLoader(String filePath) throws IOException {
        Scanner scan = new Scanner(new FileInputStream(filePath));
        for (int i = 0; i < Config.TILE_VERTICAL; ++i) {
            String line = scan.nextLine();
            layout[i] = line.split("\\s+");
        }
    }

    public String[][] getLayout() { return layout; }

    public String getCurrentLayout(int i, int j) {
        if (i < Config.TILE_VERTICAL && j < Config.TILE_HORIZONTAL) {
            return layout[i][j];
        }
        return null;
    }

    public void setCurrentLayout(int i, int j, String modifiedLayout) {
        if (i < Config.TILE_VERTICAL && j < Config.TILE_HORIZONTAL) {
            if (!layout[i][j].equals(modifiedLayout)) {
                layout[i][j] = modifiedLayout;
            }
        }
    }
}
