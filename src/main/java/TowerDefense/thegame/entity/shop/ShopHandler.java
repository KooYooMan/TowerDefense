package TowerDefense.thegame.entity.shop;

import TowerDefense.thegame.drawer.shop.ShopDrawer;
import TowerDefense.thegame.drawer.shop.button.ButtonContainerDrawer;
import javafx.scene.layout.Pane;

public class ShopHandler {
    public ShopHandler(Pane pane, ShopDrawer shopDrawer) {
        ButtonContainerDrawer buttonContainerDrawerDrawer = new ButtonContainerDrawer(pane);
    }
}
