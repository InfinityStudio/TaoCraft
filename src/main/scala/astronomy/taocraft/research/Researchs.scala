package astronomy.taocraft.research
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.Minecraft;
import scala.io._
import scala.collection.JavaConverters._;
import org.json4s._;
import org.json4s.native.JsonMethods._;
import com.google.gson._;
import com.google.gson.stream._;
import com.google.gson.reflect._;

/**
 * @author XFeng
 */
object Researchs {
  final val defaultresourceloca = new ResourceLocation("taocraft","research/defaultresearch.json")
  var linelist:List[Researchline]=null
  def researchlist():List[Research] = {
    defaultresearchlist();
  }
  def defaultresearchlist():List[Research] = {
     new Research("taiji","taocraft.research.name.taiji","taocraft:taiji",250,450)::
     new Research("yuanqi","taocraft.research.name.yuanqi","minecraft:cookie",230,400)::
     new Research("bagua","taocraft.research.name.bagua","minecraft:cookie",270,400)::
     Nil;
  }
  def researchlinelist():List[Researchline] = {
    if(linelist==null)defaultresearchlinelist else linelist
  }
  def defaultresearchlinelist():List[Researchline] = {
    new Researchline("taiji","yuanqi",List("metalwater"->3,"fireearth"->3))::
    new Researchline("taiji","bagua",List("metalwater"->1,"waterwood"->1,"woodfire"->1,"fireearth"->1,"earthmetal"->1))::
    Nil
  }
  def convertlinelisttojson(resline:List[Researchline]):String = {
    val gson = new Gson();
    def wrapline(r:Researchline):Researchlinejson = {
      val r2 = new Researchlinejson();
      r2.start = r.start;
      r2.end = r.end;
      r2.element = r.element.toMap.asJava;
      r2.elefill = r.elefill.toMap.asJava;
      r2
    }
    val wrappedline = resline.map(wrapline).asJava
    gson.toJson(wrappedline)
  }
  def convertjsontolinelist(linestring:String):List[Researchline] ={
    val gson = new Gson();
    def wrapline(r2:Researchlinejson):Researchline = {
      new Researchline(r2.start,r2.end,r2.element.asScala.toList,r2.elefill.asScala.toList)
    }
    val unwrapline:java.util.List[Researchlinejson] = gson.fromJson(linestring, new TypeToken[java.util.List[Researchlinejson]](){}.getType)
    unwrapline.asScala.toList.map { wrapline}
  }
}