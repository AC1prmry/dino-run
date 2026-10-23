package de.ac.object.impl;

import com.snac.core.object.AbstractObjectBase;
import de.ac.core.DinoRun;

import java.awt.image.BufferedImage;

public class Floor extends AbstractObjectBase<BufferedImage> {
    private BufferedImage image;

    @Override
    protected void onCreate() {
        super.onCreate();

        var imgLoader = DinoRun.glace.getImageLoader();

        //TODO: Fix subimage
        image = imgLoader.getCachedOrLoad(imgLoader.load("/floor.png").getSubimage(1, 1, 1, 1), "floor");
    }

    @Override
    protected void onUpdate(double deltaTime) {
        //TODO: Adapt width if needed (window resized)
    }
}
