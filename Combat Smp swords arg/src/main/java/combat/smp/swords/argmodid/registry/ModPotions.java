package combat.smp.swords.argmodid.registry;

import combat.smp.swords.argmodid.CombatSmpSwordsArg;
import combat.smp.swords.argmodid.item.ModItems;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.entity.effect.StatusEffects;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ModPotions {
    public static Potion CORROSIVE_FIRE;
    public static Potion INSTANT_XP;
    public static Potion PVP_POTION;

    public static void register() {
    // Corrosive Fire 30s
    StatusEffectInstance sei = new StatusEffectInstance(ModEffects.CORROSIVE_FIRE, 20 * 30);
    Potion potion = new Potion("corrosive_fire", sei);
    CORROSIVE_FIRE = Registry.register(Registries.POTION, Identifier.of(CombatSmpSwordsArg.MOD_ID, "corrosive_fire"), potion);

    // Instant XP: applies our INSTANT_XP effect immediately (duration 1 tick is enough)
    INSTANT_XP = Registry.register(Registries.POTION, Identifier.of(CombatSmpSwordsArg.MOD_ID, "instant_xp"), new Potion("instant_xp", new StatusEffectInstance(ModEffects.INSTANT_XP, 1)));

    // PVP potion: Speed II, Strength II, Fire Resistance I for 5 minutes
    PVP_POTION = Registry.register(Registries.POTION, Identifier.of(CombatSmpSwordsArg.MOD_ID, "pvp_potion"), new Potion("pvp_potion",
        new StatusEffectInstance(StatusEffects.SPEED, 20 * 60 * 5, 1),
        new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 60 * 5, 1),
        new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20 * 60 * 5, 0)
    ));

        // Try to register brewing: Water Bottle + Corrosive Dust -> Corrosive Fire
        try {
            Class<?> pb = Class.forName("net.minecraft.potion.PotionBrewing");
            boolean ok = false;
            for (Method m : pb.getDeclaredMethods()) {
                if (!Modifier.isStatic(m.getModifiers())) continue;
                Class<?>[] p = m.getParameterTypes();
                if (p.length != 3) continue;
                // Patterns seen across versions: (Potion, Item, Potion) or (Potion, Ingredient, Potion)
                if (Potion.class.isAssignableFrom(p[0]) && Potion.class.isAssignableFrom(p[2])) {
                    try {
                        if (Item.class.isAssignableFrom(p[1])) {
                            m.setAccessible(true);
                            m.invoke(null, Potions.WATER, ModItems.CORROSIVE_DUST, CORROSIVE_FIRE);
                            ok = true; break;
                        } else if (Ingredient.class.isAssignableFrom(p[1])) {
                            m.setAccessible(true);
                            m.invoke(null, Potions.WATER, Ingredient.ofItems(ModItems.CORROSIVE_DUST), CORROSIVE_FIRE);
                            ok = true; break;
                        }
                    } catch (Throwable ignore) { }
                }
            }
            if (ok) {
                CombatSmpSwordsArg.LOGGER.info("[Init] Brewing: Water Bottle + Corrosive Dust -> Corrosive Fire registered");
            } else {
                CombatSmpSwordsArg.LOGGER.warn("[Init] Brewing registration not found in current mappings; potion is registered, but brewing mix was skipped.");
            }
        } catch (Throwable t) {
            // Mappings can differ; if this fails it's non-fatal. Players can still obtain the potion via commands or recipes.
            CombatSmpSwordsArg.LOGGER.info("[Init] Brewing reflection couldn't wire Water Bottle + Corrosive Dust. Potion is registered; consider a data pack recipe if needed.");
        }

        // Try to register brewing: Water Bottle + XP_ORB -> Instant XP
        try {
            Class<?> pb = Class.forName("net.minecraft.potion.PotionBrewing");
            boolean ok = false;
            for (Method m : pb.getDeclaredMethods()) {
                if (!Modifier.isStatic(m.getModifiers())) continue;
                Class<?>[] p = m.getParameterTypes();
                if (p.length != 3) continue;
                if (Potion.class.isAssignableFrom(p[0]) && Potion.class.isAssignableFrom(p[2])) {
                    try {
                        if (Item.class.isAssignableFrom(p[1])) {
                            m.setAccessible(true);
                            m.invoke(null, Potions.WATER, ModItems.XP_ORB, INSTANT_XP);
                            ok = true; break;
                        } else if (Ingredient.class.isAssignableFrom(p[1])) {
                            m.setAccessible(true);
                            m.invoke(null, Potions.WATER, Ingredient.ofItems(ModItems.XP_ORB), INSTANT_XP);
                            ok = true; break;
                        }
                    } catch (Throwable ignore) { }
                }
            }
            if (ok) {
                CombatSmpSwordsArg.LOGGER.info("[Init] Brewing: Water Bottle + XP Orb -> Instant XP registered");
            }
        } catch (Throwable t) {
            CombatSmpSwordsArg.LOGGER.info("[Init] Brewing reflection couldn't wire Water Bottle + XP Orb.");
        }

        // Try to register brewing: Water Bottle + Nether Star -> PVP Potion
        try {
            Class<?> pb = Class.forName("net.minecraft.potion.PotionBrewing");
            boolean ok = false;
            for (Method m : pb.getDeclaredMethods()) {
                if (!Modifier.isStatic(m.getModifiers())) continue;
                Class<?>[] p = m.getParameterTypes();
                if (p.length != 3) continue;
                if (Potion.class.isAssignableFrom(p[0]) && Potion.class.isAssignableFrom(p[2])) {
                    try {
                        if (Item.class.isAssignableFrom(p[1])) {
                            m.setAccessible(true);
                            m.invoke(null, Potions.WATER, net.minecraft.item.Items.NETHER_STAR, PVP_POTION);
                            ok = true; break;
                        } else if (Ingredient.class.isAssignableFrom(p[1])) {
                            m.setAccessible(true);
                            m.invoke(null, Potions.WATER, Ingredient.ofItems(net.minecraft.item.Items.NETHER_STAR), PVP_POTION);
                            ok = true; break;
                        }
                    } catch (Throwable ignore) { }
                }
            }
            if (ok) {
                CombatSmpSwordsArg.LOGGER.info("[Init] Brewing: Water Bottle + Nether Star -> PVP Potion registered");
            }
        } catch (Throwable t) {
            CombatSmpSwordsArg.LOGGER.info("[Init] Brewing reflection couldn't wire Water Bottle + Nether Star.");
        }
    }
}
