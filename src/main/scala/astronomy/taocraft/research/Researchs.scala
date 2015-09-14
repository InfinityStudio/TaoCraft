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
  def convertlinelisttojson(resline:Set[Researchline]):String = {
    val gson = new Gson();
    def wrapline(r:Researchline):Researchlinejson = {
      val r2 = new Researchlinejson();
      r2.start = r.start;
      r2.end = r.end;
      r2.element = r.element.asJava;
      r2.elefill = r.elefill.asJava;
      r2
    }
    val wrappedline = resline.map(wrapline).asJava
    gson.toJson(wrappedline,new TypeToken[java.util.Set[Researchlinejson]](){}.getType)
  }
  def convertjsontolinelist(linestring:String):Set[Researchline] ={
    val gson = new Gson();
    def wrapline(r2:Researchlinejson):Researchline = {
      new Researchline(r2.start,r2.end,r2.element.asScala.toMap[String,Int],r2.elefill.asScala.toMap[String,Int])
    }
    /* 建议在此处加上一个格式检查函数
     * 以检查得到的json内容是否符合预定义的研究链串
     * 可以考虑抛出异常com.google.gson.stream.MalformedJsonException
     */
    val unwrapline:java.util.Set[Researchlinejson] = gson.fromJson(linestring, new TypeToken[java.util.Set[Researchlinejson]](){}.getType)
    val a = unwrapline.asScala
    val b = a.toSet
    val c = b.map { wrapline}
    c
  }
  def getunresearchednameset(resline:Set[Researchline]) = {
    for(line<-resline if (line.elefill!=line.element))yield line.end
  }
  def getresearchednameset(resline:Set[Researchline]) = {
    val unre = for(line<-resline if (line.elefill!=line.element))yield line.end;
    for(res<-researchlist if !unre.contains(res.name))yield res.name
  }
}