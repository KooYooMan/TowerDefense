package TowerDefense.thegame.sound;

import TowerDefense.thegame.Config;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class GameSound {
    static private MediaPlayer defeatSound = new MediaPlayer(new Media(new File(Config.DEFEAT_SOUND_PATH).toURI().toString()));
    static private MediaPlayer victorySound = new MediaPlayer(new Media(new File(Config.VICTORY_SOUND_PATH).toURI().toString()));
    static private MediaPlayer spawningSound = new MediaPlayer(new Media(new File(Config.MINION_SPAWMING_PATH).toURI().toString()));
    static private MediaPlayer hitSound = new MediaPlayer(new Media(new File(Config.SOUND_HIT_PATH).toURI().toString()));
    static private MediaPlayer enemyHitSound = new MediaPlayer(new Media(new File(Config.ENEMY_HIT_SOUND_PATH).toURI().toString()));

    //MediaPlayer defeatSound = new MediaPlayer(new Media(new File(Config.DEFEAT_SOUND_PATH).toURI().toString()));
    static public void playDefeat() {
        defeatSound.seek(Duration.ZERO);
        defeatSound.play();
    }
    static public void playVictory() {
        victorySound.seek(Duration.ZERO);
        victorySound.play();
    }
    static public void playSpawning() {
        spawningSound.seek(Duration.ZERO);
        spawningSound.play();
    }

    static public void playHit() {
        hitSound.seek(Duration.ZERO);
        hitSound.play();
    }
    static public void playEnemyHitSound() {
        enemyHitSound.seek(Duration.ZERO);
        enemyHitSound.play();
    }
}
