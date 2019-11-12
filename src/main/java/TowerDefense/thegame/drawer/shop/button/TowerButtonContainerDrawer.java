package TowerDefense.thegame.drawer.shop.button;

import TowerDefense.thegame.drawer.shop.icon.AbstractIconDrawer;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TowerButtonContainerDrawer {
    private final VBox towerButtonVBox = new VBox();
    private List<TowerButtonDrawer> towerButtonDrawerList;

    public TowerButtonContainerDrawer(VBox vBox, List<AbstractIconDrawer> iconDrawerList) throws IOException {
        this.towerButtonDrawerList = new ArrayList<>(List.of(
                new NormalGunTowerButtonDrawer(vBox, iconDrawerList.get(0)),
                new MachineGunTowerButtonDrawer(vBox, iconDrawerList.get(1)),
                new SniperGunTowerButtonDrawer(vBox, iconDrawerList.get(2))
        ));

        towerButtonDrawerList.forEach(towerButtonDrawer -> towerButtonVBox.getChildren().add(towerButtonDrawer.getButtonVBox()));

        vBox.getChildren().add(towerButtonVBox);
    }

    public List<TowerButtonDrawer> getTowerButtonDrawerList() { return towerButtonDrawerList; }
}
