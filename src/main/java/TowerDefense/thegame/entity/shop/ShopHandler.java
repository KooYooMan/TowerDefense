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

    private HBox utilitiesHBox = new HBox();
    private Button pauseButton;
    private Button resumeButton;

    public ShopHandler(Pane pane) throws IOException {
        this.buttonContainerDrawer = new ButtonContainerDrawer(pane);

        this.pauseButton = new Button("", new ImageView(new Image(
                new FileInputStream("resources/icon/pause.png")
        )));
        this.resumeButton = new Button("", new ImageView(new Image(
                new FileInputStream("resources/icon/resume.png")
        )));

        this.utilitiesHBox.setSpacing(24);
        this.utilitiesHBox.setLayoutY(582);
        this.utilitiesHBox.getChildren().addAll(pauseButton, resumeButton);

        pane.getChildren().add(utilitiesHBox);
    }

    public List<TowerButtonDrawer> getTowerButtonDrawerList() { return buttonContainerDrawer.getTowerButtonDrawerList(); }
    public List<BulletButtonDrawer> getBulletButtonDrawerList() { return buttonContainerDrawer.getBulletButtonDrawerList(); }
    public Button getSellingTowerButton() { return buttonContainerDrawer.getSellingTowerButton(); }
    public Button getUpgradingTowerButton() { return buttonContainerDrawer.getUpgradingTowerButton(); }

    public Button getPauseButton() { return pauseButton; }
    public Button getResumeButton() { return resumeButton; }
}
