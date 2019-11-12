package TowerDefense.thegame.drawer.shop.button;

import TowerDefense.thegame.drawer.shop.icon.AbstractIconDrawer;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BulletButtonContainerDrawer {
    private final VBox bulletButtonVBox = new VBox();
    private List<AbstractButtonDrawer> bulletButtonDrawerList = new ArrayList<>();

    public BulletButtonContainerDrawer(VBox vBox, List<AbstractIconDrawer> iconDrawerList) {
        iconDrawerList.forEach(iconDrawer -> {
            try {
                bulletButtonDrawerList.add(new BulletButtonDrawer(vBox, iconDrawer));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        bulletButtonDrawerList.forEach(bulletButtonDrawer -> bulletButtonVBox.getChildren().add(bulletButtonDrawer.getButtonVBox()));

        vBox.getChildren().add(bulletButtonVBox);
    }

    public List<AbstractButtonDrawer> getBulletButtonDrawerList() { return bulletButtonDrawerList; }
}
