package net.mcreator.legendarycrate.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.legendarycrate.network.LegendaryCrateModVariables;

public class ChaosCrystalItemInInventoryTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
			_vars.Djump = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
			_vars.Tp = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
			_vars.cooldownThunder = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
			_vars.phantomwings = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
			_vars.tntcooldown = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
			_vars.GhostBladeDash = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
			_vars.VoidRelicTimer = 12000;
			_vars.syncPlayerVariables(entity);
		}
		{
			LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
			_vars.WindBladeCooldown = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
			_vars.WindBladeBautaReset = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
			_vars.WardenBlasterCharge = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
			_vars.DripstonerCooldown = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
			_vars.godsviewcooldown = 0;
			_vars.syncPlayerVariables(entity);
		}
		{
			LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
			_vars.phantominvisscooldown = 0;
			_vars.syncPlayerVariables(entity);
		}
	}
}