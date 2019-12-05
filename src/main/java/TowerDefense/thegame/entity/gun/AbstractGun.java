package TowerDefense.thegame.entity.gun;

import TowerDefense.thegame.entity.AbstractEntity;
import TowerDefense.thegame.entity.RotatableEntity;

public abstract class AbstractGun extends AbstractEntity implements RotatableEntity {
    private double degreeRotate;

    protected AbstractGun(double posX, double posY, double width, double height) {
        super(posX, posY, width, height);
        this.degreeRotate = 0;
    }

    @Override
    public double getDegreeRotate() {
        return this.degreeRotate;
    }

    public void update(double x, double y) {
        double foo = Math.atan2(x, y);
        foo += 2 * Math.PI;
        if (foo >= 2 * Math.PI) foo -= 2 * Math.PI;
        this.degreeRotate = (foo / (2 * Math.PI)) * 360;
    }
}
