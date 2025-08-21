package combat.smp.swords.argmodid.item;

import combat.smp.swords.argmodid.util.Cooldowns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Comparator;
import java.util.List;

public class GhostBladeItem extends BaseDurableItem {
    private static final String CD_KEY = "ghost_dash";

    public GhostBladeItem(Settings settings) { super(settings, 6150); }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            net.minecraft.server.network.ServerPlayerEntity sp = (net.minecraft.server.network.ServerPlayerEntity) user;
            if (!Cooldowns.ready(sp, CD_KEY, world)) {
                int sec = Cooldowns.remainingSeconds(sp, CD_KEY, world);
                sp.sendMessage(net.minecraft.text.Text.literal("Ability on Cooldown (" + sec + "s)"), true);
                return ActionResult.FAIL;
            }
            // Dash ~2 blocks forward
            Vec3d dir = user.getRotationVec(1.0f).normalize();
            user.setVelocity(dir.multiply(2.0));
            user.velocityModified = true;
            // Invisibility 3s
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 60, 0));
            // Next entity within 4 blocks: 6 out_of_world damage
            Box box = new Box(user.getX()-4, user.getY()-4, user.getZ()-4, user.getX()+4, user.getY()+4, user.getZ()+4);
            List<Entity> list = world.getOtherEntities(user, box, e -> e instanceof LivingEntity && e != user);
            if (world instanceof ServerWorld server) {
                list.stream().sorted(Comparator.comparingDouble(user::distanceTo)).findFirst().ifPresent(e -> {
                    if (e instanceof LivingEntity le) {
                        le.damage(server, server.getDamageSources().outOfWorld(), 6.0f);
                    }
                });
            }
            Cooldowns.set(sp, CD_KEY, world, 200); // 10s
        }
        return ActionResult.SUCCESS;
    }
}
