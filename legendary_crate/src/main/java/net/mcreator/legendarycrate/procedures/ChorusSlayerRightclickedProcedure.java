package net.mcreator.legendarycrate.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.legendarycrate.network.LegendaryCrateModVariables;
import net.mcreator.legendarycrate.init.LegendaryCrateModItems;
import net.mcreator.legendarycrate.LegendaryCrateMod;

public class ChorusSlayerRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == LegendaryCrateModItems.CHORUS_SLAYER.get()) {
			if (entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).Tp < 1) {
				{
					LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
					_vars.Tp = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).Tp + 1;
					_vars.syncPlayerVariables(entity);
				}
				entity.push((entity.getLookAngle().x * 10), 0.2, (entity.getLookAngle().z * 10));
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.chorus_fruit.teleport")), SoundSource.MASTER, 50, 40);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.chorus_fruit.teleport")), SoundSource.MASTER, 50, 40, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.sendParticles(ParticleTypes.END_ROD, x, y, z, 80, 3, 0, 3, 5);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/tellraw @p {\"bold\":true,\"color\":\"dark_purple\",\"text\":\"60\"}");
				LegendaryCrateMod.queueServerWork(200, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/tellraw @p {\"bold\":true,\"color\":\"dark_purple\",\"text\":\"50\"}");
					LegendaryCrateMod.queueServerWork(200, () -> {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @p {\"bold\":true,\"color\":\"dark_purple\",\"text\":\"40\"}");
						LegendaryCrateMod.queueServerWork(200, () -> {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"/tellraw @p {\"bold\":true,\"color\":\"dark_purple\",\"text\":\"30\"}");
							LegendaryCrateMod.queueServerWork(200, () -> {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/tellraw @p {\"bold\":true,\"color\":\"dark_purple\",\"text\":\"20\"}");
								LegendaryCrateMod.queueServerWork(200, () -> {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/tellraw @p {\"bold\":true,\"color\":\"dark_purple\",\"text\":\"10\"}");
									LegendaryCrateMod.queueServerWork(20, () -> {
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													"/tellraw @p {\"bold\":true,\"color\":\"dark_purple\",\"text\":\"9\"}");
										LegendaryCrateMod.queueServerWork(20, () -> {
											if (world instanceof ServerLevel _level)
												_level.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
														"/tellraw @p {\"bold\":true,\"color\":\"dark_purple\",\"text\":\"8\"}");
											LegendaryCrateMod.queueServerWork(20, () -> {
												if (world instanceof ServerLevel _level)
													_level.getServer().getCommands().performPrefixedCommand(
															new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
															"/tellraw @p {\"bold\":true,\"color\":\"dark_purple\",\"text\":\"7\"}");
												LegendaryCrateMod.queueServerWork(20, () -> {
													if (world instanceof ServerLevel _level)
														_level.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																"/tellraw @p {\"bold\":true,\"color\":\"dark_purple\",\"text\":\"6\"}");
													LegendaryCrateMod.queueServerWork(20, () -> {
														if (world instanceof ServerLevel _level)
															_level.getServer().getCommands().performPrefixedCommand(
																	new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																	"/tellraw @p {\"bold\":true,\"color\":\"dark_purple\",\"text\":\"5\"}");
														LegendaryCrateMod.queueServerWork(20, () -> {
															if (world instanceof ServerLevel _level)
																_level.getServer().getCommands().performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																		"/tellraw @p {\"bold\":true,\"color\":\"dark_purple\",\"text\":\"4\"}");
															LegendaryCrateMod.queueServerWork(20, () -> {
																if (world instanceof ServerLevel _level)
																	_level.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																			"/tellraw @p {\"bold\":true,\"color\":\"dark_purple\",\"text\":\"3\"}");
																LegendaryCrateMod.queueServerWork(20, () -> {
																	if (world instanceof ServerLevel _level)
																		_level.getServer().getCommands().performPrefixedCommand(
																				new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																				"/tellraw @p {\"bold\":true,\"color\":\"dark_purple\",\"text\":\"2\"}");
																	LegendaryCrateMod.queueServerWork(20, () -> {
																		if (world instanceof ServerLevel _level)
																			_level.getServer().getCommands().performPrefixedCommand(
																					new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																					"/tellraw @p {\"bold\":true,\"color\":\"dark_purple\",\"text\":\"1\"}");
																		LegendaryCrateMod.queueServerWork(20, () -> {
																			if (world instanceof ServerLevel _level)
																				_level.getServer().getCommands().performPrefixedCommand(
																						new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																						"/tellraw @p {\"bold\":true,\"color\":\"dark_purple\",\"text\":\"Chorus tp Ready\"}");
																			{
																				LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
																				_vars.Tp = 0;
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
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/tellraw @p {\"bold\":true,\"color\":\"dark_purple\",\"text\":\"Ability on Cooldown\"}");
			}
		}
	}
}