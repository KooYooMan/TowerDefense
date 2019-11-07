package TowerDefense.thegame;

import TowerDefense.thegame.drawer.bullet.FrozenBulletDrawer;
import TowerDefense.thegame.entity.GameEntity;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public final class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		final Canvas canvas = new Canvas(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
		final GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
		final GameController gameController = new GameController(graphicsContext);

		primaryStage.setResizable(false);
		primaryStage.setTitle(Config.GAME_NAME);
		primaryStage.setScene(new Scene(new StackPane(canvas)));
		primaryStage.show();

		gameController.start();
	}
}