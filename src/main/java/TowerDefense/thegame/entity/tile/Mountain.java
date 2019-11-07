package TowerDefense.thegame.entity.tile;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.AbstractEntity;

public class Mountain extends AbstractEntity {
    public Mountain (double posX, double posY) { super(posX, posY, Config.TILE_SIZE, Config.TILE_SIZE); }
}
