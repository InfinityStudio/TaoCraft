package astronomy.taocraft
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraft.client.gui.achievement._
import astronomy.taocraft.client.gui.GuiResearch;

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
      new GuiResearch;
    }
}