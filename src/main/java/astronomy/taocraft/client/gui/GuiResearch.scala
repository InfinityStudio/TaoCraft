package astronomy.taocraft.client.gui
import net.minecraft.client.gui._;
import org.lwjgl.input.Mouse;
import net.minecraftforge.fml.client.config.GuiCheckBox;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiScreenEvent.ActionPerformedEvent;
import net.minecraftforge.common.MinecraftForge;
import org.lwjgl.opengl.GL11;

/**
 * @author xfeng
 */
class GuiResearch extends GuiScreen {
	def portstartX = (width - frametextureX) / 2
	def portstartY = (height - frametextureY) / 2
	def mapstartX = (width - mapportX) / 2
	def mapstartY = (height - mapportY) / 2
	val frametextureX: Int = 256
	val frametextureY: Int = 230
	val mapportX: Int = 224
	val mapportY: Int = 196
  val maptexturesize = 512
	val frameResourceLocation = new ResourceLocation("textures/gui/gui_research.png");
	val mapResourceLocation = new ResourceLocation("textures/gui/gui_researchback.png");
	var scale: Double = 1.0
	var mouseXprevent: Int = 0
	var mouseYprevent: Int = 0
	var mapcutX = 0.0
	var mapcutY = 0.0
	def GuiResearch() {

	}
	override def drawScreen(mouseX: Int, mouseY: Int, partialTicks: Float) = {
		transviewport(mouseX, mouseY);
		super.drawScreen(mouseX, mouseY, partialTicks);
		drawDefaultBackground();
		drawResearch();
		drawframe();
	}
	def transviewport(mouseX: Int, mouseY: Int) = {
		if (Mouse.isButtonDown(0)) {


			if (mouseX >= mapstartX && mouseX < mapstartX + mapportX && mouseY >= mapstartY && mouseY < mapstartY + mapportY&&mouseXprevent>0&&mouseYprevent>0) {
				mapcutX -= ((mouseX - mouseXprevent) * scale);
				mapcutX = if (mapcutX < 0.0) 0.0 else if (mapcutX > maptexturesize-mapportX) maptexturesize-mapportX else mapcutX
				mapcutY -= ((mouseY - mouseYprevent) * scale);
				mapcutY = if (mapcutY < 0.0) 0.0 else if (mapcutY > maptexturesize-mapportY) maptexturesize-mapportY else mapcutY
			}
			this.mouseXprevent = mouseX;
			this.mouseYprevent = mouseY;
		}
		else
		{
			this.mouseXprevent = -1;
			this.mouseYprevent = -1;
		}
	}
	def drawframe() = {
		GlStateManager.enableBlend()
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		this.mc.getTextureManager().bindTexture(frameResourceLocation);
		drawTexturedModalRect(portstartX, portstartY, 0, 0, frametextureX, frametextureY)
	}
	def drawResearch() = {
		this.mc.getTextureManager().bindTexture(mapResourceLocation);
		drawTexturedModalRect(mapstartX, mapstartY, mapcutX.toInt, mapcutY.toInt, mapportX, mapportY)
	}
}