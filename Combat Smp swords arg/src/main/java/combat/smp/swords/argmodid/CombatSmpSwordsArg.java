package combat.smp.swords.argmodid;

import combat.smp.swords.argmodid.item.ModItems;
import combat.smp.swords.argmodid.registry.ModEffects;
import combat.smp.swords.argmodid.registry.ModPotions;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CombatSmpSwordsArg implements ModInitializer {
	public static final String MOD_ID = "combat-smp-swords-arg";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
		
		ModEffects.register();
		ModPotions.register();
		ModItems.registerModItems();
	}
}