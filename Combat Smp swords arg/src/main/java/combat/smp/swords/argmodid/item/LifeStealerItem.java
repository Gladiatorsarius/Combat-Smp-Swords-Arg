package combat.smp.swords.argmodid.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class LifeStealerItem extends BaseDurableItem {
    public LifeStealerItem(Settings settings) { super(settings, 9200); }

    @Override
    public void postDamageEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player) {
            // Check if target was killed (health <= 0)
            if (target.getHealth() <= 0 && player instanceof ServerPlayerEntity serverPlayer) {
                float targetMaxHealth = target.getMaxHealth();
                
                // Give 10% of the target's max health as permanent extra hearts using Absorption
                // Each absorption level gives 2 extra hearts
                float extraHearts = targetMaxHealth * 0.1f;
                int absorptionLevel = Math.min((int)(extraHearts / 2), 19); // Max level 19 (40 extra hearts)
                
                // Check current absorption level to avoid going over the 20 extra hearts limit
                StatusEffectInstance currentAbsorption = player.getStatusEffect(StatusEffects.ABSORPTION);
                int currentLevel = currentAbsorption != null ? currentAbsorption.getAmplifier() : -1;
                
                // Only add if we haven't reached the maximum (level 19 = 40 extra hearts)
                if (currentLevel < 19 && absorptionLevel > currentLevel) {
                    // Apply very long duration absorption effect (essentially permanent)
                    StatusEffectInstance newAbsorption = new StatusEffectInstance(
                        StatusEffects.ABSORPTION, 
                        20_000_000, // Very long duration (about 11.5 days)
                        Math.min(currentLevel + 1, 19), // Increment level but cap at 19
                        false, 
                        false // Hide particles for cleaner look
                    );
                    player.addStatusEffect(newAbsorption);
                    
                    // Heal to max absorption hearts
                    player.setHealth(player.getMaxHealth());
                    
                    // Notify player
                    float heartsGained = (currentLevel + 2 - Math.max(currentLevel, 0)) * 2;
                    serverPlayer.sendMessage(Text.literal("§c❤ Life Stealer: Gained " + String.format("%.0f", heartsGained) + " permanent hearts!"), false);
                } else if (currentLevel >= 19) {
                    // Notify that max has been reached
                    serverPlayer.sendMessage(Text.literal("§c❤ Life Stealer: Maximum extra hearts reached (20)!"), false);
                }
            }
        }
        super.postDamageEntity(stack, target, attacker);
    }
}
