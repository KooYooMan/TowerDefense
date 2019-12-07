package TowerDefense.thegame.drawer.shop.button;

import TowerDefense.thegame.drawer.shop.icon.IconDrawerList;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class ButtonContainerDrawer {
    private final VBox vBox = new VBox();
    private TowerButtonContainerDrawer towerButtonContainerDrawer;
    private BulletButtonContainerDrawer bulletButtonContainerDrawer;

    public ButtonContainerDrawer(Pane pane) throws IOException {
        this.vBox.setSpacing(24);

        this.towerButtonContainerDrawer = new TowerButtonContainerDrawer(vBox, IconDrawerList.getTowerIconDrawerList());
        this.bulletButtonContainerDrawer = new BulletButtonContainerDrawer(vBox, IconDrawerList.getBulletIconDrawerList());

        pane.getChildren().add(vBox);
    }

    public List<TowerButtonDrawer> getTowerButtonDrawerList() { return towerButtonContainerDrawer.getTowerButtonDrawerList(); }
    public List<BulletButtonDrawer> getBulletButtonDrawerList() { return bulletButtonContainerDrawer.getBulletButtonDrawerList(); }
    public Button getSellingTowerButton() { return towerButtonContainerDrawer.getSellingTowerButton(); }
}
