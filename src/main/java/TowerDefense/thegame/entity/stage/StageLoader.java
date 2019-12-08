package TowerDefense.thegame.entity.stage;

import TowerDefense.thegame.Config;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class StageLoader {
    private int[][] layout = new int[(int) Config.TILE_VERTICAL][(int) Config.TILE_HORIZONTAL];
    private Image background;

    public StageLoader() {
        this.background = null;
    }

    public StageLoader(String layoutFilePath, String mapFilePath) throws IOException {
        Scanner scan = new Scanner(new FileInputStream(layoutFilePath));

        for (int i = 0; i < Config.TILE_VERTICAL; ++i) {
            String[] entries = scan.nextLine().split("\\s+");
            for (int j = 0; j < entries.length; ++j) {
                this.layout[i][j] = Integer.parseInt(entries[j]);
            }
        }

        scan.close();

        this.background = new Image(new FileInputStream(mapFilePath));
    }

    public int[][] getLayout() { return layout; }
    public Image getBackground() { return background; }

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
