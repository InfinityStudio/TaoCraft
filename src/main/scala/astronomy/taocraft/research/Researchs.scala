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
  val researchlist:Set[Research] = {
     (new Research("taiji","taocraft.research.name.taiji","taocraft:taiji",250,450)::
     new Research("yuanqi","taocraft.research.name.yuanqi","minecraft:cookie",230,400)::
     new Research("bagua","taocraft.research.name.bagua","minecraft:cookie",270,400)::
     Nil).toSet;
  }
  val researchlinelist:Set[Researchline] = {
    (new Researchline("taiji","yuanqi",Map("metalwater"->3,"fireearth"->3))::
    new Researchline("taiji","bagua",Map("metalwater"->1,"waterwood"->1,"woodfire"->1,"fireearth"->1,"earthmetal"->1))::
    Nil).toSet
  }
  def convertlinelisttojson(reslines:Set[Researchline]):String = {
    //傻逼gson转换错误
    val gson = new Gson();
    def wrapline(r:Researchline):JsonElement = {
      val rjson = new JsonObject();
      rjson.addProperty("start", r.start);
      rjson.addProperty("end", r.end);
      def wrapelement(e:Map[String,Int]):JsonElement = {
        val ejson = new JsonObject();
        for(p<-e){
          ejson.addProperty(p._1, p._2)
        }
        ejson
      }
      rjson.add("element", wrapelement(r.element));
      rjson.add("elefill", wrapelement(r.elefill));
      rjson
    }
    val resjson = new JsonArray();
    for(resline<-reslines){
      resjson.add(wrapline(resline));
    }
    resjson.toString()
  }
  def convertjsontolinelist(linestring:String):Set[Researchline] = {
    //傻逼gson转换错误
    val parser = new JsonParser();
    val linejson = parser.parse(linestring).getAsJsonArray().asScala;
    def wrapine(r:JsonElement):Researchline = {
      val rp = r.getAsJsonObject;
      def wrapelement(e:JsonElement):Map[String,Int] = {
        val ep = e.getAsJsonObject.entrySet.asScala;
        (for(s<-ep)yield s.getKey->s.getValue.getAsInt).toMap
      }
      new Researchline(rp.get("start").getAsString,rp.get("end").getAsString,wrapelement(rp.get("element")),wrapelement(rp.get("elefill")))
    }
    (for(r<-linejson)yield wrapine(r)).toSet
  }
  def getunresearchednameset(resline:Set[Researchline]) = {
    for(line<-resline if (line.elefill!=line.element))yield line.end
  }
  def getresearchednameset(resline:Set[Researchline]) = {
    val unre = for(line<-resline if (line.elefill!=line.element))yield line.end;
    for(res<-researchlist if !unre.contains(res.name))yield res.name
  }
}