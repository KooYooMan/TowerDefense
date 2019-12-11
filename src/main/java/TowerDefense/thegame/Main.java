package TowerDefense.thegame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileInputStream;

public final class Main extends Application {
	//SSSDSSDDSSDSDSSSSSSSSSDSDS
	public static void main(String[] args) {
        Config.setSound();
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		final Canvas startScreenCanvas = new Canvas(Config.SCREEN_WIDTH + Config.SHOP_WIDTH, Config.SCREEN_HEIGHT);
		final Canvas closingScreenCanvas = new Canvas(Config.SCREEN_WIDTH + Config.SHOP_WIDTH, Config.SCREEN_HEIGHT);
		final Canvas gameCanvas = new Canvas(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
		final Canvas shopCanvas = new Canvas(Config.SHOP_WIDTH, Config.SCREEN_HEIGHT);

		final Pane startScreenPane = new Pane(startScreenCanvas);
		final Pane closingScreenPane = new Pane(closingScreenCanvas);
		final Pane gamePane = new Pane(gameCanvas);
		final Pane shopPane = new Pane(shopCanvas);
		//final Pane allPane = new StackPane(new HBox(gamePane, shopPane), startScreenPane);

		final Scene primaryScene = new Scene(startScreenPane);

		final GraphicsContext startScreenGraphicsContext = startScreenCanvas.getGraphicsContext2D();
		final GraphicsContext closingScreenGraphicsContext = closingScreenCanvas.getGraphicsContext2D();
		final GraphicsContext gameGraphicsContext = gameCanvas.getGraphicsContext2D();
		final GraphicsContext shopGraphicsContext = shopCanvas.getGraphicsContext2D();

		final StartScreenController startScreenController = new StartScreenController(startScreenGraphicsContext, startScreenPane);
		final ClosingScreenController closingScreenController = new ClosingScreenController(closingScreenGraphicsContext, closingScreenPane);
		final GameController gameController = new GameController(gameGraphicsContext, gamePane);
		final ShopController shopController = new ShopController(shopGraphicsContext, shopPane);

		final MainController mainController = new MainController(primaryScene, startScreenController,
				closingScreenController, gameController, shopController
		);
		
		primaryStage.setResizable(false);
		primaryStage.setTitle(Config.GAME_NAME);
		primaryStage.getIcons().add(new Image(new FileInputStream("resources/icon/icon.png")));
        Config.THEME_SOUND.setOnEndOfMedia(new Runnable() {
            public void run() {
                Config.THEME_SOUND.seek(Duration.ZERO);
            }
        });
		Config.THEME_SOUND.play();

		//primaryStage.setScene(new Scene(allPane));
		primaryStage.setScene(primaryScene);
		primaryStage.show();

//		gameController.start();
//		shopController.start();
		mainController.start();
	}
}