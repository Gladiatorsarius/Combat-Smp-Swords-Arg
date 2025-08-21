package combat.smp.swords.argmodid.item;

import combat.smp.swords.argmodid.util.PlayerVars;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;

public class BerserkHandItem extends BaseDurableItem {
    public BerserkHandItem(Settings settings) { super(settings, 7210); }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player && attacker.getWorld() instanceof ServerWorld world) {
            float health = player.getHealth();
            int level;
            if (health > 18) level = 1;
            else if (health > 16) level = 2;
            else if (health > 14) level = 3;
            else if (health > 12) level = 4;
            else if (health > 10) level = 5;
            else if (health > 8) level = 6;
            else if (health > 6) level = 7;
            else if (health > 4) level = 8;
            else if (health > 2) level = 9;
            else level = 10;
            
            // Check if we should play sound (minimum 1 second between sounds)
            if (player instanceof net.minecraft.server.network.ServerPlayerEntity serverPlayer) {
                long lastSoundTime = PlayerVars.getBerserkLastSound(serverPlayer);
                long currentTime = world.getTime();
                
                // Play sound effect if enough time has passed (20 ticks = 1 second)
                if (currentTime - lastSoundTime >= 20) {
                    // Play "tripwire hook off" for removing old enchantments
                    world.playSound(null, player.getBlockPos(), SoundEvents.BLOCK_TRIPWIRE_DETACH, SoundCategory.PLAYERS, 0.5f, 1.0f);
                    
                    // Brief delay then play "tripwire hook on" for adding new enchantments
                    world.getServer().execute(() -> {
                        if (world.getTime() > currentTime) { // Make sure some time has passed
                            world.playSound(null, player.getBlockPos(), SoundEvents.BLOCK_TRIPWIRE_ATTACH, SoundCategory.PLAYERS, 0.5f, 1.0f);
                        }
                    });
                    
                    PlayerVars.setBerserkLastSound(serverPlayer, currentTime);
                }
            }
            
            // Apply Sharpness-like extra damage (vanilla Sharpness adds 0.5 + 0.5 * level damage)
            target.damage(world, world.getDamageSources().playerAttack(player), 0.5f + 0.5f * level);
            
            // Apply Knockback-like effect (vanilla Knockback adds 0.4 + 0.1 * level knockback strength)
            double dx = target.getX() - player.getX();
            double dz = target.getZ() - player.getZ();
            double norm = Math.max(0.0001, Math.hypot(dx, dz));
            target.takeKnockback(0.4f + 0.1f * level, dx / norm, dz / norm);
        }
        super.postHit(stack, target, attacker);
    }
}
