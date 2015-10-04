package astronomy.taocraft.data

import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.world.World

//ÌÒÄ¾»Ò

object Peachdust extends Item {
  this.setUnlocalizedName("peachdust")
  this.setMaxStackSize(16)

  override def onItemRightClick(itemStack: ItemStack, world: World, play: EntityPlayer): Boolean = {
    true
  }

}
