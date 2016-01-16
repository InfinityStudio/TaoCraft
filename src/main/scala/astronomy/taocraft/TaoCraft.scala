package astronomy.taocraft

import net.minecraft.server.MinecraftServer
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.event._
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.FMLCommonHandler
import net.minecraftforge.fml.common.network.NetworkRegistry
import astronomy.taocraft.research._
import astronomy.taocraft.network.PacketDispatcher
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper
/**
 * @author xfeng
 */
//@Mod(modid = "taocraft", name = "TaoCraft", version = "0.0.w", modLanguage = "scala")
object TaoCraft 
{
  var events:ModEventHandler = new ModEventHandler

  @SidedProxy  (clientSide = "astronomy.taocraft.client.ClientProxy", serverSide = "astronomy.taocraft.server.ServerProxy" )
  var proxy: CommonProxy = null

  var tao_items: ModItems = null
  var tao_blocks: ModBlocks = null
  var tao_worldgen: ModWorldGenerator = null

  var simplenetwork:SimpleNetworkWrapper = null

  @EventHandler
  def Preinit(e: FMLPreInitializationEvent ) = {
    MinecraftForge.EVENT_BUS.register(events)
    FMLCommonHandler.instance().bus().register(events)
    simplenetwork = PacketDispatcher("taocraft")
  }
  @EventHandler
  def init(e: FMLInitializationEvent ) = {
    proxy.registerKeyBindings()
    NetworkRegistry.INSTANCE.registerGuiHandler(this, proxy.guis)
    tao_items = new ModItems
    tao_blocks = new ModBlocks
    tao_worldgen = new ModWorldGenerator
    proxy.registerItemModels(tao_items.Items)
    proxy.registerBlockModels(tao_blocks.Blocks)
    tao_worldgen.execWorldGen(tao_blocks.Blocks)
  }
  @EventHandler
  def serverinit(e:FMLServerStartedEvent) = {
    PlayerResearchMP.world = MinecraftServer.getServer.worldServerForDimension(0)
  }
   

}