package TowerDefense.thegame.drawer;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.GameField;
import TowerDefense.thegame.drawer.bullet.BurningBulletDrawer;
import TowerDefense.thegame.drawer.bullet.FrozenBulletDrawer;
import TowerDefense.thegame.drawer.bullet.NormalBulletDrawer;
import TowerDefense.thegame.drawer.enemy.BossEnemyDrawer;
import TowerDefense.thegame.drawer.enemy.NormalEnemyDrawer;
import TowerDefense.thegame.drawer.enemy.SmallerEnemyDrawer;
import TowerDefense.thegame.drawer.enemy.TankerEnemyDrawer;
import TowerDefense.thegame.drawer.gun.MachineGunDrawer;
import TowerDefense.thegame.drawer.gun.NormalGunDrawer;
import TowerDefense.thegame.drawer.gun.SniperGunDrawer;
import TowerDefense.thegame.drawer.stage.StageDrawer;
import TowerDefense.thegame.drawer.target.TargetDrawer;
import TowerDefense.thegame.drawer.tower.MachineTowerDrawer;
import TowerDefense.thegame.drawer.tower.NormalTowerDrawer;
import TowerDefense.thegame.drawer.tower.SniperTowerDrawer;
import TowerDefense.thegame.entity.GameEntity;
import TowerDefense.thegame.entity.RotatableEntity;
import TowerDefense.thegame.entity.bullet.BurningBullet;
import TowerDefense.thegame.entity.bullet.FrozenBullet;
import TowerDefense.thegame.entity.bullet.NormalBullet;
import TowerDefense.thegame.entity.enemy.BossEnemy;
import TowerDefense.thegame.entity.enemy.NormalEnemy;
import TowerDefense.thegame.entity.enemy.SmallerEnemy;
import TowerDefense.thegame.entity.enemy.TankerEnemy;
import TowerDefense.thegame.entity.gun.MachineGun;
import TowerDefense.thegame.entity.gun.NormalGun;
import TowerDefense.thegame.entity.gun.SniperGun;
import TowerDefense.thegame.entity.stage.StageLoader;
import TowerDefense.thegame.entity.tile.Target;
import TowerDefense.thegame.entity.tile.tower.AbstractTower;
import TowerDefense.thegame.entity.tile.tower.MachineGunTower;
import TowerDefense.thegame.entity.tile.tower.NormalTower;
import TowerDefense.thegame.entity.tile.tower.SniperTower;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GameDrawer {
	private static final List<Class<?>> ENTITY_DRAWING_ORDER = List.of(
		MachineGunTower.class,
		NormalTower.class,
		SniperTower.class,

		MachineGun.class,
		NormalGun.class,
		SniperGun.class,

		NormalBullet.class,
		FrozenBullet.class,
		BurningBullet.class,

		SmallerEnemy.class,
		NormalEnemy.class,
		TankerEnemy.class,
		BossEnemy.class,


		Target.class

	);

	private static final Map<Class<? extends GameEntity>, EntityDrawer> ENTITY_DRAWER_MAP = new HashMap<>(Map.ofEntries(
			Map.entry(MachineGunTower.class, new MachineTowerDrawer()),
			Map.entry(NormalTower.class, new NormalTowerDrawer()),
			Map.entry(SniperTower.class, new SniperTowerDrawer()),

			Map.entry(MachineGun.class, new MachineGunDrawer()),
			Map.entry(NormalGun.class, new NormalGunDrawer()),
			Map.entry(SniperGun.class, new SniperGunDrawer()),

			Map.entry(NormalBullet.class, new NormalBulletDrawer()),
			Map.entry(BurningBullet.class, new BurningBulletDrawer()),
			Map.entry(FrozenBullet.class, new FrozenBulletDrawer()),

			Map.entry(BossEnemy.class, new BossEnemyDrawer()),
			Map.entry(TankerEnemy.class, new TankerEnemyDrawer()),
			Map.entry(NormalEnemy.class, new NormalEnemyDrawer()),
			Map.entry(SmallerEnemy.class, new SmallerEnemyDrawer()),

			Map.entry(Target.class, new TargetDrawer())
	));

	private final GraphicsContext graphicsContext;
	private GameField gameField;
	private StageDrawer stageDrawer;
	private StageLoader stageLoader;
	private MoneyDrawer moneyDrawer;
	private WaveDrawer waveDrawer;

	public GameDrawer(GraphicsContext graphicsContext, GameField gameField) {
		this.graphicsContext = graphicsContext;
		try {
			this.graphicsContext.setFont(Font.loadFont(new FileInputStream("target/classes/font/pkmnfl.ttf"), 24));
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.gameField = gameField;

		try {
			this.stageLoader = StageLoader.nullStage();
			this.stageDrawer = new StageDrawer(graphicsContext, stageLoader);
			this.moneyDrawer = new MoneyDrawer(graphicsContext);
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.waveDrawer = new WaveDrawer(graphicsContext);
	}

	private static int entityDrawingOrderComparator(GameEntity entityA, GameEntity entityB) {
		final int compareOrder = Integer.compare(
				ENTITY_DRAWING_ORDER.indexOf(entityA.getClass()),
				ENTITY_DRAWING_ORDER.indexOf(entityB.getClass())
		);
		if (compareOrder != 0) return compareOrder;
		final int comparePosX = Double.compare(entityA.getPosX(), entityB.getPosX());
		if (comparePosX != 0) return comparePosX;
		final int comparePosY = Double.compare(entityA.getPosY(), entityB.getPosY());
		if (comparePosY != 0) return comparePosY;
		final int compareWidth = Double.compare(entityA.getWidth(), entityB.getWidth());
		if (compareWidth != 0) return compareWidth;
		return Double.compare(entityA.getHeight(), entityB.getHeight());
	}

	private static EntityDrawer getEntityDrawer(GameEntity entity) {
		return ENTITY_DRAWER_MAP.get(entity.getClass());
	}

	public final void setGameField(GameField gameField) {
		this.gameField = gameField;
	}

	public final void render(){
		final GameField gameField = this.gameField;
		final List<GameEntity> entities = gameField.getEntities();
		graphicsContext.clearRect(0.0, 0.0, Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);

		stageDrawer.draw();

		for (final GameEntity entity : entities) {
			final EntityDrawer drawer = getEntityDrawer(entity);
			if (drawer != null) {
				if (entity instanceof RotatableEntity) {
					drawer.draw(this.graphicsContext, entity, entity.getPosX(), entity.getPosY(), entity.getWidth(),
							entity.getHeight(), ((RotatableEntity) entity).getDegreeRotate());
				} else {
					drawer.draw(this.graphicsContext, entity, entity.getPosX(), entity.getPosY(), entity.getWidth(),
							entity.getHeight(), 0);
				}

				if (entity instanceof AbstractTower) {
					this.graphicsContext.setFill(Color.BLACK);
					this.graphicsContext.fillText(Integer.toString(((AbstractTower) entity).getLevel()),
							entity.getPosX(), entity.getPosY() + entity.getHeight());
				}
			}
		}

		moneyDrawer.draw(gameField.getGameStage().getMoney());
		waveDrawer.draw(gameField.getGameWave().getCurrentWaveID(), gameField.getGameWave().getNumberWave());
	}

	public StageDrawer getStageDrawer() { return stageDrawer; }
	public StageLoader getStageLoader() { return stageLoader; }
	public GraphicsContext getGraphicsContext() { return graphicsContext; }

	public int getCurrentMap() { return stageLoader.getCurrentMap(); }

	public void setStageLoader(StageLoader stageLoader) { this.stageLoader = stageLoader; }
	public void setStageDrawer(StageDrawer stageDrawer) { this.stageDrawer = stageDrawer; }

	public void setMap(int i) {
		try {
			this.stageLoader = StageLoader.loadStage(i);

			if (stageLoader != null) {
				this.stageDrawer = new StageDrawer(this.graphicsContext, this.stageLoader);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class MoneyDrawer {
	private Image image;
	private GraphicsContext graphicsContext;

	public MoneyDrawer(GraphicsContext graphicsContext) throws FileNotFoundException {
		this.image = new Image(new FileInputStream("target/classes/icon/coin.png"));
		this.graphicsContext = graphicsContext;
	}

	public void draw(long money) {
		graphicsContext.drawImage(image, 5, 0, 24, 24);
		graphicsContext.setFill(Color.BLACK);
		graphicsContext.fillText(Long.toString(money), 37, 21);
	}
}

class WaveDrawer {
	private GraphicsContext graphicsContext;

	public WaveDrawer(GraphicsContext graphicsContext) {
		this.graphicsContext = graphicsContext;
	}

	public void draw(int currentWave, int waveNumber) {
		graphicsContext.setFill(Color.BLACK);
		graphicsContext.fillText("Wave: " + currentWave + "/" + waveNumber, 5, 48);
	}
}
