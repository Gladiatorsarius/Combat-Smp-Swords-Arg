package net.mcreator.legendarycrate.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mcreator.legendarycrate.LegendaryCrateMod;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class LegendaryCrateModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, LegendaryCrateMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		LegendaryCrateMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			if (!event.isWasDeath()) {
				clone.Djump = original.Djump;
				clone.Tp = original.Tp;
				clone.removeBlock = original.removeBlock;
				clone.cooldownThunder = original.cooldownThunder;
				clone.phantomwings = original.phantomwings;
				clone.tntcooldown = original.tntcooldown;
				clone.GhostBladeDash = original.GhostBladeDash;
				clone.VoidRelicTimer = original.VoidRelicTimer;
				clone.WindBladeCooldown = original.WindBladeCooldown;
				clone.WindBladeBautaReset = original.WindBladeBautaReset;
				clone.WardenBlasterCharge = original.WardenBlasterCharge;
				clone.DripstonerCooldown = original.DripstonerCooldown;
				clone.godsviewcooldown = original.godsviewcooldown;
				clone.phantominvisscooldown = original.phantominvisscooldown;
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public double Djump = 0;
		public double Tp = 0;
		public boolean removeBlock = false;
		public double cooldownThunder = 0;
		public double phantomwings = 0;
		public double tntcooldown = 0;
		public double GhostBladeDash = 0;
		public double VoidRelicTimer = 0;
		public double WindBladeCooldown = 0;
		public double WindBladeBautaReset = 0;
		public double WardenBlasterCharge = 0;
		public double DripstonerCooldown = 0;
		public double godsviewcooldown = 0;
		public double phantominvisscooldown = 0;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("Djump", Djump);
			nbt.putDouble("Tp", Tp);
			nbt.putBoolean("removeBlock", removeBlock);
			nbt.putDouble("cooldownThunder", cooldownThunder);
			nbt.putDouble("phantomwings", phantomwings);
			nbt.putDouble("tntcooldown", tntcooldown);
			nbt.putDouble("GhostBladeDash", GhostBladeDash);
			nbt.putDouble("VoidRelicTimer", VoidRelicTimer);
			nbt.putDouble("WindBladeCooldown", WindBladeCooldown);
			nbt.putDouble("WindBladeBautaReset", WindBladeBautaReset);
			nbt.putDouble("WardenBlasterCharge", WardenBlasterCharge);
			nbt.putDouble("DripstonerCooldown", DripstonerCooldown);
			nbt.putDouble("godsviewcooldown", godsviewcooldown);
			nbt.putDouble("phantominvisscooldown", phantominvisscooldown);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			Djump = nbt.getDouble("Djump");
			Tp = nbt.getDouble("Tp");
			removeBlock = nbt.getBoolean("removeBlock");
			cooldownThunder = nbt.getDouble("cooldownThunder");
			phantomwings = nbt.getDouble("phantomwings");
			tntcooldown = nbt.getDouble("tntcooldown");
			GhostBladeDash = nbt.getDouble("GhostBladeDash");
			VoidRelicTimer = nbt.getDouble("VoidRelicTimer");
			WindBladeCooldown = nbt.getDouble("WindBladeCooldown");
			WindBladeBautaReset = nbt.getDouble("WindBladeBautaReset");
			WardenBlasterCharge = nbt.getDouble("WardenBlasterCharge");
			DripstonerCooldown = nbt.getDouble("DripstonerCooldown");
			godsviewcooldown = nbt.getDouble("godsviewcooldown");
			phantominvisscooldown = nbt.getDouble("phantominvisscooldown");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(LegendaryCrateMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}