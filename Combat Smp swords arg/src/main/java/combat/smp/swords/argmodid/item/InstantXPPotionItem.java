package combat.smp.swords.argmodid.item;

import combat.smp.swords.argmodid.registry.ModEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class InstantXPPotionItem extends Item {
    public InstantXPPotionItem(Settings settings) { 
        super(settings.maxCount(16)); 
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            // Give instant XP by applying the instant XP effect
            user.addStatusEffect(new net.minecraft.entity.effect.StatusEffectInstance(ModEffects.INSTANT_XP, 1));
            
            ItemStack stack = user.getStackInHand(hand);
            if (!user.isCreative()) {
                stack.decrement(1);
            }
        }
        return ActionResult.SUCCESS;
    }
}
