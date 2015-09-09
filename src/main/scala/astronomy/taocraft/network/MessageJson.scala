package astronomy.taocraft.network
import net.minecraftforge.fml.common.network.simpleimpl.IMessage; 
import net.minecraftforge.fml.common.network.ByteBufUtils;
import io.netty.buffer.ByteBuf;
/**
 * @author XFeng
 */
class MessageJson extends IMessage{
  var jsonstr:String = null;
  def fromBytes(bf:ByteBuf) = {
    jsonstr = ByteBufUtils.readUTF8String(bf)
    }
  def toBytes(bf:ByteBuf) = {
    ByteBufUtils.writeUTF8String(bf, jsonstr)
  }
}