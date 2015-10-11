package astronomy.taocraft.item.food

import net.minecraft.item.{ItemStack, ItemFood}
import net.minecraft.potion.Potion
import net.minecraftforge.fml.common.registry.GameRegistry

/**
 * @author Blealtan
 */
class RawElixir extends ItemFood(1, false){
  setAlwaysEdible()
  setPotionEffect(Potion.poison.id, 10, 1, 0.5f)
}
