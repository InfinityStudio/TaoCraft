package astronomy.taocraft
import net.minecraft.item.Item;
import net.minecraft.item.ItemBed;
import net.minecraft.item.ItemEgg;
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
    Nil
  }

}