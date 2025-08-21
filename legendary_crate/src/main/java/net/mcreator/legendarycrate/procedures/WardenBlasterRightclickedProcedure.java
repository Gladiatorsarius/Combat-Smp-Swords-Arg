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
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.legendarycrate.network.LegendaryCrateModVariables;
import net.mcreator.legendarycrate.init.LegendaryCrateModItems;
import net.mcreator.legendarycrate.LegendaryCrateMod;

public class WardenBlasterRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == LegendaryCrateModItems.WARDEN_BLASTER.get()) {
			if (entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES).WardenBlasterCharge == 0) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.warden.sonic_charge")), SoundSource.MASTER, 50, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.warden.sonic_charge")), SoundSource.MASTER, 50, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.warden.sonic_boom")), SoundSource.MASTER, 50, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.warden.sonic_boom")), SoundSource.MASTER, 50, 1, false);
					}
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute at @p run summon area_effect_cloud ^ ^1 ^1 {Radius:1f,Duration:20,potion_contents:{custom_effects:[{id:\"minecraft:instant_damage\",amplifier:4,duration:2,show_particles:0b}]}}");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute at @p run summon area_effect_cloud ^ ^1 ^2 {Radius:1,Duration:20,potion_contents:{custom_effects:[{id:\"minecraft:instant_damage\",amplifier:4,duration:2,show_particles:0b}]}}");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute at @p run summon area_effect_cloud ^ ^1 ^3 {Radius:1,Duration:20,potion_contents:{custom_effects:[{id:\"minecraft:instant_damage\",amplifier:4,duration:2,show_particles:0b}]}}");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute at @p run summon area_effect_cloud ^ ^1 ^4 {Radius:1f,Duration:20,potion_contents:{custom_effects:[{id:\"minecraft:instant_damage\",amplifier:3,duration:2,show_particles:0b}]}}");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute at @p run summon area_effect_cloud ^ ^1 ^5 {Radius:1f,Duration:20,potion_contents:{custom_effects:[{id:\"minecraft:instant_damage\",amplifier:3,duration:2,show_particles:0b}]}}");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute at @p run summon area_effect_cloud ^ ^1 ^6 {Radius:1f,Duration:20,potion_contents:{custom_effects:[{id:\"minecraft:instant_damage\",amplifier:3,duration:2,show_particles:0b}]}}");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute at @p run summon area_effect_cloud ^ ^1 ^7 {Radius:1f,Duration:20,potion_contents:{custom_effects:[{id:\"minecraft:instant_damage\",amplifier:3,duration:2,show_particles:0b}]}}");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute at @p run summon area_effect_cloud ^ ^1 ^8 {Radius:1f,Duration:20,potion_contents:{custom_effects:[{id:\"minecraft:instant_damage\",amplifier:3,duration:2,show_particles:0b}]}}");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute at @p run summon area_effect_cloud ^ ^1 ^9 {Radius:1f,Duration:20,potion_contents:{custom_effects:[{id:\"minecraft:instant_damage\",amplifier:3,duration:2,show_particles:0b}]}}");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute at @p run summon area_effect_cloud ^ ^1 ^10 {Radius:1f,Duration:20,potion_contents:{custom_effects:[{id:\"minecraft:instant_damage\",amplifier:3,duration:1,show_particles:0b}]}}");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute at @p run particle sonic_boom ^ ^1 ^1 0 0 0 1 0 normal");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute at @p run particle sonic_boom ^ ^1 ^2 0 0 0 1 0 normal");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute at @p run particle sonic_boom ^ ^1 ^3 0 0 0 1 0 normal");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute at @p run particle sonic_boom ^ ^1 ^4 0 0 0 1 0 normal");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute at @p run particle sonic_boom ^ ^1 ^5 0 0 0 1 0 normal");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute at @p run particle sonic_boom ^ ^1 ^6 0 0 0 1 0 normal");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute at @p run particle sonic_boom ^ ^1 ^7 0 0 0 1 0 normal");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute at @p run particle sonic_boom ^ ^1 ^8 0 0 0 1 0 normal");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute at @p run particle sonic_boom ^ ^1 ^9 0 0 0 1 0 normal");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/execute at @p run particle sonic_boom ^ ^1 ^10 0 0 0 1 0 normal");
				{
					LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
					_vars.WardenBlasterCharge = 1;
					_vars.syncPlayerVariables(entity);
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"/tellraw @p[limit=1] {\"color\":\"dark_blue\",\"text\":\"30\"}");
				LegendaryCrateMod.queueServerWork(200, () -> {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"/tellraw @p[limit=1] {\"color\":\"dark_blue\",\"text\":\"20\"}");
					LegendaryCrateMod.queueServerWork(200, () -> {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"/tellraw @p[limit=1] {\"color\":\"dark_blue\",\"text\":\"10\"}");
						LegendaryCrateMod.queueServerWork(20, () -> {
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										"/tellraw @p[limit=1] {\"color\":\"dark_blue\",\"text\":\"9\"}");
							LegendaryCrateMod.queueServerWork(20, () -> {
								if (world instanceof ServerLevel _level)
									_level.getServer().getCommands().performPrefixedCommand(
											new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
											"/tellraw @p[limit=1] {\"color\":\"dark_blue\",\"text\":\"8\"}");
								LegendaryCrateMod.queueServerWork(20, () -> {
									if (world instanceof ServerLevel _level)
										_level.getServer().getCommands().performPrefixedCommand(
												new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
												"/tellraw @p[limit=1] {\"color\":\"dark_blue\",\"text\":\"7\"}");
									LegendaryCrateMod.queueServerWork(20, () -> {
										if (world instanceof ServerLevel _level)
											_level.getServer().getCommands().performPrefixedCommand(
													new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
													"/tellraw @p[limit=1] {\"color\":\"dark_blue\",\"text\":\"6\"}");
										LegendaryCrateMod.queueServerWork(20, () -> {
											if (world instanceof ServerLevel _level)
												_level.getServer().getCommands().performPrefixedCommand(
														new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
														"/tellraw @p[limit=1] {\"color\":\"dark_blue\",\"text\":\"5\"}");
											LegendaryCrateMod.queueServerWork(20, () -> {
												if (world instanceof ServerLevel _level)
													_level.getServer().getCommands().performPrefixedCommand(
															new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
															"/tellraw @p[limit=1] {\"color\":\"dark_blue\",\"text\":\"4\"}");
												LegendaryCrateMod.queueServerWork(20, () -> {
													if (world instanceof ServerLevel _level)
														_level.getServer().getCommands().performPrefixedCommand(
																new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																"/tellraw @p[limit=1] {\"color\":\"dark_blue\",\"text\":\"3\"}");
													LegendaryCrateMod.queueServerWork(20, () -> {
														if (world instanceof ServerLevel _level)
															_level.getServer().getCommands().performPrefixedCommand(
																	new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																	"/tellraw @p[limit=1] {\"color\":\"dark_blue\",\"text\":\"2\"}");
														LegendaryCrateMod.queueServerWork(20, () -> {
															if (world instanceof ServerLevel _level)
																_level.getServer().getCommands().performPrefixedCommand(
																		new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																		"/tellraw @p[limit=1] {\"color\":\"dark_blue\",\"text\":\"1\"}");
															LegendaryCrateMod.queueServerWork(20, () -> {
																if (world instanceof ServerLevel _level)
																	_level.getServer().getCommands().performPrefixedCommand(
																			new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
																			"/tellraw @p[limit=1] {\"color\":\"dark_blue\",\"text\":\"SonicBoom Ready\"}");
																{
																	LegendaryCrateModVariables.PlayerVariables _vars = entity.getData(LegendaryCrateModVariables.PLAYER_VARIABLES);
																	_vars.WardenBlasterCharge = 0;
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
			}
		}
	}
}