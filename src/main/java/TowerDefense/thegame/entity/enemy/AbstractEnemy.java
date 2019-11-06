package TowerDefense.thegame.entity.enemy;

import TowerDefense.thegame.GameField;
import TowerDefense.thegame.entity.*;
import TowerDefense.thegame.entity.Effect.AbstractEffect;
import TowerDefense.thegame.entity.enemy.path.Path;
import TowerDefense.utilities.Pair;
import javafx.scene.effect.Effect;

import javax.annotation.Nonnull;
import javax.servlet.jsp.JspPage;
import java.util.Collection;
import java.util.Collections;

public abstract class AbstractEnemy extends AbstractEntity implements UpdatableEntity, EffectEntity, LivingEntity, DestroyListener {
    private static final double[][] DELTA_DIRECTION_ARRAY = {
            {0.0, -1.0}, {0.0, 1.0}, {-1.0, 0.0}, {1.0, 0.0},
    };

    private long health;
    private long armor;
    private double speed;
    private long reward;
    Path path;
    double didInstruction = 0;
    int currInstruction = 0;
    protected AbstractEnemy (double posX, double posY, double size, long health, long armor, double speed, long reward) {
        super(posX, posY, size, size);
        this.health = health;
        this.armor = armor;
        this.speed = speed;
        this.reward = reward;
        currInstruction = 0;
        didInstruction = 0;
        path = new Path();
        path.addInstruction(Pair.immutableOf(100.0, 1));
        path.addInstruction(Pair.immutableOf(200.0, 3));

    }
    void setPath () {
        this.path = path;
    }
    public final void onUpdate (@Nonnull GameField field) {
        final double enemyPosX = getPosX();
        final double enemyPosY = getPosY();
        final double enemyWidth = getWidth();
        final double enemyHeight = getHeight();
        didInstruction += path.getInstruction(currInstruction).getB() * speed;
        setPosX(enemyPosX + speed * DELTA_DIRECTION_ARRAY[path.getInstruction(currInstruction).getB()][0]);
        setPosY(enemyPosY + speed * DELTA_DIRECTION_ARRAY[path.getInstruction(currInstruction).getB()][1]);
        if (didInstruction >= path.getInstruction(currInstruction).getA()) {
            didInstruction = 0;
            currInstruction += 1;
            if (currInstruction >= path.getNumberInstructions()) {
                health = -1;
            }

        }
        System.out.printf("%f %f curr = %d did = %f\n", getPosX(), getPosY(), currInstruction, didInstruction);
    }
    public final void doDestroy () {


    }
    @Override
    public void onDestroy(GameField field) {
        ///add reward for field;
    }

    @Override
    public boolean onEffect(GameField field, LivingEntity livingEntity) {
        return false;
    }

    @Override
    public long getHealth() {
        return health;
    }
    public final void doEffect (long value) {

    }
    @Override
    public void getEffected(AbstractEffect other) {

    }
    @Override
    public boolean isDestroyed() {
        return getHealth() <= 0;
    }

}
