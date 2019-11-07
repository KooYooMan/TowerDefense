package TowerDefense.thegame;

public final class Config {
	public static final long TILE_SIZE = 64;

	public static final long TILE_HORIZONTAL = 10;
	public static final long TILE_VERTICAL = 10;

	public static final long SCREEN_WIDTH = TILE_SIZE * TILE_HORIZONTAL;
	public static final long SCREEN_HEIGHT = TILE_SIZE * TILE_VERTICAL;

	public static final long SHOP_WIDTH = 360;

	public static final double NORMAL_BULLET_WIDTH = 10;
	public static final double NORMAL_BULLET_HEIGHT = 10;

	public static final double EXPLODING_BULLET_WIDTH = 20;
	public static final double EXPLODING_BULLET_HEIGHT = 20;

	public static final double NORMAL_BULLET_SPEED = 3;
	public static final double FAST_BULLET_SPEED = 4;

	public static final long NORMAL_BULLET_DAMAGE = 10;
	public static final long HIGH_DAMAGE_BULLET = 20;
	public static final long BURNING_BULLET_DAMAGE = 7;

	public static final long TIME_FROZEN_BULLET = 4;
	public static final long TIME_BURNING_BULLET = 4;

	public static final double FROZEN_SPEED = 10;

	public static final String GAME_NAME = "Tower Defense";

	private Config() {}
}
