package de.ac.object.entity;

import com.snac.core.object.PhysicalObject;
import de.ac.core.DinoRun;

import java.awt.image.BufferedImage;

public abstract class Entity extends PhysicalObject<BufferedImage> {

    public Entity() {
        DinoRun.glace.getObjectManager().addObject(this);
    }
}
