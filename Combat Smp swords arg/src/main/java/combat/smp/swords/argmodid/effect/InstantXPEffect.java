package combat.smp.swords.argmodid.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.network.ServerPlayerEntity;

public class InstantXPEffect extends StatusEffect {
    public InstantXPEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0x33CCFF);
    }

    private void grant(LivingEntity entity) {
        if (entity.getWorld().isClient) return;
        if (entity instanceof ServerPlayerEntity sp) {
            sp.addExperience(500);
        }
    }

    // Mapping-tolerant: provide both common overloads
    public void onApplied(LivingEntity entity, int amplifier) {
        grant(entity);
    }

    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        grant(entity);
    }
}
