package astronomy.taocraft.client
import astronomy.taocraft.CommonProxy;
import astronomy.taocraft._;
import net.minecraft.item.Item;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
/**
 * @author xfeng
 */
class ClientProxy extends CommonProxy
{
  override def registerKeyBindings() 
  {
    KeyBindings.init();
  }
  override def registerModels(items:Map[String,Item]){
    for(it<-items){
    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(it._2, 0,new ModelResourceLocation("taocraft:"+it._1, "inventory"));
    ModelBakery.addVariantName(it._2, "taocraft:"+it._1);
    }
  }
  override val guis:ModGuiHandler = new ModGuiHandler;
}