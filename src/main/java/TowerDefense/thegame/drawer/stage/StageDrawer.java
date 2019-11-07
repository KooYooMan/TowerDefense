package TowerDefense.thegame.drawer.stage;

import TowerDefense.thegame.Config;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class StageDrawer {
    private GraphicsContext graphicsContext;
    private String[][] layout = new String[(int) Config.TILE_VERTICAL][];

    public StageDrawer(GraphicsContext graphicsContext, String filePath) throws IOException {
        this.graphicsContext = graphicsContext;

        Scanner scan = new Scanner(new FileInputStream(filePath));
        for (int i = 0; i < Config.TILE_VERTICAL; ++i) {
            String line = scan.nextLine();
            layout[i] = line.split("\\s+");
        }
    }

    public void draw() throws IOException {
        String path = "src/main/java/TowerDefense/thegame/drawer/stage/";

        graphicsContext.drawImage(new Image(new FileInputStream(path + "AnotherTestStageBG.png")),
                0, 0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);

        for (int i = 0; i < Config.TILE_VERTICAL; ++i) {
            for (int j = 0; j < Config.TILE_HORIZONTAL; ++j) {
                if (!layout[i][j].equals("000")) {
                    graphicsContext.drawImage(new Image(new FileInputStream(path + layout[i][j] + ".png")),
                            j * Config.TILE_SIZE, i * Config.TILE_SIZE, Config.TILE_SIZE, Config.TILE_SIZE);
                }
            }
        }
    }
}
