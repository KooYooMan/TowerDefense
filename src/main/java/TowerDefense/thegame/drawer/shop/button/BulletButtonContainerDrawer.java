package TowerDefense.thegame.drawer.shop.button;

import TowerDefense.thegame.drawer.shop.icon.AbstractIconDrawer;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BulletButtonContainerDrawer {
    private final HBox bulletButtonHBox = new HBox();
    private List<BulletButtonDrawer> bulletButtonDrawerList;
    private Button upgradingTowerButton;

    public BulletButtonContainerDrawer(VBox vBox, List<AbstractIconDrawer> iconDrawerList) throws IOException {
        this.bulletButtonDrawerList = new ArrayList<>(List.of(
                new NormalBulletButtonDrawer(bulletButtonHBox, iconDrawerList.get(0)),
                new BurningBulletButtonDrawer(bulletButtonHBox, iconDrawerList.get(1)),
                new FrozenBulletButtonDrawer(bulletButtonHBox, iconDrawerList.get(2))
        ));

        ImageView upgradingTower = new ImageView(new Image(
                new FileInputStream("resources/icon/upgrade.png")
        ));
        upgradingTower.setFitHeight(48);
        upgradingTower.setFitWidth(48);

        this.upgradingTowerButton = new Button("", upgradingTower);

        this.bulletButtonHBox.getChildren().add(upgradingTowerButton);

        bulletButtonHBox.setSpacing(32);

        vBox.getChildren().add(bulletButtonHBox);
    }

    public List<BulletButtonDrawer> getBulletButtonDrawerList() { return bulletButtonDrawerList; }

    public Button getUpgradingTowerButton() { return upgradingTowerButton; }
}
