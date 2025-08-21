package combat.smp.swords.argmodid.item;

import combat.smp.swords.argmodid.util.Cooldowns;
import combat.smp.swords.argmodid.util.PlayerVars;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;

public class ChaosCrystalItem extends Item {
    public ChaosCrystalItem(Settings settings) {
        super(settings);
    }

    // No @Override to tolerate mapping differences
    public void inventoryTick(ItemStack stack, net.minecraft.world.World world, net.minecraft.entity.Entity entity, int slot, boolean selected) {
        if (world.isClient) return;
        if (!(entity instanceof ServerPlayerEntity sp)) return;
        
        // According to specification: "Solange sich dieser Kristall im Inventar des Spielers befindet, 
        // werden bei jedem Tick alle oben genannten Cooldown- und Timer-Variablen permanent auf 0 (oder ihren "Bereit"-Zustand) gesetzt."
        // This means while the crystal is in inventory, all cooldowns are permanently reset every tick
        
        // Clear all cooldowns and reset player variables every tick
        Cooldowns.clearAll(sp);
        
        // Reset all cooldown variables mentioned in the specification
        PlayerVars.setWindJumps(sp, 4); // Reset wind blade jumps to full
        PlayerVars.setVoidRelicCharge(sp, 0); // Reset void relic charge
        PlayerVars.clearVoidRelicPower(sp); // Clear void relic power window
        PlayerVars.setBerserkLastSound(sp, 0L); // Reset berserk sound timer
        PlayerVars.clearTnt(sp); // Clear any TNT scheduling
        
        // Show subtle notification every 5 seconds that the crystal is active
        if (world.getTime() % 100 == 0) { // Every 5 seconds
            sp.sendMessage(Text.literal("§6✦ Chaos Crystal: All abilities ready"), true);
        }
    }
}
