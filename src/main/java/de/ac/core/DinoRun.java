package de.ac.core;

import com.snac.core.Glace;
import de.ac.object.entity.Entity;

public class DinoRun {
    public static final Glace glace = Glace.INSTANCE;

    static void main() {
        glace.start();
        glace.getRenderer().createWindow(1200, 800, "Dino Run");

        new Entity() {

        };
    }
}
