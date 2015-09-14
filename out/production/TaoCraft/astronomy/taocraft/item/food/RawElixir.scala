package astronomy.taocraft.item.food

import net.minecraft.item.ItemFood
import net.minecraft.potion.Potion

/**
 * @author Blealtan
 */
class RawElixir extends ItemFood(1, false){
  setAlwaysEdible()
  setPotionEffect(Potion.poison.id, 2, 1, 0.9f)
}
