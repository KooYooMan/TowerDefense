package TowerDefense.thegame.entity.enemy;

import TowerDefense.thegame.GameField;
import TowerDefense.thegame.entity.*;

public abstract class AbstractEnemy extends AbstractEntity implements DestroyListener, LivingEntity, EffectEntity, UpdatableEntity {
    private final long health;
    private final long armor;
    private final long reward;

    private final double deltaX;
    private final double deltaY;

    protected AbstractEnemy(double posX, double posY, double deltaX, double deltaY, double width, double height,
                            long health, long armor, long reward, double speed) {
        super(posX, posY, width, height);
        this.health = health;
        this.armor = armor;
        this.reward = reward;

        final double normalize = speed / Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        this.deltaX = deltaX * normalize;
        this.deltaY = deltaY * normalize;
    }

    @Override
    public final void onUpdate(GameField field) {
        setPosX(getPosX() + deltaX);
        setPosY(getPosY() + deltaY);
    }

    @Override
    public long getHealth() { return health; }

    @Override
    public boolean isDestroyed() { return this.getHealth() <= 0L; }

    @Override
    public void onDestroy(GameField gameField) {
        // TODO: reward
    }

    @Override
    public void doDestroy() {
        // TODO:
    }

//    @Override
//    public void doEffect(long value) {
//        // TODO:
//    }

    @Override
    public boolean onEffect(GameField gameField, LivingEntity livingEntity) {
        // TODO:
        return false;
    }
}
