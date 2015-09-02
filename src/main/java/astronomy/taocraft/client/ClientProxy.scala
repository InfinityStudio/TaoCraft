package astronomy.taocraft.client
import astronomy.taocraft.CommonProxy;
import astronomy.taocraft._;


/**
 * @author xfeng
 */
class ClientProxy extends CommonProxy
{
  override def registerKeyBindings() 
  {
    KeyBindings.init();
  }
  override val guis:ModGuiHandler = new ModGuiHandler;
}