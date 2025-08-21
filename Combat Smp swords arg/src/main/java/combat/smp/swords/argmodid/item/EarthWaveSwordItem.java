package combat.smp.swords.argmodid.item;

import combat.smp.swords.argmodid.util.Cooldowns;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particle.BlockStateParticleEffect;
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

public class EarthWaveSwordItem extends BaseDurableItem {
    private static final String CD_KEY = "earth_shatter";

    public EarthWaveSwordItem(Settings settings) { super(settings, 450); }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            var sp = (net.minecraft.server.network.ServerPlayerEntity) user;
            if (!Cooldowns.ready(sp, CD_KEY, world)) {
                int sec = Cooldowns.remainingSeconds(sp, CD_KEY, world);
                sp.sendMessage(net.minecraft.text.Text.literal("Ability on Cooldown (" + sec + "s)"), true);
                return ActionResult.FAIL;
            }
            // Visual 9x9 dripstone spike wave around player
            if (world instanceof ServerWorld server) {
                BlockStateParticleEffect effect = new BlockStateParticleEffect(ParticleTypes.BLOCK, Blocks.POINTED_DRIPSTONE.getDefaultState());
                Vec3d base = user.getPos();
                for (int x = -4; x <= 4; x++) {
                    for (int z = -4; z <= 4; z++) {
                        double px = base.x + x + 0.5;
                        double pz = base.z + z + 0.5;
                        server.spawnParticles(effect, px, base.y, pz, 6, 0.2, 0.1, 0.2, 0.02);
                    }
                }
                // Knock-up entities within 6 blocks
                Box box = new Box(base.x - 6, base.y - 2, base.z - 6, base.x + 6, base.y + 2, base.z + 6);
                List<Entity> list = world.getOtherEntities(user, box, e -> e instanceof LivingEntity && e != user);
                for (Entity e : list) {
                    LivingEntity le = (LivingEntity) e;
                    Vec3d v = le.getVelocity();
                    le.setVelocity(v.x, Math.max(2.0, v.y + 2.0), v.z);
                    le.velocityModified = true;
                }
            }
            world.playSound(null, user.getBlockPos(), SoundEvents.BLOCK_DRIPSTONE_BLOCK_FALL, SoundCategory.PLAYERS, 1.0f, 0.8f);
            Cooldowns.set(sp, CD_KEY, world, 400);
        }
        return ActionResult.SUCCESS;
    }
}
