package TowerDefense.thegame.entity.shop;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.GameStage;
import TowerDefense.thegame.drawer.GameDrawer;
import TowerDefense.thegame.drawer.shop.button.*;
import TowerDefense.thegame.entity.stage.StageHandler;
import TowerDefense.thegame.entity.tile.tower.AbstractTower;
import javafx.scene.layout.Pane;

import java.lang.reflect.InvocationTargetException;

public class ButtonHandler {
    private GameStage gameStage;
    private Pane gamePane;
    private GameDrawer gameDrawer;

    public ButtonHandler(GameStage gameStage, Pane gamePane, GameDrawer gameDrawer) {
        this.gameStage = gameStage;
        this.gamePane = gamePane;
        this.gameDrawer = gameDrawer;
    }

    public void handleEventTower(TowerButtonDrawer button) {
        button.setOnMousePressed(buttonPressedMouseEvent -> {
            gameDrawer.getStageDrawer().placeTowerStrokeRect(true);
            gamePane.setOnMousePressed(gamePressedMouseEvent -> {
                int row = (int) (gamePressedMouseEvent.getY() / Config.TILE_SIZE);
                int column = (int) (gamePressedMouseEvent.getX() / Config.TILE_SIZE);

                if (gameDrawer.getStageLoader().getCurrentLayout(row, column).equals("000")) {
                    try {
                        gameStage.addEntity(StageHandler.getEntityClass(button.getClass()).getDeclaredConstructor(double.class, double.class).newInstance(column * Config.TILE_SIZE, row * Config.TILE_SIZE));
                    } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                    gameDrawer.getStageLoader().setCurrentLayout(row, column, "420");
                }

                gameDrawer.getStageDrawer().placeTowerStrokeRect(false);
            });
        });
    }

    public void handleEventBullet(BulletButtonDrawer button) {
        button.setOnMousePressed(buttonPressedMouseEvent -> {
            gameDrawer.getStageDrawer().upgradeTowerStrokeRect(true);
            gamePane.setOnMousePressed(gamePressedMouseEvent -> {
                int row = (int) (gamePressedMouseEvent.getY() / Config.TILE_SIZE);
                int column = (int) (gamePressedMouseEvent.getX() / Config.TILE_SIZE);

                if (gameDrawer.getStageLoader().getCurrentLayout(row, column).equals("420")) {
                    AbstractTower tower = (AbstractTower) gameStage.getGameEntity(row, column);
                    if (tower != null) {
                        tower.addBullet(StageHandler.getBulletClass(button.getClass()));
                    }
                }

                gameDrawer.getStageDrawer().upgradeTowerStrokeRect(false);
            });
        });
    }
}
