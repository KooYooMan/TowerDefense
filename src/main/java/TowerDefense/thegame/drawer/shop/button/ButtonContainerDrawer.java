package TowerDefense.thegame.drawer.shop.button;

import TowerDefense.thegame.drawer.shop.icon.IconDrawerList;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ButtonContainerDrawer {
    private final VBox vBox = new VBox();

    public ButtonContainerDrawer(Pane pane) {
        vBox.setSpacing(48);
        TowerButtonDrawer towerButtonDrawer = new TowerButtonDrawer(vBox, IconDrawerList.getTowerIconDrawerList());
        BulletButtonDrawer bulletButtonDrawer = new BulletButtonDrawer(vBox, IconDrawerList.getBulletIconDrawerList());

        pane.getChildren().add(vBox);
    }
}
