package net.mcreator.legendarycrate.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.legendarycrate.network.LegendaryCrateModVariables;
import net.mcreator.legendarycrate.init.LegendaryCrateModItems;
import net.mcreator.legendarycrate.LegendaryCrateMod;

public class TntSwordRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == LegendaryCrateModItems.TNT_SWORD.get()) {
			if (entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).tntcooldown < 1) {
				{
					LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
					_vars.tntcooldown = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).tntcooldown + 1;
					_vars.syncPlayerVariables(entity);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.tnt.primed")), SoundSource.MASTER, 50, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.tnt.primed")), SoundSource.MASTER, 50, 1, false);
					}
				}
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.TNT_MINECART.spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 1.5, 0);
					}
				}
				LegendaryCrateMod.queueServerWork(20, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/tellraw @p {\"color\":\"dark_red\",\"text\":\"15\"}");
					LegendaryCrateMod.queueServerWork(20, () -> {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @p {\"color\":\"dark_red\",\"text\":\"14\"}");
						LegendaryCrateMod.queueServerWork(20, () -> {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"/tellraw @p {\"color\":\"dark_red\",\"text\":\"13\"}");
							LegendaryCrateMod.queueServerWork(20, () -> {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/tellraw @p {\"color\":\"dark_red\",\"text\":\"12\"}");
								LegendaryCrateMod.queueServerWork(20, () -> {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/tellraw @p {\"color\":\"dark_red\",\"text\":\"11\"}");
									LegendaryCrateMod.queueServerWork(20, () -> {
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													"/tellraw @p {\"color\":\"dark_red\",\"text\":\"10\"}");
										LegendaryCrateMod.queueServerWork(20, () -> {
											if (world instanceof ServerLevel _level)
												_level.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
														"/tellraw @p {\"color\":\"dark_red\",\"text\":\"9\"}");
											LegendaryCrateMod.queueServerWork(20, () -> {
												if (world instanceof ServerLevel _level)
													_level.getServer().getCommands().performPrefixedCommand(
															new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
															"/tellraw @p {\"color\":\"dark_red\",\"text\":\"8\"}");
												LegendaryCrateMod.queueServerWork(20, () -> {
													if (world instanceof ServerLevel _level)
														_level.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																"/tellraw @p {\"color\":\"dark_red\",\"text\":\"7\"}");
													LegendaryCrateMod.queueServerWork(20, () -> {
														if (world instanceof ServerLevel _level)
															_level.getServer().getCommands().performPrefixedCommand(
																	new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																	"/tellraw @p {\"color\":\"dark_red\",\"text\":\"6\"}");
														LegendaryCrateMod.queueServerWork(20, () -> {
															if (world instanceof ServerLevel _level)
																_level.getServer().getCommands().performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																		"/tellraw @p {\"color\":\"dark_red\",\"text\":\"5\"}");
															LegendaryCrateMod.queueServerWork(20, () -> {
																if (world instanceof ServerLevel _level)
																	_level.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																			"/tellraw @p {\"color\":\"dark_red\",\"text\":\"4\"}");
																LegendaryCrateMod.queueServerWork(20, () -> {
																	if (world instanceof ServerLevel _level)
																		_level.getServer().getCommands().performPrefixedCommand(
																				new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																				"/tellraw @p {\"color\":\"dark_red\",\"text\":\"3\"}");
																	LegendaryCrateMod.queueServerWork(20, () -> {
																		if (world instanceof ServerLevel _level)
																			_level.getServer().getCommands().performPrefixedCommand(
																					new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																					"/tellraw @p {\"color\":\"dark_red\",\"text\":\"2\"}");
																		LegendaryCrateMod.queueServerWork(20, () -> {
																			if (world instanceof ServerLevel _level)
																				_level.getServer().getCommands().performPrefixedCommand(
																						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																						"/tellraw @p {\"color\":\"dark_red\",\"text\":\"1\"}");
																			LegendaryCrateMod.queueServerWork(20, () -> {
																				if (world instanceof ServerLevel _level)
																					_level.getServer().getCommands().performPrefixedCommand(
																							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null)
																									.withSuppressedOutput(),
																							"/tellraw @p {\"color\":\"dark_red\",\"text\":\"explosion ready\"}");
																				{
																					LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
																					_vars.tntcooldown = 0;
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
								});
							});
						});
					});
				});
			}
		}
	}
}