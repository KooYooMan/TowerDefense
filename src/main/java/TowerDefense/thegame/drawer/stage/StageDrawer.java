package TowerDefense.thegame.drawer.stage;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.stage.StageLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.IOException;

public class StageDrawer {
    private GraphicsContext graphicsContext;
    private Image background;
    private String[][] layout;
    private Image[][] tiles;

    public StageDrawer(GraphicsContext graphicsContext, StageLoader stageLoader) throws IOException {
        this.graphicsContext = graphicsContext;
        this.layout = stageLoader.getLayout();
        this.background = new Image(new FileInputStream("src/main/java/TowerDefense/thegame/drawer/stage/TestStageBG.png"));
        this.tiles = new Image[(int) Config.TILE_VERTICAL][(int) Config.TILE_HORIZONTAL];

        for (int i = 0; i < Config.TILE_VERTICAL; ++i) {
            for (int j = 0; j < Config.TILE_HORIZONTAL; ++j) {
                if (layout[i][j].equals("000")) {
                    tiles[i][j] = null;
                } else {
                    tiles[i][j] = new Image(
                            new FileInputStream("src/main/java/TowerDefense/thegame/drawer/stage/" + layout[i][j] + ".png")
                    );
                }
            }
        }
    }

    public void draw() {
        graphicsContext.drawImage(background, 0, 0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);

        for (int i = 0; i < Config.TILE_VERTICAL; ++i) {
            for (int j = 0; j < Config.TILE_HORIZONTAL; ++j) {
                //graphicsContext.strokeRect(j * Config.TILE_SIZE, i * Config.TILE_SIZE, Config.TILE_SIZE, Config.TILE_SIZE);
                if (tiles[i][j] != null) {
                    graphicsContext.drawImage(tiles[i][j],
                            j * Config.TILE_SIZE, i * Config.TILE_SIZE, Config.TILE_SIZE, Config.TILE_SIZE);
                }
            }
        }
    }

    public void strokeRect(boolean b) {
        if (b) {
            graphicsContext.setStroke(Color.YELLOW);
        } else {
            graphicsContext.setStroke(Color.GREEN);
        }

        for (int i = 0; i < Config.TILE_VERTICAL; ++i) {
            for (int j = 0; j < Config.TILE_HORIZONTAL; ++j) {
                if (layout[i][j].equals("000")) {
                    graphicsContext.strokeRect(j * Config.TILE_SIZE, i * Config.TILE_SIZE, Config.TILE_SIZE, Config.TILE_SIZE);
                }
            }
        }
    }
}
