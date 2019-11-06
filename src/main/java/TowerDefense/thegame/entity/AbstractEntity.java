package TowerDefense.thegame.entity;

public abstract class AbstractEntity implements GameEntity {
	private double posX;
	private double posY;
	private double width;
	private double height;

	protected AbstractEntity(double posX, double posY, double width, double height) {
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
	}

	@Override
	public final double getPosX() {
		return posX;
	}

	protected final void setPosX(double posX) {
		this.posX = posX;
	}

	@Override
	public final double getPosY() {
		return posY;
	}

	protected final void setPosY(double posY) {
		this.posY = posY;
	}

	@Override
	public final double getWidth() {
		return width;
	}

	protected final void setWidth(double width) {
		this.width = width;
	}

	@Override
	public final double getHeight() {
		return height;
	}

	protected final void setHeight(double height) {
		this.height = height;
	}

	@Override
	public final boolean isContaining(double posX, double posY, double width, double height) {
		return this.posX <= posX
				&& this.posY <= posY
				&& this.posX + this.width >= posX + width
				&& this.posY + this.height >= posY + height;
	}

	@Override
	public final boolean isBeingContained(double posX, double posY, double width, double height) {
		return posX <= this.posX
				&& posY <= this.posY
				&& posX + width >= this.posX + this.width
				&& posY + height >= this.posY + this.height;
	}

	@Override
	public final boolean isBeingOverlapped(double posX, double posY, double width, double height) {
		return posX < this.posX + this.width
				&& posY < this.posY + this.height
				&& posX + width > this.posX
				&& posY + height > this.posY;
	}
}
