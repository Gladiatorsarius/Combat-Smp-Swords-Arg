package net.mcreator.legendarycrate.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

import net.mcreator.legendarycrate.procedures.LevitationWandRightclickedProcedure;

public class LevitationWandItem extends Item {
	public LevitationWandItem(Item.Properties properties) {
		super(properties.durability(1000));
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		LevitationWandRightclickedProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity.getItemInHand(hand));
		return ar;
	}
}