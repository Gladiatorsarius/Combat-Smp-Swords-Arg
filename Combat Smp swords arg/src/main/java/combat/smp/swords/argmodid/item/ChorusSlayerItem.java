package combat.smp.swords.argmodid.item;

import combat.smp.swords.argmodid.util.Cooldowns;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ChorusSlayerItem extends BaseDurableItem {
    private static final String CD_KEY = "chorus_dash";

    public ChorusSlayerItem(Settings settings) { super(settings, 2300); }

    private ActionResult doDash(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            net.minecraft.server.network.ServerPlayerEntity sp = (net.minecraft.server.network.ServerPlayerEntity) user;
            if (!Cooldowns.ready(sp, CD_KEY, world)) {
                int sec = Cooldowns.remainingSeconds(sp, CD_KEY, world);
                sp.sendMessage(net.minecraft.text.Text.literal("Ability on Cooldown (" + sec + "s)"), true);
                return ActionResult.FAIL;
            }
            Vec3d look = user.getRotationVec(1.0f).normalize();
            user.setVelocity(new Vec3d(look.x * 10.0, 0.2, look.z * 10.0));
            user.velocityModified = true;
            user.playSound(SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, 1f, 1f);
            ItemStack stack = user.getStackInHand(hand);
            if (!user.isCreative()) stack.damage(1, user);
            Cooldowns.set(sp, CD_KEY, world, 1200);
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        return doDash(world, user, hand);
    }
}
