package net.mcreator.legendarycrate.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.legendarycrate.procedures.PotionOfIntstantXPEffectStartedappliedProcedure;

public class PotionOfIntstantXPMobEffect extends MobEffect {
	public PotionOfIntstantXPMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16716033);
		this.withSoundOnAdded(BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.experience_orb.pickup")));
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		PotionOfIntstantXPEffectStartedappliedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
	}
}