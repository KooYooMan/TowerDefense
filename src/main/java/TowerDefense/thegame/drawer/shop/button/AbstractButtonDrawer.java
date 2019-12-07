package TowerDefense.thegame.drawer.shop.button;

import TowerDefense.thegame.drawer.shop.icon.AbstractIconDrawer;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.IOException;

public abstract class AbstractButtonDrawer {
    private HBox buttonHBox = new HBox();
    private ButtonWithLabelDrawer buttonWithLabelDrawer;

    public AbstractButtonDrawer(HBox hBox, AbstractIconDrawer iconDrawer) throws IOException {
        this.buttonWithLabelDrawer = new ButtonWithLabelDrawer(
                new Button("", iconDrawer.getImageView()), new Label(Long.toString(iconDrawer.getPrice()))
        );

        this.buttonHBox.getChildren().add(buttonWithLabelDrawer.getButtonLabel());

        hBox.getChildren().add(this.buttonHBox);
    }

    public HBox getButtonHBox() { return buttonHBox; }

    public void setOnMouseClicked(EventHandler<MouseEvent> event) {
        this.buttonWithLabelDrawer.setOnMouseClicked(event);
    }

    public void setOnMousePressed(EventHandler<MouseEvent> event) {
        this.buttonWithLabelDrawer.setOnMousePressed(event);
    }

    public void setOnMouseEntered(EventHandler<MouseEvent> event) {
        this.buttonWithLabelDrawer.setOnMouseEntered(event);
    }

    public void setOnMouseExited(EventHandler<MouseEvent> event) {
        this.buttonWithLabelDrawer.setOnMouseExited(event);
    }

    //public ButtonWithLabelDrawer getButtonWithLabelDrawer() { return buttonWithLabelDrawer; }
}
