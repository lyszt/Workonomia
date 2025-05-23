package Sound;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class SoundPlayer {
    private static final HashMap<String, Clip> clipCache = new HashMap<>();

    public static void playSound(String filePath) {
        try {
            Clip clip = clipCache.get(filePath);
            if (clip == null) {
                // Load and cache the clip
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(filePath));
                clip = AudioSystem.getClip();
                clip.open(audioIn);
                clipCache.put(filePath, clip);
            }

            if (clip.isRunning()) {
                clip.stop();  // Stop if already playing
            }

            clip.setFramePosition(0);  // Rewind to beginning
            clip.start();              // Play

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
