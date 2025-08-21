package net.mcreator.legendarycrate.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.legendarycrate.network.LegendaryCrateModVariables;
import net.mcreator.legendarycrate.LegendaryCrateMod;

public class AncientVoidRelicToolInHandTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
			_vars.VoidRelicTimer = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).VoidRelicTimer + 1;
			_vars.syncPlayerVariables(entity);
		}
		if (entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).VoidRelicTimer >= 12000) {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/tellraw @p {\"bold\":true,\"color\":\"black\",\"text\":\"The Void Tentacels trust you now! Use there powers quick!\"}");
			LegendaryCrateMod.queueServerWork(80, () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/tellraw @p {\"bold\":true,\"color\":\"black\",\"text\":\"The Void Tentacels lost trust in you!\"}");
				{
					LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
					_vars.VoidRelicTimer = 6000;
					_vars.syncPlayerVariables(entity);
				}
			});
		}
	}
}