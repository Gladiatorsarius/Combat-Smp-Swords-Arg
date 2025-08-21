package combat.smp.swords.argmodid.item;

import net.minecraft.item.Item;

public class BaseDurableItem extends Item {
    public BaseDurableItem(Settings settings, int durability) { super(settings.maxDamage(durability)); }
}
