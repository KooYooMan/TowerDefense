package TowerDefense.thegame.drawer.shop.button;

import TowerDefense.thegame.drawer.shop.icon.AbstractIconDrawer;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;

public abstract class AbstractButtonDrawer {
    private VBox buttonVBox = new VBox();
    private ButtonWithLabelDrawer buttonWithLabelDrawer;

    public AbstractButtonDrawer(VBox vBox, AbstractIconDrawer iconDrawer) throws IOException {
        this.buttonWithLabelDrawer = new ButtonWithLabelDrawer(
                new Button(iconDrawer.getLabel(), iconDrawer.getImageView()), new Label(Integer.toString(iconDrawer.getPrice()))
        );

        this.buttonVBox.getChildren().add(buttonWithLabelDrawer.getButtonLabel());

        vBox.getChildren().add(this.buttonVBox);
    }

    public VBox getButtonVBox() { return buttonVBox; }

    public void setOnMousePressed(EventHandler<MouseEvent> event) {
        this.buttonWithLabelDrawer.setOnMousePressed(event);
    }

    //public ButtonWithLabelDrawer getButtonWithLabelDrawer() { return buttonWithLabelDrawer; }
}
