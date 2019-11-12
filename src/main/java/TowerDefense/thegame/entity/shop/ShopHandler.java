package TowerDefense.thegame.entity.shop;

import TowerDefense.thegame.drawer.shop.button.AbstractButtonDrawer;
import TowerDefense.thegame.drawer.shop.button.ButtonContainerDrawer;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.List;

public class ShopHandler {
    private ButtonContainerDrawer buttonContainerDrawer;

    public ShopHandler(Pane pane) throws IOException {
        this.buttonContainerDrawer = new ButtonContainerDrawer(pane);
    }

    public List<AbstractButtonDrawer> getTowerButtonDrawerList() { return buttonContainerDrawer.getTowerButtonDrawerList(); }
    public List<AbstractButtonDrawer> getBulletButtonDrawerList() { return buttonContainerDrawer.getBulletButtonDrawerList(); }
}
