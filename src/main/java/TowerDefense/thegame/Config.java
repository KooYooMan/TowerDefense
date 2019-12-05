package TowerDefense.thegame;

public final class Config {
	private static final String path = "resources/asset";
	public static final long TILE_SIZE = 64;

	public static final long TILE_HORIZONTAL = 10;
	public static final long TILE_VERTICAL = 10;

	public static final long _TILE_MAP_COUNT = TILE_HORIZONTAL * TILE_VERTICAL;

	public static final long SCREEN_WIDTH = TILE_SIZE * TILE_HORIZONTAL;
	public static final long SCREEN_HEIGHT = TILE_SIZE * TILE_VERTICAL;

	public static final long SHOP_WIDTH = 360;


	// Tile region
	public static final double MOUNTAIN_WIDTH = TILE_SIZE * 1.0;
	public static final double MOUNTAIN_HEIGHT = TILE_SIZE * 1.0;

	public static final double ROAD_WIDTH = TILE_SIZE * 1.0;
	public static final double ROAD_HEIGHT = TILE_SIZE * 1.0;

	public static final long TARGET_HEALTH = 100;
	public static final double TARGET_WIDTH = TILE_SIZE;
	public static final double TARGET_HEIGHT = TILE_SIZE;
	// Tile
	public static final double NORMAL_BULLET_WIDTH = 10;
	public static final double NORMAL_BULLET_HEIGHT = 10;
	public static final double NORMAL_BULLET_SPEED = 3;
	public static final long NORMAL_BULLET_DAMAGE = 20;
	public static final long NORMAL_BULLET_COST = 10;


	public static final long FROZEN_BULLET_DAMAGE = 10;
	public static final long FROZEN_BULLET_SPEED = 40;
	public static final long FROZEN_BULLET_COST = 10;

	public static final long BURNING_BULLET_DAMAGE = 10;
	public static final long BURNING_BULLET_SPEED = 40;
	public static final long BURNING_BULLET_COST = 10;


	public static final double NORMAL_TOWER_RANGE = TILE_SIZE * 4;
	public static final double SNIPER_TOWER_RANGE = TILE_SIZE * 5;
	public static final double MACHINE_GUN_TOWER_RANGE = TILE_SIZE * 2;

	public static final long NORMAL_TOWER_SPEED = 50;
	public static final long SNIPER_TOWER_SPEED = 100;
	public static final long MACHINE_GUN_TOWER_SPEED = 10;



	public static final long BULLET_ADD_SPEED = 2;

	public static final String MACHINE_TOWER_IMAGE = path + "/tower/MachineGunTower.png";
	public static final String NORMAL_TOWER_IMAGE = path + "/tower/NormalTower.png";
	public static final String SNIPER_TOWER_IMAGE = path + "/tower/SniperTower.png";

	public static final String MACHINE_GUN_IMAGE = path + "/gun/MachineGun.png";
	public static final String NORMAL_GUN_IMAGE = path + "/gun/NormalGun.png";
	public static final String SNIPER_GUN_IMAGE = path + "/gun/SniperGun.png";


	public static final int NORMAL_TOWER_BULLET_TIME = 100;
	public static final int SNIPER_TOWER_BULLET_TIME = 100;
	public static final int MACHINE_GUN_TOWER_BULLET_TIME = 100;


	public static final String BURNING_BULLET_IMAGE = path + "/bullet/BurningBullet.png";
	public static final String FROZEN_BULLET_IMAGE = path + "/bullet/FrozenBullet.png";
	public static final String NORMAL_BULLET_IMAGE = path + "/bullet/NormalBullet.png";

	public static final double NORMAL_GUN_WIDTH = TILE_SIZE * 1.0;
	public static final double MACHINE_GUN_WIDTH = TILE_SIZE * 1.0;
	public static final double SNIPER_GUN_WIDTH = TILE_SIZE * 1.0;

	public static final double NORMAL_GUN_HEIGHT = TILE_SIZE * 1.0;
	public static final double MACHINE_GUN_HEIGHT = TILE_SIZE * 1.0;
	public static final double SNIPER_GUN_HEIGHT = TILE_SIZE * 1.0;

