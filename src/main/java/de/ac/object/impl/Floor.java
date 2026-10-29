package de.ac.object.impl;

import com.snac.core.object.AbstractObjectBase;
import com.snac.graphics.impl.SwingImageLoader;
import de.ac.core.DinoRun;
import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;

@Getter
public class Floor extends AbstractObjectBase<BufferedImage> {

    public Floor() {
        DinoRun.glace.getObjectManager().addObject(this);
    }

    @Override
    protected void onCreate() {
        super.onCreate();


        var imgLoader = DinoRun.glace.getImageLoader();
        var img = imgLoader.getCachedOrLoad(imgLoader.getCachedOrLoad("/background.png").getSubimage(0, 3, 1199, 12), "floor");

        setSize(img.getWidth(), img.getHeight());

        setImage(img);
    }
}
