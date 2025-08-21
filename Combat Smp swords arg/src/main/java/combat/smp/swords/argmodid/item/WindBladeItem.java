package combat.smp.swords.argmodid.item;

import combat.smp.swords.argmodid.util.Cooldowns;
import combat.smp.swords.argmodid.util.PlayerVars;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class WindBladeItem extends BaseDurableItem {
    private static final String CD_KEY = "wind_blade_reset";

    public WindBladeItem(Settings settings) { super(settings, 895); }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            ServerPlayerEntity sp = (ServerPlayerEntity) user;
            boolean onGround = user.isOnGround();
            if (onGround) {
                if (Cooldowns.ready(sp, CD_KEY, world)) {
                    PlayerVars.setWindJumps(sp, 4);
                    Cooldowns.set(sp, CD_KEY, world, 100);
                    user.sendMessage(net.minecraft.text.Text.literal("Wind Blade jumps recharged (4)"), true);
                } else {
                    int left = Cooldowns.remainingSeconds(sp, CD_KEY, world);
                    user.sendMessage(net.minecraft.text.Text.literal("Recharge in " + left + "s"), true);
                }
                return ActionResult.SUCCESS;
            }
            // air use: attempt a jump if any remain
            int jumps = PlayerVars.getWindJumps(sp);
            if (jumps > 0) {
                PlayerVars.setWindJumps(sp, jumps - 1);
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 200, 0));
                var v = user.getVelocity();
                user.setVelocity(v.x, Math.max(0.5, v.y + 0.5), v.z);
                user.velocityModified = true;
                world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_PHANTOM_FLAP, SoundCategory.PLAYERS, 0.6f, 1.2f);
                user.sendMessage(net.minecraft.text.Text.literal("Jumps left: " + (jumps - 1)), true);
                return ActionResult.SUCCESS;
            } else {
                user.sendMessage(net.minecraft.text.Text.literal("No jumps left. Right-click on ground to recharge."), true);
                return ActionResult.FAIL;
            }
        }
        return ActionResult.SUCCESS;
    }
}
