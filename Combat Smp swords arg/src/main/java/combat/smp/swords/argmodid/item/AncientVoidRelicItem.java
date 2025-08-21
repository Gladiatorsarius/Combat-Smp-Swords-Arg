package combat.smp.swords.argmodid.item;

import combat.smp.swords.argmodid.util.PlayerVars;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class AncientVoidRelicItem extends BaseDurableItem {
    public AncientVoidRelicItem(Settings settings) { super(settings, 100); }

    // No @Override to tolerate mapping differences
    public void inventoryTick(net.minecraft.item.ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (world.isClient) return;
        if (!(entity instanceof ServerPlayerEntity sp)) return;
        boolean holding = sp.getMainHandStack() == stack || sp.getOffHandStack() == stack;
        if (holding) {
            int charge = PlayerVars.getVoidRelicCharge(sp) + 1;
            if (charge >= 12000) {
                if (!PlayerVars.isVoidRelicPowerActive(sp, world)) {
                    PlayerVars.startVoidRelicPower(sp, world, 80); // 4s window
                    sp.sendMessage(Text.literal("The Void Tentacels trust you now! Use there powers quick!"), true);
                }
                PlayerVars.setVoidRelicCharge(sp, 12000); // clamp
            } else {
                PlayerVars.setVoidRelicCharge(sp, charge);
            }
        }
        // If window expired without use, partial reset to 6000
        if (!PlayerVars.isVoidRelicPowerActive(sp, world) && PlayerVars.getVoidRelicCharge(sp) == 12000) {
            PlayerVars.setVoidRelicCharge(sp, 6000);
            sp.sendMessage(Text.literal("The Void Tentacels lost trust in you!"), true);
        }
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) return ActionResult.SUCCESS;
        ServerPlayerEntity sp = (ServerPlayerEntity) user;
        if (!PlayerVars.isVoidRelicPowerActive(sp, world)) {
            // Show charge progress when right-clicking before fully charged
            int charge = PlayerVars.getVoidRelicCharge(sp);
            int progress = charge / 10; // Divide by 10 as specified
            user.sendMessage(Text.literal("Hold on tight " + progress), true);
            return ActionResult.FAIL;
        }
        // pick up to 5 random living entities within 30 blocks, excluding players
        Box box = new Box(user.getX()-30, user.getY()-30, user.getZ()-30, user.getX()+30, user.getY()+30, user.getZ()+30);
        List<Entity> candidates = world.getOtherEntities(user, box, e -> e instanceof LivingEntity && !(e instanceof PlayerEntity));
        java.util.Collections.shuffle(candidates, new Random());
        int count = 0;
        for (Entity e : candidates) {
            if (count >= 5) break;
            e.setPosition(e.getX(), -67, e.getZ());
            count++;
        }
        // reset state after use
        PlayerVars.setVoidRelicCharge(sp, 0);
        PlayerVars.clearVoidRelicPower(sp);
        return ActionResult.SUCCESS;
    }
}
