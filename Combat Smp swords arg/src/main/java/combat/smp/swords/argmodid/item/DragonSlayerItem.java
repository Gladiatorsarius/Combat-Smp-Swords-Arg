package combat.smp.swords.argmodid.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;

public class DragonSlayerItem extends BaseDurableItem {
    public DragonSlayerItem(Settings settings) { super(settings, 12500); }
    
    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker instanceof PlayerEntity player && attacker.getWorld() instanceof ServerWorld world) {
            // Dragon Slayer has all sword enchantments at level 10
            // Sharpness X: 0.5 + 0.5 * 10 = 5.5 extra damage
            target.damage(world, world.getDamageSources().playerAttack(player), 5.5f);
            
            // Knockback X: Very strong knockback
            double dx = target.getX() - player.getX();
            double dz = target.getZ() - player.getZ();
            double norm = Math.max(0.0001, Math.hypot(dx, dz));
            target.takeKnockback(0.4f + 0.1f * 10, dx / norm, dz / norm); // Knockback X
            
            // Fire Aspect X: Set on fire for 10 levels * 4 ticks = 40 ticks (2 seconds)
            target.setOnFireFor(40);
            
            // Note: Other enchantments like Looting, Sweeping Edge, Unbreaking, Mending 
            // are harder to simulate through postHit, but the main combat effects are covered
        }
        super.postHit(stack, target, attacker);
    }
}
