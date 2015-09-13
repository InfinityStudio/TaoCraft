package astronomy.taocraft

import astronomy.taocraft.item.ItemChowrie
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
/**
 * @author XFeng
 */
class ModItems {

  val Items = itemlist.toMap

  def iteminit[T <: Item](item: T, name: String) = {
    GameRegistry.registerItem(item, name);
    item.setUnlocalizedName(name);
    item.setCreativeTab(CreativeTabs.tabMisc)
    name -> item
  }

  def itemlist = {
    iteminit(new Item, "taiji") ::
    iteminit(new Item, "bagua") ::
    iteminit(new ItemChowrie, "chowrie")::
    Nil
  }
}
