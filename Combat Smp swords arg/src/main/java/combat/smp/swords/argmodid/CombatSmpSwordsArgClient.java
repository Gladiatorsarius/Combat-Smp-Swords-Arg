package combat.smp.swords.argmodid;

import combat.smp.swords.argmodid.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;

public class CombatSmpSwordsArgClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // Add sword items to vanilla Combat tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(ModItems.AMETHYST_SWORD);
            entries.add(ModItems.ANCIENT_VOID_RELIC);
            entries.add(ModItems.BERSERK_HAND);
            entries.add(ModItems.BREACHER);
            entries.add(ModItems.CHORUS_SLAYER);
            entries.add(ModItems.DRAGON_SLAYER);
            entries.add(ModItems.DRIPSTONE_SWORD);
            entries.add(ModItems.GHOST_BLADE);
            entries.add(ModItems.GODS_VIEW);
            entries.add(ModItems.LIFE_STEALER);
            entries.add(ModItems.PHANTOM_BLADE);
            entries.add(ModItems.THUNDER_SWORD);
            entries.add(ModItems.TNT_SWORD);
            entries.add(ModItems.WARDEN_BLASTER);
            entries.add(ModItems.WIND_BLADE);
        });
        
        // Add tools to vanilla Tools tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(ModItems.AMETHYST_PICKAXE); // Furnace Pickaxe
            entries.add(ModItems.TNT_ROD);
            entries.add(ModItems.LEVITATION_WAND);
        });
        
        // Add materials to vanilla Ingredients tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModItems.REINFORCED_STICK);
            entries.add(ModItems.SHARPENED_AMETHYST_SHARD);
            entries.add(ModItems.CHAOS_CRYSTAL);
            entries.add(ModItems.CORROSIVE_DUST);
            entries.add(ModItems.XP_ORB);
        });
        
        // Add food to vanilla Food tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(ModItems.GRAY_APPLE);
            entries.add(ModItems.CORROSIVE_FIRE_POTION);
            entries.add(ModItems.INSTANT_XP_POTION);
            entries.add(ModItems.PVP_POTION);
        });
    }
}
