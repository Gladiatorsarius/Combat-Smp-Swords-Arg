package combat.smp.swords.argmodid.util;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerVars {
    private static final Map<UUID, Integer> WIND_JUMPS = new HashMap<>();
    private static final Map<UUID, Integer> VOID_RELIC_CHARGE = new HashMap<>();
    private static final Map<UUID, Long> VOID_RELIC_POWER_UNTIL = new HashMap<>();
    private static final Map<UUID, Long> BERSERK_LAST_SOUND = new HashMap<>();

    // TNT rod scheduling
    private static final Map<UUID, Long> TNT_NEXT_TICK = new HashMap<>();
    private static final Map<UUID, Integer> TNT_REMAINING = new HashMap<>();
    private static final Map<UUID, Vec3d> TNT_TARGET = new HashMap<>();

    public static int getWindJumps(ServerPlayerEntity p) { return WIND_JUMPS.getOrDefault(p.getUuid(), 0); }
    public static void setWindJumps(ServerPlayerEntity p, int v) { WIND_JUMPS.put(p.getUuid(), v); }

    public static int getVoidRelicCharge(ServerPlayerEntity p) { return VOID_RELIC_CHARGE.getOrDefault(p.getUuid(), 0); }
    public static void setVoidRelicCharge(ServerPlayerEntity p, int v) { VOID_RELIC_CHARGE.put(p.getUuid(), v); }

    public static long getBerserkLastSound(ServerPlayerEntity p) { return BERSERK_LAST_SOUND.getOrDefault(p.getUuid(), 0L); }
    public static void setBerserkLastSound(ServerPlayerEntity p, long v) { BERSERK_LAST_SOUND.put(p.getUuid(), v); }

    public static void startVoidRelicPower(ServerPlayerEntity p, World world, int ticksWindow) {
        VOID_RELIC_POWER_UNTIL.put(p.getUuid(), world.getTime() + ticksWindow);
    }
    public static boolean isVoidRelicPowerActive(ServerPlayerEntity p, World world) {
        Long until = VOID_RELIC_POWER_UNTIL.get(p.getUuid());
        return until != null && world.getTime() < until;
    }
    public static void clearVoidRelicPower(ServerPlayerEntity p) {
        VOID_RELIC_POWER_UNTIL.remove(p.getUuid());
    }

    // TNT rod accessors
    public static void scheduleTnt(ServerPlayerEntity p, long nextTick, int remaining, Vec3d target) {
        UUID id = p.getUuid();
        TNT_NEXT_TICK.put(id, nextTick);
        TNT_REMAINING.put(id, remaining);
        TNT_TARGET.put(id, target);
    }
    public static boolean hasTntSchedule(ServerPlayerEntity p) { return TNT_REMAINING.getOrDefault(p.getUuid(), 0) > 0; }
    public static long getTntNextTick(ServerPlayerEntity p) { return TNT_NEXT_TICK.getOrDefault(p.getUuid(), Long.MAX_VALUE); }
    public static void setTntNextTick(ServerPlayerEntity p, long v) { TNT_NEXT_TICK.put(p.getUuid(), v); }
    public static int getTntRemaining(ServerPlayerEntity p) { return TNT_REMAINING.getOrDefault(p.getUuid(), 0); }
    public static void setTntRemaining(ServerPlayerEntity p, int v) { TNT_REMAINING.put(p.getUuid(), v); }
    public static Vec3d getTntTarget(ServerPlayerEntity p) { return TNT_TARGET.get(p.getUuid()); }
    public static void clearTnt(ServerPlayerEntity p) {
        UUID id = p.getUuid();
        TNT_NEXT_TICK.remove(id);
        TNT_REMAINING.remove(id);
        TNT_TARGET.remove(id);
    }

    // Clear all custom per-player variables
    public static void clearAll(ServerPlayerEntity p) {
        UUID id = p.getUuid();
        WIND_JUMPS.remove(id);
        VOID_RELIC_CHARGE.remove(id);
        VOID_RELIC_POWER_UNTIL.remove(id);
        BERSERK_LAST_SOUND.remove(id);
        TNT_NEXT_TICK.remove(id);
        TNT_REMAINING.remove(id);
        TNT_TARGET.remove(id);
    }

    // Clean any pending schedules if their timing already elapsed or target is invalid
    public static void cleanSchedules(ServerPlayerEntity p, World world) {
        if (getTntRemaining(p) > 0) {
            if (getTntTarget(p) == null || world.getTime() - getTntNextTick(p) > 200) { // 10s overdue
                clearTnt(p);
            }
        }
    }
}
