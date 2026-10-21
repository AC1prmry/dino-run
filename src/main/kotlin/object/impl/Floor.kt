package `object`.impl

import com.snac.core.Glace
import com.snac.core.`object`.AbstractObjectBase
import com.snac.graphics.Renderable
import com.snac.graphics.impl.SwingImageLoader
import environment.Level
import java.awt.image.BufferedImage

class Floor(level: Level) : AbstractObjectBase<BufferedImage>() {
    val imgLoader: SwingImageLoader = Glace.INSTANCE.imageLoader
    val floor : BufferedImage = imgLoader.getCachedOrLoad(
        imgLoader.load("/background.png").getSubimage(0, 3, 1199, 12),
        "floor")

    init {
        image = floor
    }

    override fun onUpdate(deltaTime: Double) {
        width = Glace.INSTANCE.renderer.frame?.width ?: width
        height = Glace.INSTANCE.renderer.frame?.height ?: height
    }

    override fun priority(): Renderable.Priority {
        return Renderable.Priority.LOW
    }
}