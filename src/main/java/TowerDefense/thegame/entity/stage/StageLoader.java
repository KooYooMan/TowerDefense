package TowerDefense.thegame.entity.stage;

import TowerDefense.thegame.Config;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class StageLoader {
    private int currentMap = -1;
    private int[][] layout = new int[(int) Config.TILE_VERTICAL][(int) Config.TILE_HORIZONTAL];
    private Image background;

    @Override
    public String toString() {
        String stageString = currentMap + "\n";
        for (int i = 0; i < Config.TILE_VERTICAL; i++) {
            for (int j = 0; j < Config.TILE_HORIZONTAL; j++) {
                stageString += layout[i][j];
                if (j != Config.TILE_HORIZONTAL - 1)
                     stageString += " ";

            }
            stageString += "\n";
        }
        return stageString;
    }

    private StageLoader() {
        this.background = null;
    }

    private StageLoader(String layoutFilePath, int currentMap) throws IOException {
        Scanner scan = new Scanner(new FileInputStream(layoutFilePath));
        int idMap = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < Config.TILE_VERTICAL; ++i) {
            String[] entries = scan.nextLine().split("\\s+");
            for (int j = 0; j < entries.length; ++j) {
                this.layout[i][j] = Integer.parseInt(entries[j]);
            }
        }

        scan.close();

        this.background = new Image(new FileInputStream(Config.MAP_IMAGE + idMap + ".png"));
        this.currentMap = currentMap;
    }

    private StageLoader(String filePath) throws FileNotFoundException {
        Scanner scan = new Scanner(new FileInputStream(filePath));
        int idMap = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < Config.TILE_VERTICAL; ++i) {
            String[] entries = scan.nextLine().split("\\s+");
            for (int j = 0; j < entries.length; ++j) {
                this.layout[i][j] = Integer.parseInt(entries[j]);
            }
        }

        scan.close();

        this.background = new Image(new FileInputStream(Config.MAP_IMAGE + idMap + ".png"));
        this.currentMap = idMap;
    }

    public static StageLoader nullStage() {
        return new StageLoader();
    }

    public static StageLoader loadStage(int i) throws IOException {
        return new StageLoader(Config.MAP_LAYOUT + i + ".txt", i);
    }

    public static StageLoader loadStage(String filePath) throws IOException {
        return new StageLoader(filePath);
    }

    public int getCurrentMap() { return currentMap; }
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
