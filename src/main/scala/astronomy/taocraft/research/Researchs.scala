package astronomy.taocraft.research
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.Minecraft;
import scala.io._
import org.json4s._;
import org.json4s.native.JsonMethods._
import com.google.gson._;
import com.google.gson.stream._;
import com.google.gson.reflect._;
/**
 * @author XFeng
 */
object Researchs {
  final val defaultresourceloca = new ResourceLocation("taocraft","research/defaultresearch.json")
  def researchlist():List[Research] = {
    defaultresearchlist();
  }
  def defaultresearchlist():List[Research] = {
     val resourcemanager = Minecraft.getMinecraft().getResourceManager()
     val resource = resourcemanager.getResource(defaultresourceloca)
     val input = resource.getInputStream()
     val jsonparser = new JsonParser()
     val je = Source.fromInputStream(input,"utf8").mkString;
     val jr = parse(je)
     new Research("taiji","taocraft.research.name.taiji","taocraft:taiji",250,450)::
     new Research("yuanqi","taocraft.research.name.yuanqi","minecraft:cookie",230,400)::
     new Research("bagua","taocraft.research.name.bagua","minecraft:cookie",270,400)::
     Nil;
  }
  def researchlinelist():List[Researchline] = {
    defaultresearchlinelist();
  }
  def defaultresearchlinelist():List[Researchline] = {
    new Researchline("taiji","yuanqi",List("metalwater"->3,"fireearth"->3))::
    new Researchline("taiji","bagua",List("metalwater"->1,"waterwood"->1,"woodfire"->1,"fireearth"->1,"earthmetal"->1))::
    Nil
  }
}