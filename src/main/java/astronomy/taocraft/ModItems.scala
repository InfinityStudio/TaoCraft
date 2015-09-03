package astronomy.taocraft
import net.minecraft.item.Item;
import net.minecraft.item.ItemBed;
import net.minecraft.item.ItemEgg;
import net.minecraftforge.fml.common.registry.GameRegistry;
/**
 * @author XFeng
 */
class ModItems {
  val Items = itemlist.toMap
  def itemlist = {
    iteminitlist.map(a=>a.getUnlocalizedName()->a)
  }
  def iteminitlist = {
    new ItemBed()::
    new ItemEgg::
    Nil
  }
}