package TowerDefense.thegame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public final class Main extends Application {

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		final Canvas gameCanvas = new Canvas(Config.SCREEN_WIDTH, Config.SCREEN_HEIGHT);
		final Canvas shopCanvas = new Canvas(Config.SHOP_WIDTH, Config.SCREEN_HEIGHT);

		final Pane gamePane = new StackPane(gameCanvas);
		final Pane shopPane = new StackPane(shopCanvas);

		final GraphicsContext gameGraphicsContext = gameCanvas.getGraphicsContext2D();
		final GraphicsContext shopGraphicsContext = shopCanvas.getGraphicsContext2D();
		final GameController gameController = new GameController(gameGraphicsContext, gamePane);
		final ShopController shopController = new ShopController(shopGraphicsContext, shopPane);
		final MainController mainController = new MainController(gameController, shopController);

		primaryStage.setResizable(false);
		primaryStage.setTitle(Config.GAME_NAME);
		primaryStage.setScene(new Scene(new HBox(gamePane, shopPane)));
		primaryStage.show();

//		gameController.start();
//		shopController.start();
		mainController.start();
	}
}