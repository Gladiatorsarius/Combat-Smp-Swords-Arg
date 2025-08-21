package combat.smp.swords.argmodid.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class CorrosiveDustItem extends Item {
    public CorrosiveDustItem(Settings settings) { super(settings); }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            user.sendMessage(net.minecraft.text.Text.literal("Brew with a Water Bottle to create Corrosive Fire Potion."), true);
        }
        return ActionResult.FAIL;
    }
}
