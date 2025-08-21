package combat.smp.swords.argmodid.item;

import combat.smp.swords.argmodid.util.Cooldowns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

public class GodsViewItem extends BaseDurableItem {
    private static final String CD_KEY = "gods_view";

    public GodsViewItem(Settings settings) { super(settings, 290); }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            net.minecraft.server.network.ServerPlayerEntity sp = (net.minecraft.server.network.ServerPlayerEntity) user;
            if (!Cooldowns.ready(sp, CD_KEY, world)) {
                int sec = Cooldowns.remainingSeconds(sp, CD_KEY, world);
                sp.sendMessage(net.minecraft.text.Text.literal("Ability on Cooldown (" + sec + "s)"), true);
                return ActionResult.FAIL;
            }
            Box box = new Box(user.getX()-80, user.getY()-80, user.getZ()-80, user.getX()+80, user.getY()+80, user.getZ()+80);
            List<Entity> list = world.getOtherEntities(user, box, e -> e instanceof PlayerEntity && e != user);
            for (Entity e : list) {
                if (e instanceof PlayerEntity p) {
                    p.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 100, 0));
                }
            }
            if (world instanceof ServerWorld server) {
                BlockPos pos = user.getBlockPos();
                var bolt = net.minecraft.entity.EntityType.LIGHTNING_BOLT.create(server, null, pos, net.minecraft.entity.SpawnReason.TRIGGERED, true, true);
                if (bolt != null) server.spawnEntity(bolt);
            }
            world.playSound(null, user.getBlockPos(), SoundEvents.BLOCK_BEACON_ACTIVATE, SoundCategory.PLAYERS, 1.0f, 1.0f);
            Cooldowns.set(sp, CD_KEY, world, 300);
        }
        return ActionResult.SUCCESS;
    }
}
