package net.mcreator.legendarycrate.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.legendarycrate.procedures.CorrosiveFireEffectStartedappliedProcedure;

public class CorrosiveFireMobEffect extends InstantenousMobEffect {
	public CorrosiveFireMobEffect() {
		super(MobEffectCategory.HARMFUL, -10027162);
	}

	@Override
	public void applyInstantenousEffect(ServerLevel level, Entity source, Entity indirectSource, LivingEntity entity, int amplifier, double health) {
		CorrosiveFireEffectStartedappliedProcedure.execute(level, entity);
	}
}