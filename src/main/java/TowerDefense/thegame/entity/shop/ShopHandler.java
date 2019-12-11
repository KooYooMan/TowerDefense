package TowerDefense.thegame.entity.shop;

import TowerDefense.thegame.drawer.shop.button.BulletButtonDrawer;
import TowerDefense.thegame.drawer.shop.button.ButtonContainerDrawer;
import TowerDefense.thegame.drawer.shop.button.TowerButtonDrawer;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class ShopHandler {
    private ButtonContainerDrawer buttonContainerDrawer;

    private HBox autoplayHBox = new HBox();
    private Button enableAutoButton;
    private Button disableAutoButton;

    private HBox utilitiesHBox = new HBox();
    private Button pauseButton;
    private Button resumeButton;
    private Button saveButton;
    private Button exitButton;

    public ShopHandler(Pane pane) throws IOException {
        this.buttonContainerDrawer = new ButtonContainerDrawer(pane);

        this.enableAutoButton = new Button("", new ImageView(new Image(
                new FileInputStream("resources/icon/ai.png")
        )));
        this.disableAutoButton = new Button("", new ImageView(new Image(
                new FileInputStream("resources/icon/noai.png")
        )));
        this.autoplayHBox.setSpacing(32);
        this.autoplayHBox.setLayoutY(496);
        this.autoplayHBox.getChildren().addAll(enableAutoButton, disableAutoButton);

        this.pauseButton = new Button("", new ImageView(new Image(
                new FileInputStream("resources/icon/pause.png")
        )));
        this.resumeButton = new Button("", new ImageView(new Image(
                new FileInputStream("resources/icon/resume.png")
        )));
        this.saveButton = new Button("", new ImageView(new Image(
                new FileInputStream("resources/icon/save.png")
        )));
        this.exitButton = new Button("", new ImageView(new Image(
                new FileInputStream("resources/icon/exit.png")
        )));
        this.utilitiesHBox.setSpacing(32);
        this.utilitiesHBox.setLayoutY(582);
        this.utilitiesHBox.getChildren().addAll(pauseButton, resumeButton, saveButton, exitButton);

        pane.getChildren().addAll(autoplayHBox, utilitiesHBox);
    }

    public List<TowerButtonDrawer> getTowerButtonDrawerList() { return buttonContainerDrawer.getTowerButtonDrawerList(); }
    public List<BulletButtonDrawer> getBulletButtonDrawerList() { return buttonContainerDrawer.getBulletButtonDrawerList(); }
    public Button getSellingTowerButton() { return buttonContainerDrawer.getSellingTowerButton(); }
    public Button getUpgradingTowerButton() { return buttonContainerDrawer.getUpgradingTowerButton(); }

    public Button getEnableAutoButton() { return enableAutoButton; }
    public Button getDisableAutoButton() { return disableAutoButton; }

    public Button getPauseButton() { return pauseButton; }
    public Button getResumeButton() { return resumeButton; }
    public Button getSaveButton() { return saveButton; }
    public Button getExitButton() { return exitButton; }
}
