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
import net.minecraft.world.World;

public class PhantomBladeItem extends BaseDurableItem {
    private static final String CD_KEY = "phantom_invis";

    public PhantomBladeItem(Settings settings) { super(settings, 300); }

    // No @Override to tolerate mapping differences
    public void inventoryTick(net.minecraft.item.ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!(entity instanceof PlayerEntity player)) return;
        if (player.getOffHandStack() == stack) {
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 2, 2, true, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 2, 2, true, false));
            player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 2, 1, true, false));
            if (!world.isClient && world.getTime() % 20 == 0) {
                if (world.random.nextInt(10) == 1) {
                    if (world instanceof ServerWorld server) {
                        var bolt = net.minecraft.entity.EntityType.LIGHTNING_BOLT.create(server, null, player.getBlockPos(), net.minecraft.entity.SpawnReason.TRIGGERED, true, true);
                        if (bolt != null) server.spawnEntity(bolt);
                    }
                }
            }
        }
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            var sp = (net.minecraft.server.network.ServerPlayerEntity) user;
            if (!Cooldowns.ready(sp, CD_KEY, world)) {
                int sec = Cooldowns.remainingSeconds(sp, CD_KEY, world);
                sp.sendMessage(net.minecraft.text.Text.literal("Ability on Cooldown (" + sec + "s)"), true);
                return ActionResult.FAIL;
            }
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 200, 0, false, false));
            world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_PHANTOM_AMBIENT, SoundCategory.PLAYERS, 0.7f, 1.2f);
            Cooldowns.set(sp, CD_KEY, world, 300);
        }
        return ActionResult.SUCCESS;
    }
}
