package astronomy.taocraft.item

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Items
import net.minecraft.item.{ItemStack, Item}
import net.minecraft.util.{BlockPos, EnumFacing}
import net.minecraft.world.World
import net.minecraftforge.fml.common.registry.GameRegistry

/**
 * @author Blealtan
 */
class ItemChowrie extends Item {

  setMaxDamage(32)
  setHasSubtypes(false)
  setMaxStackSize(1)
  GameRegistry addRecipe(new ItemStack(this), "## ", " * ", " * ", Character.valueOf('#'), Items.string, Character.valueOf('*'), Items.stick)

  override def onItemUse(stack: ItemStack, playerIn: EntityPlayer, worldIn: World, pos: BlockPos,
                         side: EnumFacing, hitX: Float, hitY: Float, hitZ: Float): Boolean =
  {
    //!TODO: Start some tasks for the block referred to.
    stack damageItem(1, playerIn)
    true
  }

}
