package combat.smp.swords.argmodid.item;

import combat.smp.swords.argmodid.util.PlayerVars;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class TNTRodItem extends BaseDurableItem {
    public TNTRodItem(Settings settings) { super(settings, 5000); }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) return ActionResult.SUCCESS;
        if (!(user instanceof ServerPlayerEntity sp)) return ActionResult.SUCCESS;
        // Only works in main hand
        if (!user.getMainHandStack().equals(user.getStackInHand(hand))) return ActionResult.FAIL;

        FishingBobberEntity bobber = sp.fishHook;
        if (bobber == null) {
            user.sendMessage(net.minecraft.text.Text.literal("Cast the line first"), true);
            return ActionResult.FAIL;
        }
        Vec3d target = bobber.getPos();
        // Schedule 5 TNT spawns: 1s later then every 0.5s
        long now = world.getTime();
        PlayerVars.scheduleTnt(sp, now + 20, 5, target);
        user.sendMessage(net.minecraft.text.Text.literal("TNT rain scheduled"), true);
        return ActionResult.SUCCESS;
    }

    // No @Override to tolerate mapping differences
    public void inventoryTick(net.minecraft.item.ItemStack stack, World world, net.minecraft.entity.Entity entity, int slot, boolean selected) {
        if (world.isClient) return;
        if (!(entity instanceof ServerPlayerEntity sp)) return;
        if (!PlayerVars.hasTntSchedule(sp)) return;
        long now = world.getTime();
        long next = PlayerVars.getTntNextTick(sp);
        if (now < next) return;
        Vec3d target = PlayerVars.getTntTarget(sp);
        if (target == null) { PlayerVars.clearTnt(sp); return; }
        if (world instanceof ServerWorld server) {
            TntEntity tnt = new TntEntity(server, target.x, target.y, target.z, sp);
            server.spawnEntity(tnt);
            world.playSound(null, BlockPos.ofFloored(target), SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.PLAYERS, 1.0f, 1.0f);
            if (!sp.isCreative()) stack.damage(100, sp);
        }
        int rem = PlayerVars.getTntRemaining(sp) - 1;
        if (rem <= 0) {
            PlayerVars.clearTnt(sp);
        } else {
            PlayerVars.setTntRemaining(sp, rem);
            PlayerVars.setTntNextTick(sp, now + 10); // every 0.5s
        }
    }
}
