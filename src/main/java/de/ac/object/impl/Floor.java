package de.ac.object.impl;

import com.snac.core.object.AbstractObjectBase;
import de.ac.core.DinoRun;
import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;

@Getter
public class Floor extends AbstractObjectBase<BufferedImage> {
    @Setter
    private BufferedImage image;

    @Override
    protected void onCreate() {
        super.onCreate();

        var imgLoader = DinoRun.glace.getImageLoader();
        image = imgLoader.getCachedOrLoad(imgLoader.load("/background.png").getSubimage(0, 3, 1199, 12), "floor");

        setWidth(image.getWidth());
        setHeight(image.getHeight());
    }

    @Override
    protected void onUpdate() {

    }
}
