package core

import com.snac.core.Glace

private fun main() {
    val glace = Glace.INSTANCE
    glace.start()
    glace.renderer.createWindow(1800, 1200, "Dino Run")
}