package net.mcreator.legendarycrate.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.tags.TagKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.legendarycrate.procedures.TNTRodRightclickedProcedure;

public class TNTRodItem extends FishingRodItem {
	public TNTRodItem(Item.Properties properties) {
		super(properties.durability(5000).repairable(TagKey.create(Registries.ITEM, ResourceLocation.parse("legendary_crate:tnt_rod_repair_items"))).enchantable(2));
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		super.use(world, entity, hand);
		ItemStack itemstack = entity.getItemInHand(hand);
		TNTRodRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return InteractionResult.SUCCESS;
	}
}