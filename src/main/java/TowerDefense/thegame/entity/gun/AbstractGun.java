package TowerDefense.thegame.entity.gun;

import TowerDefense.thegame.Config;
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
        this.degreeRotate += Config.GUN_ROTATE_SPEED;
        if (this.degreeRotate >= 360) this.degreeRotate -= 360;
    }

    public void update(double x, double y) {
        double centerX = this.getPosX() + this.getWidth() / 2, centerY = this.getPosY() + this.getHeight() / 2;
        double foo = Math.atan2(x - centerX, y - centerY);
        foo += 2 * Math.PI;
        if (foo >= 2 * Math.PI) foo -= 2 * Math.PI;
        this.degreeRotate = (foo / (2 * Math.PI)) * 360;
    }
}
