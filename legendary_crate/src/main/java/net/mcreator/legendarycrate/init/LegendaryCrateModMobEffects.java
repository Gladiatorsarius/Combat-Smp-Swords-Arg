/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.legendarycrate.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.legendarycrate.potion.PotionOfIntstantXPMobEffect;
import net.mcreator.legendarycrate.potion.CorrosiveFireMobEffect;
import net.mcreator.legendarycrate.LegendaryCrateMod;

public class LegendaryCrateModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, LegendaryCrateMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> CORROSIVE_FIRE = REGISTRY.register("corrosive_fire", () -> new CorrosiveFireMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> POTION_OF_INTSTANT_XP = REGISTRY.register("potion_of_intstant_xp", () -> new PotionOfIntstantXPMobEffect());
}