package TowerDefense.thegame;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public final class Config {
	private static final String path = "resources/asset";
	public static final String MAP_IMAGE = "resources/map/image/Map";
	public static final String MAP_LAYOUT = "resources/map/layout/Map";
	public static final long TILE_SIZE = 64;
	public static final long TILE_HORIZONTAL = 10;
	public static final long TILE_VERTICAL = 10;

	public static final long _TILE_MAP_COUNT = TILE_HORIZONTAL * TILE_VERTICAL;

	public static final long SCREEN_WIDTH = TILE_SIZE * TILE_HORIZONTAL;
	public static final long SCREEN_HEIGHT = TILE_SIZE * TILE_VERTICAL;

	public static final long SHOP_WIDTH = 360;

	public static final long START_LAYOUT = -1;
	public static final long ROAD_LAYOUT = 1;
	public static final long END_LAYOUT = -2;
	public static final long MOUNTAIN_LAYOUT = 0;
	public static final long TOWER_LAYOUT = 420;
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
	public static final double NORMAL_BULLET_SPEED = 10;
	public static final long NORMAL_BULLET_DAMAGE = 40;
	public static final long NORMAL_BULLET_COST = 10;


	public static final long FROZEN_BULLET_DAMAGE = 10;
	public static final long FROZEN_BULLET_SPEED = 10;
	public static final long FROZEN_BULLET_COST = 10;

	public static final long BURNING_BULLET_DAMAGE = 10;
	public static final long BURNING_BULLET_SPEED = 10;
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

	public static final double MACHINE_TOWER_SCALE = 0.4;
	public static final double NORMAL_TOWER_SCALE = 1.0;
	public static final double SNIPER_TOWER_SCALE = 3.0;

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
	public static final double NORMAL_ENEMY_SIZE = 0.5 * TILE_SIZE;
	public static final long NORMAL_ENEMY_HEALTH = 100;
	public static final long NORMAL_ENEMY_ARMOR = 5;
	public static final double NORMAL_ENEMY_SPEED = 1.5;
	public static final long NORMAL_ENEMY_REWARD = 5;

	public static final double SMALLER_ENEMY_SIZE = 0.3 * TILE_SIZE;
	public static final long SMALLER_ENEMY_HEALTH = 50;
	public static final long SMALLER_ENEMY_ARMOR = 0;
	public static final double SMALLER_ENEMY_SPEED = 3;
	public static final long SMALLER_ENEMY_REWARD = 5;

	public static final double TANKER_ENEMY_SIZE = 0.7 * TILE_SIZE;
	public static final long TANKER_ENEMY_HEALTH = 300;
	public static final long TANKER_ENEMY_ARMOR = 20;
	public static final double TANKER_ENEMY_SPEED = 0.7;
	public static final long TANKER_ENEMY_REWARD = 13;

	public static final double BOSS_ENEMY_SIZE = 1.0 * TILE_SIZE;
	public static final long BOSS_ENEMY_HEALTH = 500;
	public static final long BOSS_ENEMY_ARMOR = 20;
	public static final double BOSS_ENEMY_SPEED = 0.3;
	public static final long BOSS_ENEMY_REWARD = 20;
	//endregion

	//spawn interval

	public static final long NORMAL_SPAWNINTERVAL = 300;
	public static final long NORMAL_NUM_OF_SPAWN = 10;
	public static final long NORMAL_INITDELAY = 10;

	public static final long SMALLER_SPAWNINTERVAL = 100;
	public static final long SMALLER_NUM_OF_SPAWN = 10;
	public static final long SMALLER_INITDELAY = 10;

	public static final long TANKER_SPAWNINTERVAL = 500;
	public static final long TANKER_NUM_OF_SPAWN = 3;
	public static final long TANKER_INITDELAY = 10;

	public static final long BOSS_SPAWNINTERVAL = 100;
	public static final long BOSS_NUM_OF_SPAWN = 1;
	public static final long BOSS_INITDELAY = 10;

	//end region

	// buff region
	public static final long NUMBER_OF_BUFFED = 2;
	public static final long BURNING_BUFF_TIME = 300;
	public static final long BURNING_BUFF_DAMAGE = 40;
	public static final long BURNING_BUFF_DAMAGE_INTERVAL = 100;

	public static final long FROZEN_BUFF_TIME = 100;
	public static final double FROZEN_BUFF_SPEED_DOWN = 0.5;

	public static final int MAX_PATH = 5;

    public static final String GAME_NAME = "Tower Defense";
	public static final String SAVE_FOLDER = "save/";

	public static final String THEME_SOUND_PATH = path + "/sound/ThemeSound.mp4";

	public static final String SOUND_HIT_PATH = path + "/sound/Hit.wav";

	public static final String ENEMY_HIT_SOUND_PATH = path + "/sound/EnemyHitSound.mp3";

	public static final String VICTORY_SOUND_PATH = path + "/sound/Victory.mp3";

	public static final String DEFEAT_SOUND_PATH = path + "/sound/Defeat.mp3";

	public static final String MINION_SPAWMING_PATH = path + "/sound/MinionSpawning.mp3";


	public static MediaPlayer THEME_SOUND = new MediaPlayer(new Media(new File(Config.THEME_SOUND_PATH).toURI().toString()));

	public static void setSound() {
		THEME_SOUND.setVolume(0.05);
	}

    private Config() {}
}
