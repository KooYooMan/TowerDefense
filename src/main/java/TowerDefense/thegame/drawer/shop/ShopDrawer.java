package TowerDefense.thegame.drawer.shop;

import TowerDefense.thegame.Config;
import TowerDefense.thegame.entity.bullet.AbstractBullet;
import TowerDefense.thegame.entity.tile.tower.AbstractTower;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.IOException;

public final class ShopDrawer {
    private final GraphicsContext graphicsContext;
    private final Image background;
    private boolean isRenderingTowerStats;
    private boolean isRenderingBulletStats;
    private boolean isRenderingRemovingTowerFunction;
    private boolean isRenderingUpgradingTowerFunction;
    private Class<? extends AbstractTower> towerClass;
    private Class<? extends AbstractBullet> bulletClass;

    public ShopDrawer(GraphicsContext graphicsContext, String filePath) throws IOException {
        this.graphicsContext = graphicsContext;
        this.background = new Image(new FileInputStream(filePath));

        this.isRenderingTowerStats = false;
        this.isRenderingBulletStats = false;
        this.isRenderingRemovingTowerFunction = false;
        this.isRenderingUpgradingTowerFunction = false;

        this.towerClass = null;
        this.bulletClass = null;

        this.graphicsContext.setFont(Font.loadFont(new FileInputStream("target/classes/font/pkmnfl.ttf"), 24));
    }

    public void setRenderingTowerStats(boolean renderingTowerStats) { isRenderingTowerStats = renderingTowerStats; }
    public void setRenderingBulletStats(boolean renderingBulletStats) { isRenderingBulletStats = renderingBulletStats; }
    public void setRenderingRemovingTowerFunction(boolean renderingRemovingTowerFunction) {
        isRenderingRemovingTowerFunction = renderingRemovingTowerFunction;
    }
    public void setRenderingUpgradingTowerFunction(boolean renderingUpgradingTowerFunction) {
        isRenderingUpgradingTowerFunction = renderingUpgradingTowerFunction;
    }

    public void setTowerClass(Class<? extends AbstractTower> towerClass) { this.towerClass = towerClass; }
    public void setBulletClass(Class<? extends AbstractBullet> bulletClass) { this.bulletClass = bulletClass; }

    public final void render() {
        graphicsContext.drawImage(background, 0, 0, Config.SHOP_WIDTH, Config.SCREEN_HEIGHT);

        if (isRenderingTowerStats && towerClass != null) {
            renderTowerStats(towerClass);
        }

        if (isRenderingBulletStats && bulletClass != null) {
            renderBulletStats(bulletClass);
        }

        if (isRenderingRemovingTowerFunction) {
            renderRemovingTowerFunction();
        }

        if (isRenderingUpgradingTowerFunction) {
            renderUpgradingTowerFunction();
        }
    }

    public final void renderTowerStats(Class<? extends AbstractTower> towerClass) {
        StringBuilder stats = new StringBuilder();

        try {
            stats.append(towerClass.getField("NAME").get(null)).append("\n\n");

            stats.append("Range: ");
            stats.append(towerClass.getField("RANGE").get(null).toString());
            stats.append(" tile(s)").append("\n\n");

            stats.append("Speed: ");
            stats.append(towerClass.getField("SPEED").get(null).toString()).append("\n\n");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        if (!stats.toString().equals("")) {
            graphicsContext.fillText(stats.toString(), 5, 260);
        }
    }

    public final void renderBulletStats(Class<? extends AbstractBullet> bulletClass) {
        StringBuilder stats = new StringBuilder();

        try {
            stats.append(bulletClass.getField("NAME").get(null)).append("\n\n");

            stats.append("Damage: ");
            stats.append(bulletClass.getField("DAMAGE").get(null).toString()).append("\n\n");

            Object effect = bulletClass.getField("EFFECT").get(null);
            if (effect != null) {
                stats.append("Effect: ");
                stats.append(effect).append("\n\n");
            }

            long time = Long.parseLong(bulletClass.getField("TIME").get(null).toString());
            if (time > 0L) {
                stats.append("Length: ");
                stats.append(time).append(" ticks\n\n");
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        if (!stats.toString().equals("")) {
            graphicsContext.fillText(stats.toString(), 5, 260);
        }
    }

    public final void renderRemovingTowerFunction() {
        graphicsContext.fillText("Removes a tower", 5, 260);
    }

    public final void renderUpgradingTowerFunction() {
        graphicsContext.fillText("Upgrades a tower", 5, 260);
    }
}
