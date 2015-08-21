package astronomy.taocraft
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent._;
/**
 * @author xfeng
 */
class ModEventHandler 
{
  def ModEventHandler() = {} ; 
  @SubscribeEvent
  def onKeyInput(event:InputEvent.KeyInputEvent) 
  {
        if(KeyBindings.mainresearch.isPressed())
            {
            System.out.println("ping");
            var itemstack=Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem();
            if(itemstack!=null)
            {
              Minecraft.getMinecraft().thePlayer.openGui(TaoCraft, 20, null, 0, 0, 0);
            }
            else 
            {
              
            }
              
            }
    }
}