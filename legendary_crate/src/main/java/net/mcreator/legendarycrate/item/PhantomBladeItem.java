package net.mcreator.legendarycrate.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.legendarycrate.procedures.PhantomBladeToolInInventoryTickProcedure;
import net.mcreator.legendarycrate.procedures.PhantomBladeRightclickedProcedure;

public class PhantomBladeItem extends ShieldItem {
	public PhantomBladeItem(Item.Properties properties) {
		super(properties.durability(300).repairable(TagKey.create(Registries.ITEM, ResourceLocation.parse("legendary_crate:phantom_blade_repair_items"))));
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		PhantomBladeRightclickedProcedure.execute(world, entity);
		return ar;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		PhantomBladeToolInInventoryTickProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}