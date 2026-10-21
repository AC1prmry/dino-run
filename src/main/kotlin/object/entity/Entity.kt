package entity

import com.snac.core.Glace
import com.snac.core.`object`.PhysicalObject
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.awt.image.BufferedImage

abstract class Entity : PhysicalObject<BufferedImage>() {
    protected val log: Logger = LoggerFactory.getLogger(this.javaClass)

    init {
        Glace.INSTANCE.objectManager.addObject(this)
    }
}