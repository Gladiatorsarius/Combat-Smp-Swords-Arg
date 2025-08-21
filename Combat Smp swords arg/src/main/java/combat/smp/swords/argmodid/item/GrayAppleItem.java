package combat.smp.swords.argmodid.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GrayAppleItem extends Item {
    public GrayAppleItem(Settings settings) {
        super(settings.food(new FoodComponent.Builder().alwaysEdible().nutrition(4).saturationModifier(0.3f).build()));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 20 * 10, 9)); // X -> amplifier 9
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 3, 0));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20 * 15, 4));
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20 * 5, 1));
        }
        return super.finishUsing(stack, world, user);
    }
}
