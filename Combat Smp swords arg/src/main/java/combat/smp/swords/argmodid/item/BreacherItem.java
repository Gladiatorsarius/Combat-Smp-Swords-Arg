package combat.smp.swords.argmodid.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;

public class BreacherItem extends BaseDurableItem {
    public BreacherItem(Settings settings) { super(settings, 1200); }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker.getWorld() instanceof ServerWorld server) {
            // Apply extra armor-piercing (true) damage to largely ignore armor
            target.damage(server, server.getDamageSources().outOfWorld(), 5.0f);
        }
        super.postHit(stack, target, attacker);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        // Always render as if enchanted (represents "Breach X")
        return true;
    }
}
