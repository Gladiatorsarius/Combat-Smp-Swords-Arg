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

public class WindBladeRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).WindBladeCooldown == 0) {
			if (entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).Djump == 0) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == LegendaryCrateModItems.WIND_BLADE.get()) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/tellraw @p {\"bold\":true,\"color\":\"#14FFFF\",\"text\":\"3 Djumps left\"}");
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == LegendaryCrateModItems.WIND_BLADE.get()) {
						entity.push(0, 1, 0);
						if (world instanceof ServerLevel _level)
							_level.sendParticles(ParticleTypes.CLOUD, x, y, z, 50, 1, 3, 1, 1);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.armor.equip_elytra")), SoundSource.MASTER, 50, 40);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.armor.equip_elytra")), SoundSource.MASTER, 50, 40, false);
							}
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/effect give @p minecraft:slow_falling 10 1");
						{
							LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
							_vars.Djump = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).Djump + 1;
							_vars.syncPlayerVariables(entity);
						}
						LegendaryCrateMod.LOGGER.info(entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).Djump);
					}
				}
			} else {
				if (entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).Djump == 1) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == LegendaryCrateModItems.WIND_BLADE.get()) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @p {\"bold\":true,\"color\":\"#14FFFF\",\"text\":\"2 Djumps left\"}");
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == LegendaryCrateModItems.WIND_BLADE.get()) {
							entity.push(0, 1, 0);
							if (world instanceof ServerLevel _level)
								_level.sendParticles(ParticleTypes.CLOUD, x, y, z, 50, 1, 3, 1, 1);
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.armor.equip_elytra")), SoundSource.MASTER, 50, 40);
								} else {
									_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.armor.equip_elytra")), SoundSource.MASTER, 50, 40, false);
								}
							}
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"/effect give @p minecraft:slow_falling 10 1");
							{
								LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
								_vars.Djump = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).Djump + 1;
								_vars.syncPlayerVariables(entity);
							}
							LegendaryCrateMod.LOGGER.info(entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).Djump);
						}
					}
				} else {
					if (entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).Djump == 2) {
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == LegendaryCrateModItems.WIND_BLADE.get()) {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"/tellraw @p {\"bold\":true,\"color\":\"#14FFFF\",\"text\":\"1 Djump left\"}");
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == LegendaryCrateModItems.WIND_BLADE.get()) {
								entity.push(0, 1, 0);
								if (world instanceof ServerLevel _level)
									_level.sendParticles(ParticleTypes.CLOUD, x, y, z, 50, 1, 3, 1, 1);
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.armor.equip_elytra")), SoundSource.MASTER, 50, 40);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.armor.equip_elytra")), SoundSource.MASTER, 50, 40, false);
									}
								}
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/effect give @p minecraft:slow_falling 10 1");
								{
									LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
									_vars.Djump = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).Djump + 1;
									_vars.syncPlayerVariables(entity);
								}
								LegendaryCrateMod.LOGGER.info(entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).Djump);
							}
						}
					} else {
						if (entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).Djump == 3) {
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == LegendaryCrateModItems.WIND_BLADE.get()) {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/tellraw @p {\"bold\":true,\"color\":\"#14FFFF\",\"text\":\"No more Djumps... rightclick the item on the ground to reset\"}");
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == LegendaryCrateModItems.WIND_BLADE.get()) {
									entity.push(0, 1, 0);
									if (world instanceof ServerLevel _level)
										_level.sendParticles(ParticleTypes.CLOUD, x, y, z, 50, 1, 3, 1, 1);
									if (world instanceof Level _level) {
										if (!_level.isClientSide()) {
											_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.armor.equip_elytra")), SoundSource.MASTER, 50, 40);
										} else {
											_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.armor.equip_elytra")), SoundSource.MASTER, 50, 40, false);
										}
									}
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/effect give @p minecraft:slow_falling 10 1");
									{
										LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
										_vars.Djump = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).Djump + 1;
										_vars.syncPlayerVariables(entity);
									}
									LegendaryCrateMod.LOGGER.info(entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).Djump);
								}
							}
						} else {
							if (entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).WindBladeBautaReset == 0) {
								if (entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).Djump == 4) {
									if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == LegendaryCrateModItems.WIND_BLADE.get()) {
										if (world.getBlockState(BlockPos.containing(x, y - 1, z)).canOcclude()) {
											{
												LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
												_vars.WindBladeBautaReset = 1;
												_vars.syncPlayerVariables(entity);
											}
											LegendaryCrateMod.queueServerWork(20, () -> {
												if (world instanceof ServerLevel _level)
													_level.getServer().getCommands().performPrefixedCommand(
															new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
															"/tellraw @p {\"bold\":true,\"color\":\"#14FFFF\",\"text\":\"5\"}");
												LegendaryCrateMod.queueServerWork(20, () -> {
													if (world instanceof ServerLevel _level)
														_level.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																"/tellraw @p {\"bold\":true,\"color\":\"#14FFFF\",\"text\":\"4\"}");
													LegendaryCrateMod.queueServerWork(20, () -> {
														if (world instanceof ServerLevel _level)
															_level.getServer().getCommands().performPrefixedCommand(
																	new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																	"/tellraw @p {\"bold\":true,\"color\":\"#14FFFF\",\"text\":\"3\"}");
														LegendaryCrateMod.queueServerWork(20, () -> {
															if (world instanceof ServerLevel _level)
																_level.getServer().getCommands().performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																		"/tellraw @p {\"bold\":true,\"color\":\"#14FFFF\",\"text\":\"2\"}");
															LegendaryCrateMod.queueServerWork(20, () -> {
																if (world instanceof ServerLevel _level)
																	_level.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																			"/tellraw @p {\"bold\":true,\"color\":\"#14FFFF\",\"text\":\"1\"}");
																LegendaryCrateMod.queueServerWork(20, () -> {
																	if (world instanceof ServerLevel _level)
																		_level.getServer().getCommands().performPrefixedCommand(
																				new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																				"/tellraw @p {\"bold\":true,\"color\":\"#14FFFF\",\"text\":\"4 Djumps left\"}");
																	{
																		LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
																		_vars.Djump = 0;
																		_vars.syncPlayerVariables(entity);
																	}
																	{
																		LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
																		_vars.WindBladeBautaReset = 0;
																		_vars.syncPlayerVariables(entity);
																	}
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
				}
			}
		}
	}
}