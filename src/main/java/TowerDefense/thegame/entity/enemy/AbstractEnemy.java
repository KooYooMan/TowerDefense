package TowerDefense.thegame.entity.enemy;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.GameField;
import TowerDefense.thegame.GameStage;
import TowerDefense.thegame.entity.*;
import TowerDefense.thegame.entity.buff.AbstractBuff;
import TowerDefense.thegame.entity.buff.BurningBuff;
import TowerDefense.thegame.entity.buff.FrozenBuff;
import TowerDefense.thegame.entity.enemy.path.Path;

import javax.annotation.Nonnull;

public abstract class AbstractEnemy extends AbstractEntity implements UpdatableEntity, EffectEntity, DestroyListener, RotatableEntity, BuffedEntity {
    private static final double[][] DELTA_DIRECTION_ARRAY = {
            {0.0, -1.0}, {0.0, 1.0}, {-1.0, 0.0}, {1.0, 0.0},
    };
    private static final double [] DEGREE_ROTATE_ARRAY = {
        270, 90, 180, 0
    };
    private long maxHealth;
    private long health;
    private long armor;
    private double speed;
    private long reward;
    private double degreeRotate;
    Path path;
    int idPath;
    double didInstruction = 0;
    int currInstruction = 0;

    AbstractBuff[] buffed = new AbstractBuff[2];

    @Override
    public String toString() {
        return maxHealth + " " + health + " " +
                armor + " " + speed + " " + reward + " " + degreeRotate + " " +
                didInstruction + " " + currInstruction + " " + idPath + " " +
                buffed[0].toString() + " " + buffed[1].toString();
    }

    public long getArmor() {
        return armor;
    }

    protected AbstractEnemy (double posX, double posY, double size, long health, long armor, double speed, long reward) {
        super(posX, posY, size, size);
        this.health = health;
        this.armor = armor;
        this.speed = speed;
        this.reward = reward;
        this.maxHealth = health;
        currInstruction = 0;
        didInstruction = 0;
        buffed[0] = new BurningBuff();
        buffed[1] = new FrozenBuff();
        for (int i = 0; i < Config.NUMBER_OF_BUFFED; i++) {
            buffed[i].setTime(0);
        }

    }
    @Override
    public double getRatioHealth() {
        return (double)this.health / (double)this.maxHealth;
    }
    public void setPath (GameStage gameStage, int idPath) {
        this.idPath = idPath;
        this.path = gameStage.getPath(idPath);
    }
    public final void onUpdate (@Nonnull GameField field) {
        /// update position
        final double enemyPosX = getPosX();
        final double enemyPosY = getPosY();
        final double enemyWidth = getWidth();
        final double enemyHeight = getHeight();

        final double realSpeed = speed * ((FrozenBuff) buffed[1]).getRealSpeedDown();
        int direct = path.getDirect(currInstruction);
        didInstruction += Math.abs(realSpeed);
//        System.out.println(path.getDirect(currInstruction));

        setPosX(enemyPosX + realSpeed * DELTA_DIRECTION_ARRAY[direct][0]);
        setPosY(enemyPosY + realSpeed * DELTA_DIRECTION_ARRAY[direct][1]);
        degreeRotate = DEGREE_ROTATE_ARRAY[direct];

//        System.out.printf("posx = %f posy = %f dx = %f dy = %f deg = %f\n",
//                getPosX(), getPosY(), DELTA_DIRECTION_ARRAY[path.getDirect(currInstruction)][0], DELTA_DIRECTION_ARRAY[path.getDirect(currInstruction)][1], degreeRotate);

        if (didInstruction >= Math.abs(path.getLength(currInstruction))) { /// doest matter in reality, cause it will be destroyed or move to Target, just for testing
            didInstruction = 0;
            currInstruction += 1;
            if (currInstruction >= path.getNumberInstructions()) {
                doDestroy();
            }

        }
        takeBurningDamage(-((BurningBuff)buffed[0]).getRealDamage());
        for (int i = 0; i < Config.NUMBER_OF_BUFFED; i++) {
            buffed[i].tick();
        }

//
//        System.out.printf("%f %f curr = %d did = %f\n", getPosX(), getPosY(), currInstruction, didInstruction);
        /// update health;

    }
//
    public void takeBurningDamage(long value) {
        health += value;

    }
    @Override
    public double getDegreeRotate() {
        return degreeRotate;
    }

    @Override
    public void onDestroy(GameField field) {
        ///add reward for field;
        field.getGameStage().addMoney(reward);
    }

    @Override
    public boolean onEffect(GameField field, LivingEntity livingEntity) {
        livingEntity.takeDamage(-1);
        health = 0;
        return false;
    }

    @Override
    public long getHealth() {
        return health;
    }
    @Override
    public final void takeDamage(long value) {
        health += Math.min(0, value + getArmor());
    }
    @Override
    public void getBuffed(AbstractBuff buff) {
        if (buff instanceof BurningBuff) {
            buffed[0].stackToOtherBuff(buff);
        } else if (buff instanceof  FrozenBuff){
            buffed[1].stackToOtherBuff(buff);
        }
    }

    @Override
    public void doDestroy() {
        health = 0;
    }

    @Override
    public boolean isDestroyed() {
        return getHealth() <= 0;
    }

    public long getReward() { return reward; }
}