	public static final double MACHINE_TOWER_WIDTH = TILE_SIZE * 1.0;
	public static final double NORMAL_TOWER_WIDTH = TILE_SIZE * 1.0;
	public static final double SNIPER_TOWER_WIDTH = TILE_SIZE * 1.0;

	public static final double MACHINE_TOWER_HEIGHT = TILE_SIZE * 1.0;
	public static final double NORMAL_TOWER_HEIGHT = TILE_SIZE * 1.0;
	public static final double SNIPER_TOWER_HEIGHT = TILE_SIZE * 1.0;

	public static final double MACHINE_TOWER_SCALE = 1.0;
	public static final double NORMAL_TOWER_SCALE = 0.7;
	public static final double SNIPER_TOWER_SCALE = 2.0;

	public static final double MACHINE_TOWER_UPGRADED_SCALE = 1.3;
	public static final double NORMAL_TOWER_UPGRADED_SCALE = 1.2;
	public static final double SNIPER_TOWER_UPGRADED_SCALE = 2.0;


	public static final long MACHINE_TOWER_COST = 10;
	public static final long NORMAL_TOWER_COST = 20;
	public static final long SNIPER_TOWER_COST = 30;

	public static final long MACHINE_TOWER_UPGRADED_COST = 10;
	public static final long NORMAL_TOWER_UPGRADED_COST = 20;
	public static final long SNIPER_TOWER_UPGRADED_COST = 30;



	public static final double GUN_ROTATE_SPEED = 1;



	//region Enemy
	public static final double NORMAL_ENEMY_SIZE = 0.4 * TILE_SIZE;
	public static final long NORMAL_ENEMY_HEALTH = 100;
	public static final long NORMAL_ENEMY_ARMOR = 100;
	public static final double NORMAL_ENEMY_SPEED = 0.3;
	public static final long NORMAL_ENEMY_REWARD = 1;

	public static final double SMALLER_ENEMY_SIZE = 0.4 * TILE_SIZE;
	public static final long SMALLER_ENEMY_HEALTH = 50;
	public static final long SMALLER_ENEMY_ARMOR = 0;
	public static final double SMALLER_ENEMY_SPEED = 0.4;
	public static final long SMALLER_ENEMY_REWARD = 2;

	public static final double TANKER_ENEMY_SIZE = 0.7 * TILE_SIZE;
	public static final long TANKER_ENEMY_HEALTH = 300;
	public static final long TANKER_ENEMY_ARMOR = 5;
	public static final double TANKER_ENEMY_SPEED = 0.2;
	public static final long TANKER_ENEMY_REWARD = 3;

	public static final double BOSS_ENEMY_SIZE = 1.0 * TILE_SIZE;
	public static final long BOSS_ENEMY_HEALTH = 500;
	public static final long BOSS_ENEMY_ARMOR = 8;
	public static final double BOSS_ENEMY_SPEED = 0.3;
	public static final long BOSS_ENEMY_REWARD = 10;
	//endregion

	//spawn interval

	public static final long NORMAL_SPAWNINTERVAL = 300;
	public static final long NORMAL_NUM_OF_SPAWN = 10;
	public static final long NORMAL_INITDELAY = 10;

	public static final long SMALLER_SPAWNINTERVAL = 100;
	public static final long SMALLER_NUM_OF_SPAWN = 10;
	public static final long SMALLER_INITDELAY = 10;

	public static final long TANKER_SPAWNINTERVAL = 500;
	public static final long TANKER_NUM_OF_SPAWN = 10;
	public static final long TANKER_INITDELAY = 10;

	public static final long BOSS_SPAWNINTERVAL = 100;
	public static final long BOSS_NUM_OF_SPAWN = 1;
	public static final long BOSS_INITDELAY = 10;

	//end region

	// buff region
	public static final long NUMBER_OF_BUFFED = 2;
	public static final long BURNING_BUFF_TIME = 300;
	public static final long BURNING_BUFF_DAMAGE = 10;
	public static final long BURNING_BUFF_DAMAGE_INTERVAL = 100;

	public static final long FROZEN_BUFF_TIME = 100;
	public static final double FROZEN_BUFF_SPEED_DOWN = 0.5;

	public static final int MAX_PATH = 5;

    public static final String GAME_NAME = "Tower Defense";


    private Config() {}
}
