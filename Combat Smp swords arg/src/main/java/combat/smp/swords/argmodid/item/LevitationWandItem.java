package combat.smp.swords.argmodid.item;

import combat.smp.swords.argmodid.util.Cooldowns;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class LevitationWandItem extends BaseDurableItem {
    private static final String CD_KEY = "levitation_wand";

    public LevitationWandItem(Settings settings) { super(settings.maxCount(1), 1000); }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) return ActionResult.SUCCESS;
        ServerPlayerEntity sp = (ServerPlayerEntity) user;
        if (!Cooldowns.ready(sp, CD_KEY, world)) {
            int s = Cooldowns.remainingSeconds(sp, CD_KEY, world);
            sp.sendMessage(Text.literal("Wartezeit: "+s+"s"), true);
            return ActionResult.FAIL;
        }

        Vec3d look = user.getRotationVec(1.0f).normalize();
        Box box = new Box(user.getBlockPos()).expand(10);
        int affected = 0;
    for (Entity e : world.getOtherEntities(user, box, ent -> ent.isAlive() && ent != user)) {
            Vec3d push = look.multiply(1.2).add(0, 0.5, 0);
            e.addVelocity(push.x, push.y, push.z);
            if (e instanceof net.minecraft.entity.LivingEntity le) {
                le.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 60, 0));
            }
            affected++;
        }
        world.playSound(null, user.getBlockPos(), SoundEvents.ENTITY_SHULKER_SHOOT, SoundCategory.PLAYERS, 1.0f, 1.1f);
        if (!user.isCreative()) {
            ItemStack stack = user.getStackInHand(hand);
            stack.damage(Math.max(1, affected / 2), user);
        }
        Cooldowns.set(sp, CD_KEY, world, 20 * 8);
        return ActionResult.SUCCESS;
    }
}
