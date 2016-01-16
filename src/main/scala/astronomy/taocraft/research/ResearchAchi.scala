package astronomy.taocraft.research
import net.minecraftforge.event.world._;
import net.minecraftforge.event.entity.player._;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
/**
 * @author XFeng
 */
class ResearchAchievement(
    val name:String,
    val element:Map[String,Int],
    val elecall:((ResearchAchievement,EntityPlayer)=>Unit)
    ){
 override def equals(that:Any):Boolean = {
   that.isInstanceOf[ResearchAchievement]&&this.name.equals(that.asInstanceOf[ResearchAchievement].name)
 }
 override def hashCode():Int = {
   name.hashCode()
 }
 def <(that:ResearchAchievement):Boolean = {
   for(ele<-this.element){
     if( ele._2>=that.element(ele._1))return false;
   }
   return true;
 }
 def -(that:ResearchAchievement):Map[String,Int] = {
   if (this.name!=that.name)
     throw new Error();
   for(ele<-this.element)yield(ele._1,ele._2 - that.element(ele._1))
 }
}
object ResearchAchi{
  def geteventAchiList(elecall:((ResearchAchievement,EntityPlayer)=>Unit)):Set[ResearchAchievement] = {
    (new AchievementDrop(elecall)::Nil).toSet
  }
  def getdefAchiList():Set[ResearchAchievement] = {
    def clear(eles:Map[String,Int]) = {
      (for(ele<-eles)yield ele._1->0)
    }
    for(achi<-geteventAchiList(null))yield new ResearchAchievement(achi.name,clear(achi.element),null)
  }
  
}
class AchievementDrop (
    elecall:((ResearchAchievement,EntityPlayer)=>Unit)//建议在elecall中做服务端检查
    )extends ResearchAchievement(
        "drop",Map("fireearth"->3),elecall
    ){
  @SubscribeEvent
  def onPlayerDrop(event:PlayerDropsEvent){
    elecall(this,event.entityPlayer);
  }
  
}