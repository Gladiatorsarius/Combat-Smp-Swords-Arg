package combat.smp.swords.argmodid.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class PVPPotionItem extends Item {
    public PVPPotionItem(Settings settings) { 
        super(settings.maxCount(16)); 
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            // Give Speed II, Strength II, and Fire Resistance I for 5 minutes
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 20 * 60 * 5, 1)); // Speed II for 5 minutes
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 60 * 5, 1)); // Strength II for 5 minutes
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20 * 60 * 5, 0)); // Fire Resistance I for 5 minutes
            
            ItemStack stack = user.getStackInHand(hand);
            if (!user.isCreative()) {
                stack.decrement(1);
            }
        }
        return ActionResult.SUCCESS;
    }
}
