package environment

import com.snac.core.Glace
import com.snac.graphics.Brush
import com.snac.graphics.ImageLoader
import com.snac.graphics.Renderable
import java.awt.image.BufferedImage

class Level : Renderable<BufferedImage> {
    var speed = 0

    override fun render(brush: Brush<BufferedImage?>?) {
    }

}