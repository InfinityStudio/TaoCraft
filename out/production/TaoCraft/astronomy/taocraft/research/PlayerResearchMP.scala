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
  //var linelistmap = new HashMap[EntityPlayerMP,List[Researchline]]
  def getlinelist(player:EntityPlayerMP) = {
    
    Researchs.researchlinelist()
  }
  def addelement(player:EntityPlayerMP,ele:List[(String,Int)]) = {
    val uuid = player.getUniqueID;
    val uufile = new File(new File(world.getSaveHandler().getWorldDirectory,"stats"),"taocraft_"+uuid.toString()+".json");
    val elemap = if(uufile.exists()){
      val uufreader = new FileReader(uufile);
      val buff = new Array[Char](16384);
      uufreader.read(buff);
      val linestr = new String(buff);
      uufreader.close();
      Researchs.convertjsontolinelist(linestr)
    }else{
      uufile.createNewFile();
      Researchs.researchlinelist()
    }
    //判断activeresearchline并向上增加研究点
    val buff = new Array[Char](16384);
    val uufwriter = new FileWriter(uufile);
    //uufwriter.write(Researchs.convertlinelisttojson(linelistmap(player)));
    uufwriter.close();
  }
}