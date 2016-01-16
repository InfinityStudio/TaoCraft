package astronomy.taocraft.block

import java.util.Random

import astronomy.taocraft.interface.IGenerateInWorld
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.item.Item
import net.minecraft.util.BlockPos
import net.minecraft.world.chunk.IChunkProvider
import net.minecraft.world.gen.feature.WorldGenMinable
import net.minecraft.world.{World, IBlockAccess}

/**
 * @author Blealtan
 */
class LeadOre extends Block(Material.rock) with IGenerateInWorld {

  setHardness(3.0f).setResistance(5.0f).setHarvestLevel("pickaxe", 1)

  override def getItemDropped(state: IBlockState, rand: Random, fortune: Int) : Item = Item.getItemFromBlock(this)
  override def quantityDropped(random: Random) : Int = 1
  override def quantityDroppedWithBonus(fortune: Int, random: Random) : Int = {
    val j = random.nextInt(fortune + 2)
    if (j > 1) j else 1
  }
  override def getExpDrop(world: IBlockAccess, pos: BlockPos, fortune: Int) : Int = 0
  override def getDamageValue(worldIn: World, pos: BlockPos): Int = 0
  override def damageDropped(state: IBlockState) : Int = 0


  override def onWorldGen(random: Random, chunkX: Int, chunkZ: Int, world: World, chunkGenerator: IChunkProvider, chunkProvider: IChunkProvider) : Unit = {
    if (world.provider.getDimensionId == 0)
      for (i <- 1 to random.nextInt(5)) {
        val posX: Int = (chunkX << 4) + random.nextInt(16)
        val posY: Int = random.nextInt(36) + 20
        val posZ: Int = (chunkZ << 4) + random.nextInt(16)

        new WorldGenMinable(getDefaultState, 2 + random.nextInt(7)).generate(world, random, new BlockPos(posX, posY, posZ))
      }
  }
}
