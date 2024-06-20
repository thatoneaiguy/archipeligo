package com.thatoneaiguy.archipelago;

import com.thatoneaiguy.archipelago.packet.VaseBreakPacket;
import com.thatoneaiguy.archipelago.particle.VaseBreakParticle;
import com.thatoneaiguy.archipelago.register.ArchipelagoBlocks;
import com.thatoneaiguy.archipelago.register.ArchipelagoParticles;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.math.Vec3d;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.quiltmc.qsl.networking.api.client.ClientPlayNetworking;

public class ArchipelagoClient implements ClientModInitializer {

	@Override
	public void onInitializeClient(ModContainer mod) {

		ParticleFactoryRegistry.getInstance().register(ArchipelagoParticles.VASE_BREAK_PARTICLE, VaseBreakParticle.Factory::new);

		BlockRenderLayerMap.INSTANCE.putBlock(ArchipelagoBlocks.ASTRAL_VASE, RenderLayer.getCutout());

		ClientPlayNetworking.registerGlobalReceiver(VaseBreakPacket.ID, ((client, handler, buf, responseSender) -> {
			Vec3d position = new Vec3d(buf.readDouble(), buf.readDouble(), buf.readDouble());
			client.execute(() -> {
				ClientPlayerEntity player = client.player;
				if (player != null) {
					client.player.world.addParticle(ArchipelagoParticles.VASE_BREAK_PARTICLE, position.getX(), position.getY(), position.getZ(), 0.0, 0.0, 0.0);
					double distance = player.getPos().distanceTo(position);
				}

			});
		}));
	}
}
