package combat.smp.swords.argmodid.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

public class AmethystSwordItem extends BaseDurableItem {
    public AmethystSwordItem(Settings settings) { 
        super(settings.fireproof(), 4620);
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Play amethyst hit sound
        if (attacker.getWorld() != null && !attacker.getWorld().isClient) {
            attacker.getWorld().playSound(null, attacker.getBlockPos(), 
                SoundEvents.BLOCK_AMETHYST_BLOCK_HIT, SoundCategory.PLAYERS, 1.0f, 1.0f);
        }
        super.postHit(stack, target, attacker);
    }
}
