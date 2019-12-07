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

public class TowerButtonContainerDrawer {
    private final HBox towerButtonHBox = new HBox();
    private List<TowerButtonDrawer> towerButtonDrawerList;
    private Button sellingTowerButton;

    public TowerButtonContainerDrawer(VBox vBox, List<AbstractIconDrawer> iconDrawerList) throws IOException {
        this.towerButtonDrawerList = new ArrayList<>(List.of(
                new NormalGunTowerButtonDrawer(towerButtonHBox, iconDrawerList.get(0)),
                new MachineGunTowerButtonDrawer(towerButtonHBox, iconDrawerList.get(1)),
                new SniperGunTowerButtonDrawer(towerButtonHBox, iconDrawerList.get(2))
        ));

        ImageView sellingTower = new ImageView(new Image(
                new FileInputStream("resources/icon/x.png")
        ));
        sellingTower.setFitHeight(48);
        sellingTower.setFitWidth(48);

        this.sellingTowerButton = new Button("", sellingTower);

        this.towerButtonHBox.getChildren().add(sellingTowerButton);

        towerButtonHBox.setSpacing(32);

        vBox.getChildren().add(towerButtonHBox);
    }

    public List<TowerButtonDrawer> getTowerButtonDrawerList() { return towerButtonDrawerList; }

    public Button getSellingTowerButton() { return sellingTowerButton; }
}
