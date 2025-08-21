package net.mcreator.legendarycrate.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.legendarycrate.LegendaryCrateMod;

public class CorrosiveFireEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level) {
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(50, _level, null, _stkprov -> {
			});
		}
		if (world instanceof ServerLevel _level) {
			(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(50, _level, null, _stkprov -> {
			});
		}
		if (world instanceof ServerLevel _level) {
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).hurtAndBreak(50, _level, null, _stkprov -> {
			});
		}
		if (world instanceof ServerLevel _level) {
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).hurtAndBreak(50, _level, null, _stkprov -> {
			});
		}
		if (world instanceof ServerLevel _level) {
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).hurtAndBreak(50, _level, null, _stkprov -> {
			});
		}
		if (world instanceof ServerLevel _level) {
			(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).hurtAndBreak(50, _level, null, _stkprov -> {
			});
		}
		LegendaryCrateMod.queueServerWork(200, () -> {
			if (world instanceof ServerLevel _level) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).hurtAndBreak(50, _level, null, _stkprov -> {
				});
			}
			if (world instanceof ServerLevel _level) {
				(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).hurtAndBreak(50, _level, null, _stkprov -> {
				});
			}
			if (world instanceof ServerLevel _level) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).hurtAndBreak(50, _level, null, _stkprov -> {
				});
			}
			if (world instanceof ServerLevel _level) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).hurtAndBreak(50, _level, null, _stkprov -> {
				});
			}
			if (world instanceof ServerLevel _level) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).hurtAndBreak(50, _level, null, _stkprov -> {
				});
			}
			if (world instanceof ServerLevel _level) {
				(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).hurtAndBreak(50, _level, null, _stkprov -> {
				});
			}
		});
	}
}