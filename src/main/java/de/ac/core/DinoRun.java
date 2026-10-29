package de.ac.core;

import com.snac.core.Glace;
import de.ac.environment.Level;
import lombok.Getter;

@Getter
public class DinoRun {
    public static final Glace glace = Glace.INSTANCE;

    private final Level level;

    static void main()  {
        glace.start();
        glace.getRenderer().createWindow(1200, 700, "Dino Run");

        new DinoRun();
    }

    private DinoRun() {
        this.level = new Level();

        glace.setTickHook(this.level::onUpdate);
    }
}
