package astronomy.taocraft
import net.minecraft.block.Block
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
/**
 * @author XFeng
 */
class ModBlocks {
  val Blocks = blocklist.toMap
  def blockinit[T <: Block](block: T, name: String) = {
    GameRegistry.registerBlock(block, name);
    block.setUnlocalizedName(name);
    block.setCreativeTab(CreativeTabs.tabMisc);
    name -> block
  }
  def blocklist = {

    Nil
  }

}