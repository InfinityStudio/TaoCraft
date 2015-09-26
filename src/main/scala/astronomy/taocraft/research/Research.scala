package astronomy.taocraft.research

/**
 * @author XFeng
 */
class Research (
    val name:String,
    val text:String,
    val texture:String,
    val researchmapX:Int,
    val researchmapY:Int
    ){
}
class Researchline(
    val start:String,
    val end:String,
    val element:Map[String,Int],
    ele:Map[String,Int] = null
    ){
  val elefill = if (ele==null) element.map((a)=>a._1->0) else ele
  def add(ele:String):Researchline = {
    val tofill = elefill.toMap.apply(ele)
    new Researchline(start,end,element,elefill + (ele->(tofill+1)))
  }
 override def equals(that:Any):Boolean = {
   that.isInstanceOf[Researchline]&&this.end.equals(that.asInstanceOf[Researchline].end)&&this.start.equals(that.asInstanceOf[Researchline].start)
 }
 override def hashCode():Int = {
   start.hashCode()+end.hashCode()
 }
 def ===(that:Researchline):Boolean = {
   this.equals(that)&&this.element.equals(that.element)&&this.elefill.equals(that.elefill)
 }
}
class Researchlinejson(){
    var start:String = null
    var end:String = null
    var element:java.util.Map[String,Int] = null
    var elefill:java.util.Map[String,Int] = null
}
