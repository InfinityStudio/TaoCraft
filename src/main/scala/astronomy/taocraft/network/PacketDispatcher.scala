package astronomy.taocraft.network
import net.minecraft.entity.player.EntityPlayer; 
import net.minecraft.entity.player.EntityPlayerMP; 
import net.minecraftforge.fml.common.network.NetworkRegistry; 
import net.minecraftforge.fml.common.network.simpleimpl._; 
import net.minecraftforge.fml.relauncher.Side; 

/**
 * @author XFeng
 */
object PacketDispatcher{
  var instance:PacketDispatcher = null;
  def apply(modid:String):SimpleNetworkWrapper ={
    instance = new PacketDispatcher(modid);
    instance.dispatcher
  }
}
class PacketDispatcher (modid:String){
  val dispatcher = NetworkRegistry.INSTANCE.newSimpleChannel(modid);
}