package astronomy.taocraft.research
import java.util.UUID;
import java.io._;
import scala.collection.mutable.HashMap;
import scala.collection.JavaConverters._;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.relauncher.Side; 
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.world.WorldServer;
/**
 * @author XFeng
 */
object PlayerResearchMP {
  var world:WorldServer = null;
  var linelistmap = new HashMap[EntityPlayerMP,List[Researchline]]
  def getlinelist(player:EntityPlayerMP) = {
    
    Researchs.researchlinelist()
  }
  def savelinelist(player:EntityPlayerMP) = {
    val uuid = player.getUniqueID;
    val uufile = new File(new File(world.getSaveHandler().getWorldDirectory,"stats"),"taocraft_"+uuid.toString()+".json");
    val uufwriter = new FileWriter(uufile);
    uufwriter.write(Researchs.convertlinelisttojson(linelistmap(player)));
    uufwriter.close();
  }
}