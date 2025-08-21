package combat.smp.swords.argmodid.item;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AmethystPickaxeItem extends BaseDurableItem {
    public AmethystPickaxeItem(Settings settings) { super(settings, 15000); }

    // Simple "auto-smelt" on block break: replace common blocks with smelted drops
    private ItemStack smeltedFor(Block block) {
        if (block == Blocks.IRON_ORE || block == Blocks.DEEPSLATE_IRON_ORE) return new ItemStack(net.minecraft.item.Items.IRON_INGOT);
        if (block == Blocks.GOLD_ORE || block == Blocks.DEEPSLATE_GOLD_ORE) return new ItemStack(net.minecraft.item.Items.GOLD_INGOT);
        if (block == Blocks.COPPER_ORE || block == Blocks.DEEPSLATE_COPPER_ORE) return new ItemStack(net.minecraft.item.Items.COPPER_INGOT, 2);
        if (block == Blocks.ANCIENT_DEBRIS) return new ItemStack(net.minecraft.item.Items.NETHERITE_SCRAP);
        if (block == Blocks.SAND) return new ItemStack(net.minecraft.item.Items.GLASS);
        if (block == Blocks.CLAY) return new ItemStack(net.minecraft.item.Items.TERRACOTTA);
        return ItemStack.EMPTY;
    }

    // No @Override to tolerate mapping differences
    public boolean postMine(ItemStack stack, World world, net.minecraft.block.BlockState state, BlockPos pos, LivingEntity miner) {
        if (world.isClient) return true;
        ItemStack smelt = smeltedFor(state.getBlock());
        if (!smelt.isEmpty()) {
            world.breakBlock(pos, false, miner);
            Block.dropStack(world, pos, smelt.copy());
            world.playSound(null, pos, SoundEvents.BLOCK_BLASTFURNACE_FIRE_CRACKLE, SoundCategory.BLOCKS, 0.7f, 1.2f);
            if (miner instanceof net.minecraft.entity.player.PlayerEntity pe) {
                if (!pe.isCreative()) stack.damage(1, pe);
            }
            return true;
        }
        return true;
    }
}
