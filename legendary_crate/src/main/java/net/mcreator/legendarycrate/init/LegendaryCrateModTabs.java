/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.legendarycrate.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.core.registries.Registries;

import net.mcreator.legendarycrate.LegendaryCrateMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class LegendaryCrateModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LegendaryCrateMod.MODID);

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(LegendaryCrateModItems.WIND_BLADE.get());
			tabData.accept(LegendaryCrateModItems.CHORUS_SLAYER.get());
			tabData.accept(LegendaryCrateModItems.THUNDER_SWORD.get());
			tabData.accept(LegendaryCrateModItems.PHANTOM_BLADE.get());
			tabData.accept(LegendaryCrateModItems.TNT_SWORD.get());
			tabData.accept(LegendaryCrateModItems.WARDEN_BLASTER.get());
			tabData.accept(LegendaryCrateModItems.DRAGON_SLAYER.get());
			tabData.accept(LegendaryCrateModItems.LIFE_STEALER.get());
			tabData.accept(LegendaryCrateModItems.EARTH_WAVE_SWORD.get());
			tabData.accept(LegendaryCrateModItems.GODSVIEW.get());
			tabData.accept(LegendaryCrateModItems.BREACHER.get());
			tabData.accept(LegendaryCrateModItems.GHOST_BLADE.get());
			tabData.accept(LegendaryCrateModItems.BERSERK_HAND.get());
			tabData.accept(LegendaryCrateModItems.ANCIENT_VOID_RELIC.get());
			tabData.accept(LegendaryCrateModItems.AMETHYST_SWORD.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(LegendaryCrateModItems.AMETYHST_PICKAXE.get());
			tabData.accept(LegendaryCrateModItems.LEVITATION_WAND.get());
			tabData.accept(LegendaryCrateModItems.TNT_ROD.get());
			tabData.accept(LegendaryCrateModItems.CHAOS_CRYSTAL.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(LegendaryCrateModItems.GRAY_APPLE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
			tabData.accept(LegendaryCrateModItems.REINFORCED_STICK.get());
			tabData.accept(LegendaryCrateModItems.CORROSIVE_DUST.get());
			tabData.accept(LegendaryCrateModItems.XP_ORBABERCRAFTINGRECIPIHEISTLEIDERXPORB.get());
			tabData.accept(LegendaryCrateModItems.SHARPENED_AMETHYST_SHARD.get());
		}
	}
}