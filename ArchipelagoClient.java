package com.thatoneaiguy.archipelago;

import com.thatoneaiguy.archipelago.init.ArchipelagoBlocks;
import com.thatoneaiguy.archipelago.init.ArchipelagoEntities;
import com.thatoneaiguy.archipelago.init.ArchipelagoParticles;
import com.thatoneaiguy.archipelago.packet.VaseBreakPacket;
import com.thatoneaiguy.archipelago.particle.VaseBreakParticle;
//import com.thatoneaiguy.archipelago.render.GooberRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.math.Vec3d;

public class ArchipelagoClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ParticleFactoryRegistry.getInstance().register(ArchipelagoParticles.VASE_BREAK_PARTICLE, VaseBreakParticle.Factory::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ArchipelagoBlocks.ASTRAL_VASE, RenderLayer.getCutout());

        BlockRenderLayerMap.INSTANCE.putBlock(ArchipelagoBlocks.CRYSTAL_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArchipelagoBlocks.CRYSTAL_SAPLING, RenderLayer.getCutout());

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
