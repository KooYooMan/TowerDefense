package TowerDefense.thegame.entity.shop;

import TowerDefense.thegame.drawer.shop.button.BulletButtonDrawer;
import TowerDefense.thegame.drawer.shop.button.ButtonContainerDrawer;
import TowerDefense.thegame.drawer.shop.button.TowerButtonDrawer;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.List;

public class ShopHandler {
    private ButtonContainerDrawer buttonContainerDrawer;

    public ShopHandler(Pane pane) throws IOException {
        this.buttonContainerDrawer = new ButtonContainerDrawer(pane);
    }

    public List<TowerButtonDrawer> getTowerButtonDrawerList() { return buttonContainerDrawer.getTowerButtonDrawerList(); }
    public List<BulletButtonDrawer> getBulletButtonDrawerList() { return buttonContainerDrawer.getBulletButtonDrawerList(); }
    public Button getSellingTowerButton() { return buttonContainerDrawer.getSellingTowerButton(); }
}
