package astronomy.taocraft.research
import java.util.UUID
import java.io._
import java.util.Random
import scala.collection.mutable.HashMap
import scala.collection.JavaConverters._
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.entity.player.EntityPlayerMP
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly
import net.minecraft.world.WorldServer;
import astronomy.taocraft.TaoCraft;
import astronomy.taocraft.network.MessageJson;
/**
 * @author XFeng
 */
object PlayerResearchMP {
  var world: WorldServer = null;
  //var linelistmap = new HashMap[EntityPlayerMP,List[Researchline]]
  def getlinelist(player: EntityPlayerMP) = {
    val uuid = player.getUniqueID;
    val uufile = new File(new File(world.getSaveHandler().getWorldDirectory, "stats"), "taocraft_" + uuid.toString() + ".json");
    if (uufile.exists()) {
      val uufreader = new FileReader(uufile);
      val buff = new Array[Char](16384);
      uufreader.read(buff);
      val linestr = new String(buff).trim();
      uufreader.close();
      Researchs.convertjsontolinelist(linestr)
    } else {
      uufile.createNewFile();
      val uufwriter = new FileWriter(uufile);
      uufwriter.write(Researchs.convertlinelisttojson(Researchs.researchlinelist));
      uufwriter.close();
      Researchs.researchlinelist
    }
  }
  def addelement(player: EntityPlayerMP, ele: String) = {
    val uuid = player.getUniqueID;
    val uufile = new File(new File(world.getSaveHandler().getWorldDirectory, "stats"), "taocraft_" + uuid.toString() + ".json");
    val linemap = getlinelist(player)
    val activeline = {
      val re = Researchs.getresearchednameset(linemap);
      val unre = Researchs.getunresearchednameset(linemap);
      for (line <- linemap if re.contains(line.start) && unre.contains(line.end) && line.element.toMap.contains(ele) && line.elefill.toMap.apply(ele) < line.element.toMap.apply(ele)) yield line
    }
    if (activeline.size > 0) {
      val random = new Random()
      val linetofill = activeline.toList.apply(random.nextInt(activeline.size));
      val linefilled = linemap - linetofill + linetofill.add(ele);
      linefilled.hashCode();
      {
        val uufwriter = new FileWriter(uufile);
        uufwriter.write(Researchs.convertlinelisttojson(linefilled));
        uufwriter.close();
      }
      TaoCraft.simplenetwork.sendTo(new MessageJson(Researchs.convertlinelisttojson(linefilled)), player)
    } 

    //
  }
}