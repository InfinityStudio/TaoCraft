package astronomy.taocraft

import java.util.Random

import net.minecraft.block.Block
import astronomy.taocraft.interface.IGenerateInWorld
import net.minecraft.world.World
import net.minecraft.world.chunk.IChunkProvider
import net.minecraftforge.fml.common.IWorldGenerator
import net.minecraftforge.fml.common.registry.GameRegistry

import scala.collection.immutable.HashSet


/**
 * @author Blealtan
 */
class ModWorldGenerator extends IWorldGenerator {

  var generators : Set[IGenerateInWorld] = new HashSet[IGenerateInWorld]

  def execWorldGen(blocks: Map[String, Block]) : Unit = {
    for (blk <- blocks)
      blk._2 match {
        case wgBlock: IGenerateInWorld =>
          generators += wgBlock
        case _ =>
      }
    GameRegistry.registerWorldGenerator(this, 1)
  }

  override def generate(random: Random, chunkX: Int, chunkZ: Int, world: World, chunkGenerator: IChunkProvider, chunkProvider: IChunkProvider) : Unit = {
    for (iwg <- generators)
      iwg.onWorldGen(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider)
  }
}
