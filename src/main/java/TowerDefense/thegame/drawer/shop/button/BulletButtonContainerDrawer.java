package TowerDefense.thegame.drawer.shop.button;

import TowerDefense.thegame.drawer.shop.icon.AbstractIconDrawer;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BulletButtonContainerDrawer {
    private final HBox bulletButtonHBox = new HBox();
    private List<BulletButtonDrawer> bulletButtonDrawerList;

    public BulletButtonContainerDrawer(VBox vBox, List<AbstractIconDrawer> iconDrawerList) throws IOException {
        this.bulletButtonDrawerList = new ArrayList<>(List.of(
                new NormalBulletButtonDrawer(bulletButtonHBox, iconDrawerList.get(0)),
                new BurningBulletButtonDrawer(bulletButtonHBox, iconDrawerList.get(1)),
                new FrozenBulletButtonDrawer(bulletButtonHBox, iconDrawerList.get(2))
        ));

        bulletButtonHBox.setSpacing(32);

        vBox.getChildren().add(bulletButtonHBox);
    }

    public List<BulletButtonDrawer> getBulletButtonDrawerList() { return bulletButtonDrawerList; }
}
