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
    private int[][] layout;
    private boolean isPlacingTower;
    private boolean isUpgradingTower;
    private boolean isSellingTower;

    public StageDrawer(GraphicsContext graphicsContext, StageLoader stageLoader) throws IOException {
        this.graphicsContext = graphicsContext;
        this.graphicsContext.setStroke(Color.rgb(46, 204, 113));
        this.layout = stageLoader.getLayout();
        this.background = new Image(new FileInputStream("resources/map/image/Map1.png"));
    }

    public void setPlacingTower(boolean placingTower) { isPlacingTower = placingTower; }
    public void setUpgradingTower(boolean upgradingTower) { isUpgradingTower = upgradingTower; }
    public void setSellingTower(boolean sellingTower) { isSellingTower = sellingTower; }

    public void draw() {
        graphicsContext.drawImage(background, 0, 0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);

        if (isPlacingTower) {
            graphicsContext.setStroke(Color.YELLOW);

            for (int i = 0; i < Config.TILE_VERTICAL; ++i) {
                for (int j = 0; j < Config.TILE_HORIZONTAL; ++j) {
                    if (layout[i][j] == 0) {
                        graphicsContext.strokeRect(
                                j * Config.TILE_SIZE, i * Config.TILE_SIZE, Config.TILE_SIZE, Config.TILE_SIZE
                        );
                    }
                }
            }
        } else {
            graphicsContext.setStroke(Color.rgb(46, 204, 113));
        }

        if (isUpgradingTower) {
            graphicsContext.setStroke(Color.YELLOW);

            for (int i = 0; i < Config.TILE_VERTICAL; ++i) {
                for (int j = 0; j < Config.TILE_HORIZONTAL; ++j) {
                    if (layout[i][j] == 420) {
                        graphicsContext.strokeRect(
                                j * Config.TILE_SIZE, i * Config.TILE_SIZE, Config.TILE_SIZE, Config.TILE_SIZE
                        );
                    }
                }
            }
        } else {
            graphicsContext.setStroke(Color.rgb(46, 204, 113));
        }

        if (isSellingTower) {
            graphicsContext.setStroke(Color.RED);

            for (int i = 0; i < Config.TILE_VERTICAL; ++i) {
                for (int j = 0; j < Config.TILE_HORIZONTAL; ++j) {
                    if (layout[i][j] == 420) {
                        graphicsContext.strokeRect(
                                j * Config.TILE_SIZE, i * Config.TILE_SIZE, Config.TILE_SIZE, Config.TILE_SIZE
                        );
                    }
                }
            }
        } else {
            graphicsContext.setStroke(Color.rgb(46, 204, 113));
        }
    }
}
