package TowerDefense.thegame.drawer.shop.button;

import TowerDefense.utilities.Pair;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import java.io.FileInputStream;
import java.io.IOException;

public class ButtonWithLabelDrawer {
    private final Pair<Button, Label> buttonLabelPair;
    private final VBox buttonLabel;
    private final ImageView coinImage;

    public ButtonWithLabelDrawer(Button button, Label label) throws IOException {
        this.coinImage = new ImageView(new Image(new FileInputStream("resources/asset/icon/coin.png")));
        this.coinImage.setFitHeight(32);
        this.coinImage.setFitWidth(32);

        label.setGraphic(coinImage);
        label.setFont(Font.loadFont(new FileInputStream("target/classes/font/pkmnfl.ttf"), 24));
        label.setTextFill(Color.YELLOW);
        label.setTextAlignment(TextAlignment.JUSTIFY);
        label.setWrapText(true);
        label.setAlignment(Pos.CENTER);
        
        //button.setOnMousePressed(onClickEventHandler);
        button.setWrapText(true);
        button.setAlignment(Pos.BASELINE_LEFT);
        button.setPrefWidth(48);
        button.setMaxHeight(48);

        this.buttonLabelPair = Pair.immutableOf(button, label);
        this.buttonLabel = new VBox(button, label);
        this.buttonLabel.setSpacing(10);
        this.buttonLabel.setPrefSize(48, 48);
    }

    public Button getButton() { return buttonLabelPair.getA(); }
    public Label getLabel() { return buttonLabelPair.getB(); }

    public VBox getButtonLabel() { return buttonLabel; }

    public void setOnMouseClicked(EventHandler<MouseEvent> event) {
        this.getButton().setOnMouseClicked(event);
    }

    public void setOnMousePressed(EventHandler<MouseEvent> eventHandler) {
        this.getButton().setOnMousePressed(eventHandler);
    }

    public void setOnMouseEntered(EventHandler<MouseEvent> eventHandler) {
        this.getButton().setOnMouseEntered(eventHandler);
    }

    public void setOnMouseExited(EventHandler<MouseEvent> eventHandler) {
        this.getButton().setOnMouseExited(eventHandler);
    }
}
