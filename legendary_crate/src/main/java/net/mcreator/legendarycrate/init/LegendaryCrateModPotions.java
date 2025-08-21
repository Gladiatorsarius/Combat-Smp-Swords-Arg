/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.legendarycrate.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.core.registries.Registries;

import net.mcreator.legendarycrate.LegendaryCrateMod;

public class LegendaryCrateModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(Registries.POTION, LegendaryCrateMod.MODID);
	public static final DeferredHolder<Potion, Potion> PV_PPOTION = REGISTRY.register("pv_ppotion", () -> new Potion("pv_ppotion", new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6000, 1, false, false),
			new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000, 1, false, true), new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 0, false, true)));
	public static final DeferredHolder<Potion, Potion> CORROSIVE_FIRE_POTION = REGISTRY.register("corrosive_fire_potion",
			() -> new Potion("corrosive_fire_potion", new MobEffectInstance(LegendaryCrateModMobEffects.CORROSIVE_FIRE, 600, 1, true, true)));
	public static final DeferredHolder<Potion, Potion> POTION_OF_INSTANT_XP_POTION = REGISTRY.register("potion_of_instant_xp_potion",
			() -> new Potion("potion_of_instant_xp_potion", new MobEffectInstance(LegendaryCrateModMobEffects.POTION_OF_INTSTANT_XP, 200, 1, true, true)));
}