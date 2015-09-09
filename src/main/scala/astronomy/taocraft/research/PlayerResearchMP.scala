package astronomy.taocraft.research
import java.util.UUID;
import scala.collection.mutable.HashMap;
import scala.collection.JavaConverters._;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.relauncher.Side; 
import net.minecraftforge.fml.relauncher.SideOnly;
/**
 * @author XFeng
 */

object PlayerResearchMP {
  def getlinelist(player:EntityPlayer) = {
    Researchs.researchlinelist()
  }
  
}