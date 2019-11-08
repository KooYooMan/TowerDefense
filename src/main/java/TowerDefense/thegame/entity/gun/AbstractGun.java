package TowerDefense.thegame.entity.gun;

import TowerDefense.thegame.GameField;
import TowerDefense.thegame.entity.AbstractEntity;
import TowerDefense.thegame.entity.RotatableEntity;
import TowerDefense.thegame.entity.UpdatableEntity;

public class AbstractGun extends AbstractEntity implements UpdatableEntity, RotatableEntity {
    private double degreeRotate;

    protected AbstractGun(double posX, double posY, double width, double height) {
        super(posX, posY, width, height);
        this.degreeRotate = 0;
    }

    @Override
    public double getDegreeRotate() {
        return this.degreeRotate;
    }

    @Override
    public void onUpdate(GameField field) {
        this.degreeRotate += 10;
        if (this.degreeRotate >= 360) this.degreeRotate -= 360;
    }
}
