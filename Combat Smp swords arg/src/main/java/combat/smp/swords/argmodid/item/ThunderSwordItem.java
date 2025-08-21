package combat.smp.swords.argmodid.item;

import combat.smp.swords.argmodid.util.Cooldowns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class ThunderSwordItem extends BaseDurableItem {
    private static final String CD_KEY = "thunder_strike";

    public ThunderSwordItem(Settings settings) { super(settings, 5300); }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            net.minecraft.server.network.ServerPlayerEntity sp = (net.minecraft.server.network.ServerPlayerEntity) user;
            if (!Cooldowns.ready(sp, CD_KEY, world)) {
                int sec = Cooldowns.remainingSeconds(sp, CD_KEY, world);
                sp.sendMessage(net.minecraft.text.Text.literal("Ability on Cooldown (" + sec + "s)"), true);
                return ActionResult.FAIL;
            }
            // Find targets between radius 2..10
            Box box = new Box(user.getX()-10, user.getY()-10, user.getZ()-10, user.getX()+10, user.getY()+10, user.getZ()+10);
            List<Entity> entities = world.getOtherEntities(user, box, e -> e instanceof LivingEntity && user.distanceTo(e) >= 2.0f && user.distanceTo(e) <= 10.0f);
            if (world instanceof ServerWorld server) {
                for (Entity e : entities) {
                    if (e instanceof LivingEntity le && e != user) {
                        BlockPos pos = e.getBlockPos();
                        LightningEntity bolt = net.minecraft.entity.EntityType.LIGHTNING_BOLT.create(server, null, pos, SpawnReason.TRIGGERED, true, true);
                        if (bolt != null) {
                            server.spawnEntity(bolt);
                        }
                        le.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 60, 9));
                        le.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 60, 9));
                        le.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 60, 250));
                    }
                }
            }
            user.playSound(SoundEvents.ENTITY_LIGHTNING_BOLT_THUNDER, 1f, 1f);
            Cooldowns.set(sp, CD_KEY, world, 240); // 12s
        }
        return ActionResult.SUCCESS;
    }
}
