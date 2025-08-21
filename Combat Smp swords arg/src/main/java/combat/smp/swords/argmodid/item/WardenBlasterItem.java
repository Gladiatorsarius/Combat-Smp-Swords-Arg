package combat.smp.swords.argmodid.item;

import combat.smp.swords.argmodid.util.Cooldowns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class WardenBlasterItem extends BaseDurableItem {
    private static final String CD_KEY = "warden_blast";

    public WardenBlasterItem(Settings settings) { super(settings, 7900); }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            var sp = (net.minecraft.server.network.ServerPlayerEntity) user;
            if (!Cooldowns.ready(sp, CD_KEY, world)) {
                int sec = Cooldowns.remainingSeconds(sp, CD_KEY, world);
                sp.sendMessage(net.minecraft.text.Text.literal("Ability on Cooldown (" + sec + "s)"), true);
                return ActionResult.FAIL;
            }
            Vec3d dir = user.getRotationVec(1.0f).normalize();
            Vec3d start = user.getEyePos();
            if (world instanceof ServerWorld server) {
                // Particles along 10-block beam
                int steps = 20;
                for (int i = 1; i <= steps; i++) {
                    Vec3d p = start.add(dir.multiply(i * (10.0 / steps)));
                    server.spawnParticles(ParticleTypes.SONIC_BOOM, p.x, p.y, p.z, 1, 0, 0, 0, 0);
                }
                // Damage entities in a thin box along the beam
                for (int i = 1; i <= 10; i++) {
                    Vec3d p = start.add(dir.multiply(i));
                    Box box = new Box(p.x - 0.8, p.y - 0.8, p.z - 0.8, p.x + 0.8, p.y + 0.8, p.z + 0.8);
                    List<Entity> list = world.getOtherEntities(user, box, e -> e instanceof LivingEntity && e != user);
                    for (Entity e : list) {
                        double dist = user.squaredDistanceTo(e);
                        float base = 10.0f; // strong hit near player
                        float dmg = Math.max(3.0f, (float)(base - (Math.sqrt(dist))));
                        ((LivingEntity)e).damage(server, server.getDamageSources().sonicBoom(user), dmg);
                    }
                }
            }
            world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_WARDEN_SONIC_BOOM, SoundCategory.PLAYERS, 1.0f, 1.0f);
            Cooldowns.set(sp, CD_KEY, world, 600);
        }
        return ActionResult.SUCCESS;
    }
}
