package astronomy.taocraft.research

/**
 * @author XFeng
o=-
 */



class Research (
    val name:String,
    val text:String,
    val texture:String,
    val researchmapX:Int,
    val researchmapY:Int,
    var state:Boolean = false
    ){
  
}
class Researchline(
    val start:String,
    val end:String,
    val element:List[(String,Int)],
    ele:List[(String,Int)] = null
    ){
  var elefill=if (ele==null) element.map((a)=>a._1->0) else ele;
}
class Researchlinejson(){
    var start:String = null
    var end:String = null
    var element:java.util.Map[String,Int] = null
    var elefill:java.util.Map[String,Int] = null
}