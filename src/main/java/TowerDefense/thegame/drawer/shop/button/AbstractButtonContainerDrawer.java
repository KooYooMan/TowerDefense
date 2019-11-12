package TowerDefense.thegame.drawer.shop.button;

import javafx.scene.layout.VBox;

import java.util.List;

public abstract class AbstractButtonContainerDrawer {
    private final VBox buttonVBox = new VBox();

    public AbstractButtonContainerDrawer(VBox vBox, List<AbstractButtonDrawer> buttonDrawerList) {
        buttonDrawerList.forEach(buttonDrawer -> buttonVBox.getChildren().add(buttonDrawer.getButtonVBox()));

        vBox.getChildren().add(buttonVBox);
    }
}
