package astronomy.taocraft.interface

import java.util.Random

import net.minecraft.world.World
import net.minecraft.world.chunk.IChunkProvider

/**
 * @author Blealtan
 */
trait IGenerateInWorld {
  def onWorldGen(random: Random, chunkX: Int, chunkZ: Int, world: World, chunkGenerator: IChunkProvider, chunkProvider: IChunkProvider) : Unit
}
