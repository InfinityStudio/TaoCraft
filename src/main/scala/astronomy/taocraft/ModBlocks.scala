package astronomy.taocraft

import astronomy.taocraft.block.LeadOre
import net.minecraft.block.Block
import net.minecraftforge.fml.common.registry.GameRegistry
import net.minecraft.creativetab.CreativeTabs

/**
 * @author Blealtan
 */
class ModBlocks {

  val Blocks: Map[String, Block] = blocklist.toMap

  def blockinit[T <: Block](block: T, name: String) = {
    GameRegistry.registerBlock(block, name)
    block.setUnlocalizedName(name)
    block.setCreativeTab(CreativeTabs.tabMisc)
    name -> block
  }

  def blocklist = {
    blockinit(new LeadOre, "leadore") ::
    Nil
  }

}
