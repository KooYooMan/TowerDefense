package TowerDefense.thegame;

public final class Config {
	private static final String path = "target/classes";

	public static final double SCREEN_WIDTH = 400;
	public static final double SCREEN_HEIGHT = 400;

	public static final double NORMAL_BULLET_WIDTH = 30;
	public static final double NORMAL_BULLET_HEIGHT = 30;

	public static final double EXPLODING_BULLET_WIDTH = 45;
	public static final double EXPLODING_BULLET_HEIGHT = 45;

	public static final double NORMAL_BULLET_SPEED = 3;
	public static final double FAST_BULLET_SPEED = 4;

	public static final long NORMAL_BULLET_DAMAGE = 10;
	public static final long HIGH_DAMAGE_BULLET = 20;
	public static final long BURNING_BULLET_DAMAGE = 7;

	public static final long TIME_FROZEN_BULLET = 4;
	public static final long TIME_BURNING_BULLET = 4;

	public static final double FROZEN_SPEED = 10;

	public static final double NORMAL_TOWER_RANGE = 200;
	public static final double SNIPER_TOWER_RANGE = 250;
	public static final double MACHINE_GUN_TOWER_RANGE = 150;

	public static final long NORMAL_TOWER_SPEED = 15;
	public static final long SNIPER_TOWER_SPEED = 20;
	public static final long MACHINE_GUN_TOWER_SPEED = 10;

	public static final long BULLET_ADD_SPEED = 2;

	public static final String MACHINE_TOWER_IMAGE = path + "/tower/MachineGunTower.png";
	public static final String NORMAL_TOWER_IMAGE = path + "/tower/181.png";
	public static final String SNIPER_TOWER_IMAGE = path + "/tower/SniperTower.png";

	public static final String MACHINE_GUN_IMAGE = path + "/gun/MachineGun.png";
	public static final String NORMAL_GUN_IMAGE = path + "/gun/NormalGun.png";
	public static final String SNIPER_GUN_IMAGE = path + "/gun/SniperGun.png";

	public static final String BURNING_BULLET_IMAGE = path + "/bullet/BurningBullet.png";
	public static final String EXPLODING_BULLET_IMAGE = path + "/bullet/ExplodingBullet.png";
	public static final String FAST_BULLET_IMAGE = path + "/bullet/FastBullet.png";
	public static final String HIGH_DAMAGE_BULLET_IMAGE = path + "/bullet/HighDamageBullet.png";
	public static final String NORMAL_BULLET_IMAGE = path + "/bullet/NormalBullet.png";
	public static final String FROZEN_BULLET_IMAGE = path + "/bullet/FrozenBullet.png";

	public static final double NORMAL_GUN_WIDTH = 60;
	public static final double MACHINE_GUN_WIDTH = 60;
	public static final double SNIPER_GUN_WIDTH = 60;

	public static final double NORMAL_GUN_HEIGHT = 60;
	public static final double MACHINE_GUN_HEIGHT = 60;
	public static final double SNIPER_GUN_HEIGHT = 60;

	public static final double MACHINE_TOWER_WIDTH = 60;
	public static final double NORMAL_TOWER_WIDTH = 60;
	public static final double SNIPER_TOWER_WIDTH = 60;

	public static final double MACHINE_TOWER_HEIGHT = 60;
	public static final double NORMAL_TOWER_HEIGHT = 60;
	public static final double SNIPER_TOWER_HEIGHT = 60;

	//region Enemy
	public static final double NORMAL_ENEMY_SIZE = 0.9;
	public static final long NORMAL_ENEMY_HEALTH = 100;
	public static final long NORMAL_ENEMY_ARMOR = 3;
	public static final double NORMAL_ENEMY_SPEED = 0.3;
	public static final long NORMAL_ENEMY_REWARD = 1;

	public static final double SMALLER_ENEMY_SIZE = 0.7;
	public static final long SMALLER_ENEMY_HEALTH = 50;
	public static final long SMALLER_ENEMY_ARMOR = 0;
	public static final double SMALLER_ENEMY_SPEED = 0.4;
	public static final long SMALLER_ENEMY_REWARD = 2;

	public static final double TANKER_ENEMY_SIZE = 1.1;
	public static final long TANKER_ENEMY_HEALTH = 300;
	public static final long TANKER_ENEMY_ARMOR = 5;
	public static final double TANKER_ENEMY_SPEED = 0.2;
	public static final long TANKER_ENEMY_REWARD = 3;

	public static final double BOSS_ENEMY_SIZE = 1.3;
	public static final long BOSS_ENEMY_HEALTH = 500;
	public static final long BOSS_ENEMY_ARMOR = 8;
	public static final double BOSS_ENEMY_SPEED = 0.3;
	public static final long BOSS_ENEMY_REWARD = 10;
	//endregion



	public static final String GAME_NAME = "Tower Defense";
}
