package net.mcreator.legendarycrate.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;

import net.mcreator.legendarycrate.procedures.ChaosCrystalItemInInventoryTickProcedure;

public class ChaosCrystalItem extends Item {
	public ChaosCrystalItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		ChaosCrystalItemInInventoryTickProcedure.execute(entity);
	}
}