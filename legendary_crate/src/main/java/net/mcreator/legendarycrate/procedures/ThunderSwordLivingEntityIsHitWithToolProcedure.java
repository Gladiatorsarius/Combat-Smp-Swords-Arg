package net.mcreator.legendarycrate.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.legendarycrate.network.LegendaryCrateModVariables;
import net.mcreator.legendarycrate.init.LegendaryCrateModItems;
import net.mcreator.legendarycrate.LegendaryCrateMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ThunderSwordLivingEntityIsHitWithToolProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == LegendaryCrateModItems.THUNDER_SWORD.get()) {
			for (int index0 = 0; index0 < 1; index0++) {
				if (entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).cooldownThunder < 1) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == LegendaryCrateModItems.THUNDER_SWORD.get()) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/execute at @e[distance=2..10] as @e[distance=2..10] run summon minecraft:lightning_bolt ~ ~ ~");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/execute at @e[distance=2..10] as @e[distance=2..10] run attribute @e minecraft:jump_strength base set 0");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/effect give @e[distance=2..10] slowness 3 10");
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/effect give @e[distance=2..10] blindness 3 10");
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
						LegendaryCrateMod.queueServerWork(40, () -> {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"/execute at @e[distance=2..50] as @e[distance=2..50] run attribute @e minecraft:jump_strength base reset");
						});
						{
							LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
							_vars.cooldownThunder = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).cooldownThunder + 1;
							_vars.syncPlayerVariables(entity);
						}
						LegendaryCrateMod.queueServerWork(20, () -> {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"/tellraw @p {\"color\":\"yellow\",\"text\":\"10\"}");
							LegendaryCrateMod.queueServerWork(20, () -> {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/tellraw @p {\"color\":\"yellow\",\"text\":\"9\"}");
								LegendaryCrateMod.queueServerWork(20, () -> {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/tellraw @p {\"color\":\"yellow\",\"text\":\"8\"}");
									LegendaryCrateMod.queueServerWork(20, () -> {
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													"/tellraw @p {\"color\":\"yellow\",\"text\":\"7\"}");
										LegendaryCrateMod.queueServerWork(20, () -> {
											if (world instanceof ServerLevel _level)
												_level.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
														"/tellraw @p {\"color\":\"yellow\",\"text\":\"6\"}");
											LegendaryCrateMod.queueServerWork(20, () -> {
												if (world instanceof ServerLevel _level)
													_level.getServer().getCommands().performPrefixedCommand(
															new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
															"/tellraw @p {\"color\":\"yellow\",\"text\":\"5\"}");
												LegendaryCrateMod.queueServerWork(20, () -> {
													if (world instanceof ServerLevel _level)
														_level.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																"/tellraw @p {\"color\":\"yellow\",\"text\":\"4\"}");
													LegendaryCrateMod.queueServerWork(20, () -> {
														if (world instanceof ServerLevel _level)
															_level.getServer().getCommands().performPrefixedCommand(
																	new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																	"/tellraw @p {\"color\":\"yellow\",\"text\":\"3\"}");
														LegendaryCrateMod.queueServerWork(20, () -> {
															if (world instanceof ServerLevel _level)
																_level.getServer().getCommands().performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																		"/tellraw @p {\"color\":\"yellow\",\"text\":\"2\"}");
															LegendaryCrateMod.queueServerWork(20, () -> {
																if (world instanceof ServerLevel _level)
																	_level.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																			"/tellraw @p {\"color\":\"yellow\",\"text\":\"1\"}");
																LegendaryCrateMod.queueServerWork(20, () -> {
																	if (world instanceof ServerLevel _level)
																		_level.getServer().getCommands().performPrefixedCommand(
																				new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																				"/tellraw @p {\"color\":\"yellow\",\"text\":\"Thunder Strike Ready\"}");
																	{
																		LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
																		_vars.cooldownThunder = 0;
																		_vars.syncPlayerVariables(entity);
																	}
																});
															});
														});
													});
												});
											});
										});
									});
								});
							});
						});
					}
				}
			}
		}
	}
}