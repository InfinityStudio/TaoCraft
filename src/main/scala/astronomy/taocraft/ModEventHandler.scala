package astronomy.taocraft
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.event.world.BlockEvent;
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
    mj.jsonstr = Researchs.convertlinelisttojson(PlayerResearchMP.getlinelist(event.player))
    TaoCraft.simplenetwork.sendTo(mj, event.player.asInstanceOf[EntityPlayerMP])
  }
}