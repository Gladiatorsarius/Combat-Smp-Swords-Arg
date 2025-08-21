package combat.smp.swords.argmodid.item;

import combat.smp.swords.argmodid.CombatSmpSwordsArg;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

// Item registrations (abilities will be added later)
public class ModItems {
    // Weapons / tools with dedicated classes
    public static final Item AMETHYST_SWORD = register("amethyst_sword", settings -> new AmethystSwordItem(settings.fireproof()));
    public static final Item AMETHYST_PICKAXE = register("amethyst_pickaxe", settings -> new AmethystPickaxeItem(settings.maxCount(1)));
    public static final Item ANCIENT_VOID_RELIC = register("ancient_void_relic", AncientVoidRelicItem::new);
    public static final Item BERSERK_HAND = register("berserk_hand", BerserkHandItem::new);
    public static final Item BREACHER = register("breacher", BreacherItem::new);
    public static final Item CHORUS_SLAYER = register("chorus_slayer", ChorusSlayerItem::new);
    public static final Item DRAGON_SLAYER = register("dragon_slayer", DragonSlayerItem::new);
    public static final Item DRIPSTONE_SWORD = register("dripstone_sword", EarthWaveSwordItem::new);
    public static final Item GHOST_BLADE = register("ghost_blade", GhostBladeItem::new);
    public static final Item GODS_VIEW = register("gods_view", GodsViewItem::new);
    public static final Item LIFE_STEALER = register("life_stealer", LifeStealerItem::new);
    public static final Item PHANTOM_BLADE = register("phantom_blade", PhantomBladeItem::new);
    public static final Item THUNDER_SWORD = register("thunder_sword", settings -> new ThunderSwordItem(settings.fireproof()));
    public static final Item TNT_ROD = register("tnt_rod", TNTRodItem::new);
    public static final Item TNT_SWORD = register("tnt_sword", TNTSwordItem::new);
    public static final Item WARDEN_BLASTER = register("warden_blaster", WardenBlasterItem::new);
    public static final Item WIND_BLADE = register("wind_blade", WindBladeItem::new);
    public static final Item LEVITATION_WAND = register("levitation_wand", settings -> new LevitationWandItem(settings.maxCount(1)));

    // Materials / misc
    public static final Item REINFORCED_STICK = registerSimple("reinforced_stick");
    public static final Item SHARPENED_AMETHYST_SHARD = registerSimple("sharpened_amethyst_shard");
    public static final Item CHAOS_CRYSTAL = register("chaos_crystal", ChaosCrystalItem::new);
    public static final Item CORROSIVE_DUST = register("corrosive_dust", CorrosiveDustItem::new);
    public static final Item XP_ORB = registerSimple("xp_orb");
    public static final Item GRAY_APPLE = register("gray_apple", GrayAppleItem::new);
    
    // Potions
    public static final Item CORROSIVE_FIRE_POTION = register("corrosive_fire_potion", CorrosiveFirePotionItem::new);
    public static final Item INSTANT_XP_POTION = register("instant_xp_potion", InstantXPPotionItem::new);
    public static final Item PVP_POTION = register("pvp_potion", PVPPotionItem::new);

    private static Item registerSimple(String name) {
        return register(name, Item::new);
    }

    private static Item register(String name, java.util.function.Function<Item.Settings, Item> factory) {
        Identifier id = Identifier.of(CombatSmpSwordsArg.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        Item.Settings settings = new Item.Settings().registryKey(key);
        Item item = factory.apply(settings);
        return Registry.register(Registries.ITEM, id, item);
    }

    public static void registerModItems() { 
        // Force class loading to trigger static field initialization
        CombatSmpSwordsArg.LOGGER.info("[Init] Registering items...");
        
        // Access all static fields to ensure they are initialized
        Item[] items = {
            AMETHYST_SWORD, AMETHYST_PICKAXE, ANCIENT_VOID_RELIC, BERSERK_HAND,
            BREACHER, CHORUS_SLAYER, DRAGON_SLAYER, DRIPSTONE_SWORD,
            GHOST_BLADE, GODS_VIEW, LIFE_STEALER, PHANTOM_BLADE,
            THUNDER_SWORD, TNT_ROD, TNT_SWORD, WARDEN_BLASTER,
            WIND_BLADE, LEVITATION_WAND, REINFORCED_STICK, SHARPENED_AMETHYST_SHARD,
            CHAOS_CRYSTAL, CORROSIVE_DUST, XP_ORB, GRAY_APPLE, CORROSIVE_FIRE_POTION,
            INSTANT_XP_POTION, PVP_POTION
        };
        
        CombatSmpSwordsArg.LOGGER.info("[Init] Registered " + items.length + " items successfully!");
    }
}
