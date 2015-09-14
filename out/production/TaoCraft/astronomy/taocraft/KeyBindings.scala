package astronomy.taocraft

import org.lwjgl.input.Keyboard;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraft.client.settings.KeyBinding;

/**
 * @author xfeng
 */
object KeyBindings
{
  var mainresearch:KeyBinding = null;
  def init()
  {
    mainresearch = new KeyBinding("key.research", Keyboard.KEY_O, "key.categories.taoresearch");
  }
}