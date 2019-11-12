package TowerDefense.thegame.entity.enemy;

import TowerDefense.thegame.GameField;
import TowerDefense.thegame.entity.*;
import TowerDefense.thegame.entity.buff.AbstractBuff;
import TowerDefense.thegame.entity.buff.BurningBuff;
import TowerDefense.thegame.entity.buff.ShootBuff;
import TowerDefense.thegame.entity.enemy.path.Path;

import javax.annotation.Nonnull;
import java.util.List;

public abstract class AbstractEnemy extends AbstractEntity implements UpdatableEntity, EffectEntity, LivingEntity, DestroyListener, RotatableEntity, BuffedEntity {
    private static final double[][] DELTA_DIRECTION_ARRAY = {
            {0.0, -1.0}, {0.0, 1.0}, {-1.0, 0.0}, {1.0, 0.0},
    };
    private static final double [] DEGREE_ROTATE_ARRAY = {
        270, 90, 180, 0
    };
    private long health;
    private long armor;
    private double speed;
    private long reward;
    private double degreeRotate;
    Path path;
    double didInstruction = 0;
    int currInstruction = 0;
    AbstractBuff[] timeRemaining = new AbstractBuff[4];
    protected AbstractEnemy (double posX, double posY, double size, long health, long armor, double speed, long reward) {
        super(posX, posY, size, size);
        this.health = health;
        this.armor = armor;
        this.speed = speed;
        this.reward = reward;
        currInstruction = 0;
        didInstruction = 0;

    }
    public void setPath (Path path) {
        this.path = path;
    }
    public final void onUpdate (@Nonnull GameField field) {
        final double enemyPosX = getPosX();
        final double enemyPosY = getPosY();
        final double enemyWidth = getWidth();
        final double enemyHeight = getHeight();
        didInstruction += Math.abs(speed);
//        System.out.println(path.getDirect(currInstruction));
        setPosX(enemyPosX + speed * DELTA_DIRECTION_ARRAY[path.getDirect(currInstruction)][0]);
        setPosY(enemyPosY + speed * DELTA_DIRECTION_ARRAY[path.getDirect(currInstruction)][1]);
        degreeRotate = DEGREE_ROTATE_ARRAY[path.getDirect(currInstruction)];
//        System.out.printf("posx = %f posy = %f dx = %f dy = %f deg = %f\n",
//                getPosX(), getPosY(), DELTA_DIRECTION_ARRAY[path.getDirect(currInstruction)][0], DELTA_DIRECTION_ARRAY[path.getDirect(currInstruction)][1], degreeRotate);

        if (didInstruction >= Math.abs(path.getLength(currInstruction))) {
            didInstruction = 0;
            currInstruction += 1;
            if (currInstruction >= path.getNumberInstructions()) {
                health = -1;
            }

        }
//        System.out.printf("%f %f curr = %d did = %f\n", getPosX(), getPosY(), currInstruction, didInstruction);
    }
//
    @Override
    public double getDegreeRotate() {
        return degreeRotate;
    }

    @Override
    public void onDestroy(GameField field) {
        ///add reward for field;
    }

    @Override
    public boolean onEffect(GameField field, LivingEntity livingEntity) {
        livingEntity.doEffect(-1);
        health = 0;
        return false;
    }

    @Override
    public long getHealth() {
        return health;
    }
    public final void doEffect (long value) {
        health += value;
    }
    @Override
    public void getBuffed(AbstractBuff buff) {
        if (buff instanceof ShootBuff) {
            health -= ((ShootBuff) buff).getDamage();
        }
    }
    @Override
    public boolean isDestroyed() {
        return getHealth() <= 0;
    }

}
