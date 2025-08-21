package combat.smp.swords.argmodid.util;

import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Cooldowns {
    private static final Map<String, Map<UUID, Long>> DATA = new HashMap<>();

    private static Map<UUID, Long> map(String key) {
        return DATA.computeIfAbsent(key, k -> new HashMap<>());
    }

    public static boolean ready(ServerPlayerEntity player, String key, World world) {
        long now = world.getTime();
        return map(key).getOrDefault(player.getUuid(), 0L) <= now;
    }

    public static void set(ServerPlayerEntity player, String key, World world, long ticks) {
        long deadline = world.getTime() + ticks;
        map(key).put(player.getUuid(), deadline);
    }

    public static int remainingSeconds(ServerPlayerEntity player, String key, World world) {
        long now = world.getTime();
        long end = map(key).getOrDefault(player.getUuid(), 0L);
        long diff = Math.max(0L, end - now);
        return (int)Math.ceil(diff / 20.0);
    }

    // Clear all cooldowns for this player across all keys
    public static void clearAll(ServerPlayerEntity player) {
        UUID id = player.getUuid();
        for (Map<UUID, Long> m : DATA.values()) {
            m.remove(id);
        }
    }
}
