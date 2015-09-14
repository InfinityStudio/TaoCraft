package astronomy.taocraft
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.client.gui.achievement._;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.IGuiHandler;
import astronomy.taocraft.client.gui._;

/**
 * @author xfeng
 */
class ModGuiHandler extends IGuiHandler
{
	def getServerGuiElement ( ID:Int, player:EntityPlayer, world:World, x:Int, y:Int, z:Int ) : Object =
    {
      null
    }
  def getClientGuiElement ( ID:Int, player:EntityPlayer, world:World, x:Int, y:Int, z:Int ) : Object =
    {
      ID match{
        case 20=>new GuiResearch
        case 999=>new GuiAchievements(null,Minecraft.getMinecraft.thePlayer.getStatFileWriter())
      }
    }
}