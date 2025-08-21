package net.mcreator.legendarycrate.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.legendarycrate.network.LegendaryCrateModVariables;
import net.mcreator.legendarycrate.LegendaryCrateMod;

public class PhantomBladeRightclickedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).phantominvisscooldown == 0) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 200, 1, false, false));
			{
				LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
				_vars.phantominvisscooldown = 1;
				_vars.syncPlayerVariables(entity);
			}
			LegendaryCrateMod.queueServerWork(300, () -> {
				{
					LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
					_vars.phantominvisscooldown = 0;
					_vars.syncPlayerVariables(entity);
				}
			});
		}
	}
}