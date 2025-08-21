package combat.smp.swords.argmodid.effect;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CorrosiveFireStatusEffect extends StatusEffect {
    private static final Map<UUID, Long> SECOND_HIT_AT = new HashMap<>();

    public CorrosiveFireStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 0x7A2A2A);
    }

    private void damageEquipment(LivingEntity entity, int amount) {
        if (!(entity instanceof PlayerEntity player)) return; // limit to players for API stability
        ItemStack head = player.getEquippedStack(EquipmentSlot.HEAD);
        if (!head.isEmpty()) head.damage(amount, player);
        ItemStack chest = player.getEquippedStack(EquipmentSlot.CHEST);
        if (!chest.isEmpty()) chest.damage(amount, player);
        ItemStack legs = player.getEquippedStack(EquipmentSlot.LEGS);
        if (!legs.isEmpty()) legs.damage(amount, player);
        ItemStack feet = player.getEquippedStack(EquipmentSlot.FEET);
        if (!feet.isEmpty()) feet.damage(amount, player);
        ItemStack main = player.getMainHandStack();
        if (!main.isEmpty()) main.damage(amount, player);
        ItemStack off = player.getOffHandStack();
        if (!off.isEmpty()) off.damage(amount, player);
    }

    // Mapping-tolerant hooks (no @Override): one of these onApplied overloads will be used
    public void onApplied(LivingEntity entity, int amplifier) {
        damageEquipment(entity, 50);
        SECOND_HIT_AT.put(entity.getUuid(), entity.getWorld().getTime() + 200);
    }

    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        damageEquipment(entity, 50);
        SECOND_HIT_AT.put(entity.getUuid(), entity.getWorld().getTime() + 200);
    }

    // Tick callback
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        Long when = SECOND_HIT_AT.get(entity.getUuid());
        if (when != null && entity.getWorld().getTime() >= when) {
            damageEquipment(entity, 50);
            SECOND_HIT_AT.remove(entity.getUuid());
        }
    }

    // Allow per-tick updates
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
