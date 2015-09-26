package astronomy.taocraft.block

import java.util.Random

import astronomy.taocraft.interface.IWorldGenBlock
import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.block.state.IBlockState
import net.minecraft.init.Blocks
import net.minecraft.item.Item
import net.minecraft.util.BlockPos
import net.minecraft.world.chunk.IChunkProvider
import net.minecraft.world.{World, IBlockAccess}

/**
 * @author Blealtan
 */
class LeadOre extends Block(Material.rock) with IWorldGenBlock {

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
    //!TODO: Add WorldGen
  }
}
