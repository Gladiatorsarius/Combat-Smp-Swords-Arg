package combat.smp.swords.argmodid.item;

import combat.smp.swords.argmodid.CombatSmpSwordsArg;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class TestItems {
    public static final Item TEST_ITEM = Registry.register(
        Registries.ITEM,
        Identifier.of(CombatSmpSwordsArg.MOD_ID, "test_item"),
        new Item(new Item.Settings())
    );
    
    public static void register() {
        CombatSmpSwordsArg.LOGGER.info("Test item registered: " + TEST_ITEM);
    }
}
