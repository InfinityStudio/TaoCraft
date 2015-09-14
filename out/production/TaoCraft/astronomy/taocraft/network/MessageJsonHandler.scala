package astronomy.taocraft.network
import astronomy.taocraft.research._;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage; 
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext; 
import net.minecraftforge.fml.relauncher.Side;
/**
 * @author XFeng
 */
class MessageJsonHandler extends IMessageHandler[MessageJson,IMessage]{
  def onMessage(message:MessageJson, ctx:MessageContext) = {
    if(ctx.side == Side.CLIENT){
      PlayerResearchSP.linelist = Researchs.convertjsontolinelist(message.jsonstr)
      //System.out.print(PlayerResearchSP.linelist.toString())
    }
    null
  }
}