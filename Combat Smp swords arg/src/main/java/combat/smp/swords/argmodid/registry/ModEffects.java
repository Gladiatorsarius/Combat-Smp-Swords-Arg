package combat.smp.swords.argmodid.registry;

import combat.smp.swords.argmodid.CombatSmpSwordsArg;
import combat.smp.swords.argmodid.effect.CorrosiveFireStatusEffect;
import combat.smp.swords.argmodid.effect.InstantXPEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static RegistryEntry<StatusEffect> CORROSIVE_FIRE;
    public static RegistryEntry<StatusEffect> INSTANT_XP;

    public static void register() {
    StatusEffect se = Registry.register(Registries.STATUS_EFFECT, Identifier.of(CombatSmpSwordsArg.MOD_ID, "corrosive_fire"), new CorrosiveFireStatusEffect());
    CORROSIVE_FIRE = Registries.STATUS_EFFECT.getEntry(se);
    StatusEffect xp = Registry.register(Registries.STATUS_EFFECT, Identifier.of(CombatSmpSwordsArg.MOD_ID, "instant_xp"), new InstantXPEffect());
    INSTANT_XP = Registries.STATUS_EFFECT.getEntry(xp);
        CombatSmpSwordsArg.LOGGER.info("[Init] Effects registered");
    }
}
