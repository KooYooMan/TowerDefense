package TowerDefense.thegame.drawer.shop.button;

import TowerDefense.thegame.drawer.shop.icon.AbstractIconDrawer;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AbstractButtonDrawer {
    private final VBox buttonVBox = new VBox();
    private final List<ButtonWithLabelDrawer> buttonWithLabelList = new ArrayList<>();

    public AbstractButtonDrawer(VBox vBox, List<AbstractIconDrawer> iconDrawerList) {
        iconDrawerList.forEach(iconDrawer -> {
            try {
                buttonWithLabelList.add(new ButtonWithLabelDrawer(
                        new Button(iconDrawer.getLabel(), iconDrawer.getImageView()), new Label(iconDrawer.getPrice()))
                );
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        buttonWithLabelList.forEach(buttonWithLabel -> buttonVBox.getChildren().add(buttonWithLabel.getButtonLabel()));

        vBox.getChildren().add(buttonVBox);
    }
}
