package TowerDefense.thegame.drawer.shop.button;

import TowerDefense.thegame.drawer.shop.icon.AbstractIconDrawer;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BulletButtonContainerDrawer {
    private final VBox bulletButtonVBox = new VBox();
    private List<BulletButtonDrawer> bulletButtonDrawerList;

    public BulletButtonContainerDrawer(VBox vBox, List<AbstractIconDrawer> iconDrawerList) throws IOException {
        this.bulletButtonDrawerList = new ArrayList<>(List.of(
                new BurningBulletButtonDrawer(vBox, iconDrawerList.get(0)),
                new ExplodingBulletButtonDrawer(vBox, iconDrawerList.get(1)),
                new FastBulletButtonDrawer(vBox, iconDrawerList.get(2)),
                new FrozenBulletButtonDrawer(vBox, iconDrawerList.get(3)),
                new HighDamageBulletButtonDrawer(vBox, iconDrawerList.get(4))
        ));

        bulletButtonDrawerList.forEach(bulletButtonDrawer -> bulletButtonVBox.getChildren().add(bulletButtonDrawer.getButtonVBox()));

        vBox.getChildren().add(bulletButtonVBox);
    }

    public List<BulletButtonDrawer> getBulletButtonDrawerList() { return bulletButtonDrawerList; }
}
