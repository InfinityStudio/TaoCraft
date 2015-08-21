package astronomy.taocraft.client.gui
import net.minecraft.client.gui._;
import org.lwjgl.input.Mouse;

/**
 * @author xfeng
 */
class GuiResearch extends GuiScreen
{
  var portstartX:Int = 0
  var portstartY:Int = 0
  def GuiResearch()
  {
    
  }
  override def drawScreen(mouseX:Int, mouseY:Int, partialTicks:Float) = 
  {
    transviewport(mouseX,mouseY);
    super.drawScreen(mouseX, mouseY, partialTicks);
    this.drawDefaultBackground
  }
  def transviewport(mouseX:Int, mouseY:Int) = 
  {
    if (Mouse.isButtonDown(0))
            {
                val k = (this.width - this.field_146555_f) / 2;
                val l = (this.height - this.field_146557_g) / 2;
                val i1 = k + 8;
                val j1 = l + 17;

                if ((this.field_146554_D == 0 || this.field_146554_D == 1) && mouseX >= i1 && mouseX < i1 + 224 && mouseY >= j1 && mouseY < j1 + 155)
                {
                    if (this.field_146554_D == 0)
                    {
                        this.field_146554_D = 1;
                    }
                    else
                    {
                        this.field_146567_u -= (double)((float)(mouseX - this.field_146563_h) * this.field_146570_r);
                        this.field_146566_v -= (double)((float)(mouseY - this.field_146564_i) * this.field_146570_r);
                        this.field_146565_w = this.field_146569_s = this.field_146567_u;
                        this.field_146573_x = this.field_146568_t = this.field_146566_v;
                    }

                    this.field_146563_h = mouseX;
                    this.field_146564_i = mouseY;
                }
            }
  }
}