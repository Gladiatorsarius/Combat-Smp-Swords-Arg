/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.legendarycrate.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;

import net.minecraft.world.item.Item;

import net.mcreator.legendarycrate.item.XPOrbabercraftingrecipiheistleiderxporbItem;
import net.mcreator.legendarycrate.item.WindBladeItem;
import net.mcreator.legendarycrate.item.WardenBlasterItem;
import net.mcreator.legendarycrate.item.TntSwordItem;
import net.mcreator.legendarycrate.item.ThunderSwordItem;
import net.mcreator.legendarycrate.item.TesttoolItem;
import net.mcreator.legendarycrate.item.TNTRodItem;
import net.mcreator.legendarycrate.item.SharpenedAmethystShardItem;
import net.mcreator.legendarycrate.item.ReinforcedStickItem;
import net.mcreator.legendarycrate.item.PhantomBladeItem;
import net.mcreator.legendarycrate.item.LifeStealerItem;
import net.mcreator.legendarycrate.item.LevitationWandItem;
import net.mcreator.legendarycrate.item.GrayAppleItem;
import net.mcreator.legendarycrate.item.GhostBladeItem;
import net.mcreator.legendarycrate.item.EarthWaveSwordItem;
import net.mcreator.legendarycrate.item.DragonSlayerItem;
import net.mcreator.legendarycrate.item.CorrosiveDustItem;
import net.mcreator.legendarycrate.item.ChorusSlayerItem;
import net.mcreator.legendarycrate.item.ChaosCrystalItem;
import net.mcreator.legendarycrate.item.BreacherItem;
import net.mcreator.legendarycrate.item.BerserkHandItem;
import net.mcreator.legendarycrate.item.AncientVoidRelicItem;
import net.mcreator.legendarycrate.item.AmetyhstPickaxeItem;
import net.mcreator.legendarycrate.item.AmethystSwordItem;
import net.mcreator.legendarycrate.LegendaryCrateMod;

import java.util.function.Function;

public class LegendaryCrateModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(LegendaryCrateMod.MODID);
	public static final DeferredItem<Item> WIND_BLADE = register("wind_blade", WindBladeItem::new);
	public static final DeferredItem<Item> CHORUS_SLAYER = register("chorus_slayer", ChorusSlayerItem::new);
	public static final DeferredItem<Item> AMETYHST_PICKAXE = register("ametyhst_pickaxe", AmetyhstPickaxeItem::new);
	public static final DeferredItem<Item> THUNDER_SWORD = register("thunder_sword", ThunderSwordItem::new);
	public static final DeferredItem<Item> PHANTOM_BLADE = register("phantom_blade", PhantomBladeItem::new);
	public static final DeferredItem<Item> TNT_SWORD = register("tnt_sword", TntSwordItem::new);
	public static final DeferredItem<Item> WARDEN_BLASTER = register("warden_blaster", WardenBlasterItem::new);
	public static final DeferredItem<Item> GRAY_APPLE = register("gray_apple", GrayAppleItem::new);
	public static final DeferredItem<Item> DRAGON_SLAYER = register("dragon_slayer", DragonSlayerItem::new);
	public static final DeferredItem<Item> LIFE_STEALER = register("life_stealer", LifeStealerItem::new);
	public static final DeferredItem<Item> EARTH_WAVE_SWORD = register("earth_wave_sword", EarthWaveSwordItem::new);
	public static final DeferredItem<Item> LEVITATION_WAND = register("levitation_wand", LevitationWandItem::new);
	public static final DeferredItem<Item> REINFORCED_STICK = register("reinforced_stick", ReinforcedStickItem::new);
	public static final DeferredItem<Item> TNT_ROD = register("tnt_rod", TNTRodItem::new);
	public static final DeferredItem<Item> GODSVIEW = register("godsview", TesttoolItem::new);
	public static final DeferredItem<Item> BREACHER = register("breacher", BreacherItem::new);
	public static final DeferredItem<Item> GHOST_BLADE = register("ghost_blade", GhostBladeItem::new);
	public static final DeferredItem<Item> BERSERK_HAND = register("berserk_hand", BerserkHandItem::new);
	public static final DeferredItem<Item> ANCIENT_VOID_RELIC = register("ancient_void_relic", AncientVoidRelicItem::new);
	public static final DeferredItem<Item> AMETHYST_SWORD = register("amethyst_sword", AmethystSwordItem::new);
	public static final DeferredItem<Item> CORROSIVE_DUST = register("corrosive_dust", CorrosiveDustItem::new);
	public static final DeferredItem<Item> XP_ORBABERCRAFTINGRECIPIHEISTLEIDERXPORB = register("xp_orbabercraftingrecipiheistleiderxporb", XPOrbabercraftingrecipiheistleiderxporbItem::new);
	public static final DeferredItem<Item> SHARPENED_AMETHYST_SHARD = register("sharpened_amethyst_shard", SharpenedAmethystShardItem::new);
	public static final DeferredItem<Item> CHAOS_CRYSTAL = register("chaos_crystal", ChaosCrystalItem::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}
}