package astronomy.taocraft

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.event.world._;
import net.minecraftforge.event.entity.player._;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import astronomy.taocraft.client.gui._;
import astronomy.taocraft.network.MessageJson;
import astronomy.taocraft.research.Researchs;
import astronomy.taocraft.research.PlayerResearchMP;
/**
 * @author xfeng
 */
class ModEventHandler {
  @SubscribeEvent
  def onKeyInput(event: InputEvent.KeyInputEvent) {
    if (KeyBindings.mainresearch.isPressed()) {
      System.out.println("ping");
      Minecraft.getMinecraft().thePlayer.openGui(TaoCraft, 20, null, 0, 0, 0);
    }
  }
  @SubscribeEvent
  def onPlayerLoggin(event:PlayerEvent.PlayerLoggedInEvent) {
    val mj = new MessageJson()
    val player = event.player.asInstanceOf[EntityPlayerMP]
    mj.jsonstr = Researchs.convertlinelisttojson(PlayerResearchMP.getlinelist(player))
    TaoCraft.simplenetwork.sendTo(mj, player)
  }
  @SubscribeEvent
  def onPlayerDrop(event:PlayerDropsEvent) {
    if(!event.entityPlayer.worldObj.isRemote){
      PlayerResearchMP.addelement(event.entityPlayer.asInstanceOf[EntityPlayerMP], "fireearth")
    }
  }
}