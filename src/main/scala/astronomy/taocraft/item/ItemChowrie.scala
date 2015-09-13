package astronomy.taocraft.item

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{ItemStack, Item}
import net.minecraft.util.{BlockPos, EnumFacing}
import net.minecraft.world.World

/**
 * @author Blealtan
 */
class ItemChowrie extends Item {

  def ItemChowrie(): Unit =
  {
    this.setMaxDamage(32)
    this.setHasSubtypes(false)
  }

  override def onItemUse(stack: ItemStack, playerIn: EntityPlayer, worldIn: World, pos: BlockPos,
                         side: EnumFacing, hitX: Float, hitY: Float, hitZ: Float): Boolean =
  {
    //!TODO: Start some tasks for the block referred to, and count down its damage.
    true
  }
}
