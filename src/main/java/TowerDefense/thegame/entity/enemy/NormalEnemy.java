package TowerDefense.thegame.entity.enemy;

import TowerDefense.thegame.entity.Effect.AbstractEffect;

public class NormalEnemy extends AbstractEnemy {
    private static final double WIDTH_SIZE = 64;
    private static final double HEIGHT_SIZE = 64;
    private static final long DEFAULT_HEALTH = 50;
    private static final long DEFAULT_ARMOR = 50;
    private static final long DEFAULT_REWARD = 50;
    private static final double DEFAULT_SPEED = 10;

    public NormalEnemy(double posX, double posY, double deltaX, double deltaY) {
        super(posX, posY, deltaX, deltaY, WIDTH_SIZE, HEIGHT_SIZE,
                DEFAULT_HEALTH, DEFAULT_ARMOR, DEFAULT_REWARD, DEFAULT_SPEED);
    }

    @Override
    public void getEffected(AbstractEffect other) {

    }
}
