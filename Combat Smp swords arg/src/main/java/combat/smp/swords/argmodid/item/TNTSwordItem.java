package combat.smp.swords.argmodid.item;

import combat.smp.swords.argmodid.util.Cooldowns;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.TntMinecartEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class TNTSwordItem extends BaseDurableItem {
    private static final String CD_KEY = "tnt_sword";

    public TNTSwordItem(Settings settings) { super(settings, 2100); }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) return ActionResult.SUCCESS;
        ServerPlayerEntity sp = (ServerPlayerEntity) user;
        if (!Cooldowns.ready(sp, CD_KEY, world)) {
            int sec = Cooldowns.remainingSeconds(sp, CD_KEY, world);
            sp.sendMessage(net.minecraft.text.Text.literal("Ability on Cooldown (" + sec + "s)"), true);
            return ActionResult.FAIL;
        }
        // Raycast to a block within reach
        HitResult hr = raycast(world, user, RaycastContext.FluidHandling.NONE);
        if (!(hr instanceof BlockHitResult bhr)) return ActionResult.FAIL;
        BlockPos base = bhr.getBlockPos().offset(bhr.getSide());
        // Spawn minecart TNT at block top center and launch upwards
        if (world instanceof ServerWorld server) {
            TntMinecartEntity cart = EntityType.TNT_MINECART.create(server, null, base, net.minecraft.entity.SpawnReason.TRIGGERED, true, true);
            if (cart != null) {
                cart.setPosition(base.getX() + 0.5, base.getY() + 0.1, base.getZ() + 0.5);
                cart.setVelocity(new Vec3d(0, 1.5, 0));
                server.spawnEntity(cart);
                world.playSound(null, base, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.PLAYERS, 1.0f, 1.0f);
            }
        }
        Cooldowns.set(sp, CD_KEY, world, 320);
        return ActionResult.SUCCESS;
    }
}
